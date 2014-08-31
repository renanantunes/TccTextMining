package classifier;

import java.io.File;
import java.io.IOException;

import com.aliasi.classify.ConditionalClassification;
import com.aliasi.classify.LMClassifier;
import com.aliasi.lm.LanguageModel;
import com.aliasi.stats.MultivariateDistribution;
import com.aliasi.util.AbstractExternalizable;

public class SentimentClassifier 
{
	String[] categories;
	LMClassifier<LanguageModel, MultivariateDistribution> classifier;
	
	public SentimentClassifier(String classifierPath)
	{
		try
		{
			classifier = (LMClassifier<LanguageModel, MultivariateDistribution>) AbstractExternalizable.readObject(new File(classifierPath));
			categories = classifier.categories();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
	}
	
	/*
	 * É aqui que ocorre toda a mágica, no momento ele recebe aqui o texto a ser classificado e devolve a classificação dele
	 * Agora falta apenas implementar no nosso código, porém não sei se teremos que fazer outra tela ou o que para deixa separado
	 * classificação e coleta
	 */
	public String classify(String text)
	{
		ConditionalClassification conditionalClassification = classifier.classify(text);
		return conditionalClassification.bestCategory();
	}
}
