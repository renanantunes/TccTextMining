package classifier;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerME;

import com.aliasi.classify.ConditionalClassification;
import com.aliasi.classify.LMClassifier;
import com.aliasi.lm.LanguageModel;
import com.aliasi.stats.MultivariateDistribution;

public class SentimentClassifier 
{
	String[] categories;
	LMClassifier<LanguageModel, MultivariateDistribution> classifier;
	static DoccatModel m = null;
	
	public SentimentClassifier()
	{
		try
		{
//			classifier = (LMClassifier<LanguageModel, MultivariateDistribution>) AbstractExternalizable.readObject(new File(Constants.CLASSIFIER_PATH));
//			categories = classifier.categories();
			InputStream is = new FileInputStream("teste.bin");		
			m = new DoccatModel(is);
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
	public String classify(String text)
	{
		ConditionalClassification conditionalClassification = classifier.classify(text);
		System.out.println(conditionalClassification.bestCategory());
		return conditionalClassification.bestCategory();
	}
	
	public String openNlpClassify(String inputText){
		DocumentCategorizerME myCategorizer = new DocumentCategorizerME(m);
		double[] outcomes = myCategorizer.categorize(inputText);
		String category = myCategorizer.getBestCategory(outcomes);
		return category;
	}
}
