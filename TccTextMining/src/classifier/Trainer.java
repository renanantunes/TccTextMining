package classifier;

import java.io.File;
import java.io.IOException;

import com.aliasi.classify.Classification;
import com.aliasi.classify.Classified;
import com.aliasi.classify.DynamicLMClassifier;
import com.aliasi.lm.NGramProcessLM;
import com.aliasi.util.AbstractExternalizable;
import com.aliasi.util.Files;

public class Trainer 
{
	/*
	 * Ao usar esse metodo, se passa o path aonde est�o as pastas Neg, Pos e Neu, ele avalia toda elas e na pasta informada cria o
	 * arquivo classifier.txt que � utilizado na classifica��o.
	 */
	public static void train(String dirPath)
	{
		try 
		{
			File trainDir = new File(dirPath);
			String[] categories = trainDir.list();
			int nGram = 7; //Aqui � usado entre 7 e 12, sabe-se l� pq
			DynamicLMClassifier<NGramProcessLM> classifier = DynamicLMClassifier.createNGramProcess(categories, nGram);
			
			for(int i=0; i < categories.length; i++)
			{
				String category = categories[i];
				Classification classification = new Classification(category);
				File file = new File(trainDir, category);
				File[] trainFiles = file.listFiles();
				for(int j=0; j < trainFiles.length; j++)
				{
					File trainFile = trainFiles[j];
					String review = Files.readFromFile(trainFile, "ISO-8859-1");
					Classified<CharSequence> classified = new Classified<CharSequence>(review, classification);
					classifier.handle(classified);
				}
			}
			AbstractExternalizable.compileTo(classifier, new File(dirPath + File.pathSeparator + "classifier.txt"));
		} catch (IOException e) 
		{
			System.err.println("===Trainer.train() error: " + e.getMessage());
		}
	}
}
