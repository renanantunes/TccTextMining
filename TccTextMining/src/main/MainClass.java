package main;

import arff.ARFFHandler;
import twitter.TwitterListener;
import weka.core.Instances;

public class MainClass {
	public static void main(String[] args) {
		Instances data = ARFFHandler.creatARFF();
		//ARFFHandler.saveARFF(data);
		String keyWords[] = {"globo"};
		TwitterListener.createLitener(keyWords, data);
		
	}

}
