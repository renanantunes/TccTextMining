package classifier;

import java.io.File;
import java.io.IOException;

import main.MainClass;
import utils.Constants;

import com.aliasi.classify.ConditionalClassification;
import com.aliasi.classify.LMClassifier;
import com.aliasi.lm.LanguageModel;
import com.aliasi.stats.MultivariateDistribution;
import com.aliasi.util.AbstractExternalizable;

public class SentimentClassifier 
{
	String[] categories;
	LMClassifier<LanguageModel, MultivariateDistribution> classifier;
	
	public SentimentClassifier()
	{
		try
		{
			classifier = (LMClassifier<LanguageModel, MultivariateDistribution>) AbstractExternalizable.readObject(new File(Constants.CLASSIFIER_PATH));
			categories = classifier.categories();
		}
		catch (ClassNotFoundException e)
		{
			System.err.println("===SentimentClassifier.SentimentClassifier() error: " + e.getMessage());
		}
		catch (IOException e) 
		{
			System.err.println("===SentimentClassifier.SentimentClassifier() error: " + e.getMessage());
		} 
	}
	
	/*
	 * � aqui que ocorre toda a m�gica, no momento ele recebe aqui o texto a ser classificado e devolve a classifica��o dele
	 * Agora falta apenas implementar no nosso c�digo, por�m n�o sei se teremos que fazer outra tela ou o que para deixa separado
	 * classifica��o e coleta
	 */
	public void classify(String text)
	{
		ConditionalClassification conditionalClassification = classifier.classify(text);
		MainClass.ratingList.add(conditionalClassification.bestCategory());
	}
}
