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
	public void train(String dirPath) throws IOException
	{
		File trainDir = new File(dirPath);
		String[] categories = trainDir.list();
		int nGram = 7; //Aqui é usado entre 7 e 12, sabe-se lá pq
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
	}
}
