package mining;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import weka.core.Instances;
import weka.core.converters.ArffLoader.ArffReader;
import weka.core.tokenizers.NGramTokenizer;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

public class Tokenizer {
	private Instances inputInstances;
	private Instances outputInstances;
	
	public void loadARFF(String fileName) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			ArffReader arff = new ArffReader(reader);
			inputInstances = arff.getData();
			reader.close();
		}
		catch (IOException e) {
			System.out.println("==error Tokenizer.loadARFF()");
		}
	}
	
	public void index(){
		
		try{
			NGramTokenizer tokenizer = new NGramTokenizer();
			tokenizer.setNGramMinSize(1);
			tokenizer.setNGramMaxSize(1);
			tokenizer.setDelimiters("\\W");
			
			StringToWordVector filter = new StringToWordVector();
			filter.setInputFormat(inputInstances);
			filter.setTokenizer(tokenizer);
			filter.setWordsToKeep(1000000);
			filter.setDoNotOperateOnPerClassBasis(true);
			filter.setLowerCaseTokens(true);
			
			outputInstances = Filter.useFilter(inputInstances, filter);
		}catch(Exception e){
			System.err.println("== error Tokenizer.index()");
		}
		
	}
	
}
