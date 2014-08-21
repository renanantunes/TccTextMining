package main;

import java.io.IOException;

import javax.swing.JOptionPane;

import mining.Tokenizer;
import twitter.TwitterListener;
import weka.core.Instances;
import arff.ARFFHandler;

public class MainClass {
	public static void main(String[] args) {
		Instances data = ARFFHandler.creatARFF();
		//ARFFHandler.saveARFF(data);
		String keyWords[] = {"Corinthians"};
		
		int option = -1;

		do{
			System.out.println("Options:\n 1- Twitter Listener\n 2- Tokenizer\n 0- Exit");
			option = Integer.parseInt(JOptionPane.showInputDialog("Options:\n 1- Twitter Listener\n 2- Tokenizer\n 0- Exit"));

			try {
				switch(option){
				case 1 :TwitterListener.createLitener(keyWords, data); System.in.read(); break;
				case 2 :Tokenizer.loadARFF("dataset\\Tweets_21-08-14.arff");
						Tokenizer.index();
						System.in.read();
						break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}


		} while (option != 0);
	}
}
