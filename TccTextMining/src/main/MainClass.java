package main;

import forms.MainWindowForm;
import gui.MainWindow;

import java.io.IOException;

import javax.swing.JOptionPane;

import dao.files.ARFFHandler;
import mining.Tokenizer;
import twitter.TwitterListener;
import utils.Constants;
import weka.core.Instances;

public class MainClass {
	public static void main(String[] args) {
//		Instances data = ARFFHandler.creatARFF();
//		//ARFFHandler.saveARFF(data);
//		String keyWords[] = {"Corinthians"};
//		
//		int option = -1;
//
//		do{
//			System.out.println("Options:\n 1- Twitter Listener\n 2- Tokenizer\n 0- Exit");
//			option = Integer.parseInt(JOptionPane.showInputDialog("Options:\n 1- Twitter Listener\n 2- Tokenizer\n 0- Exit"));
//
//			try {
//				switch(option){
//				case 1 :TwitterListener.createLitener(keyWords, data); System.in.read(); break;
//				case 2 :Tokenizer.loadARFF("dataset\\Tweets_21-08-14.arff");
//						Tokenizer.index();
//						System.in.read();
//						break;
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//
//
//		} while (option != 0);
		
		MainWindow.main(args);
	}
	
	public static void initializeWork(MainWindowForm mwf){
		String keyWords [] = mwf.getKeyWords().split(Constants.COMMA_REGEX);
		
		TwitterListener.createLitener(mwf);
		
		if(mwf.getSaveType().equals(Constants.ARFFTYPE)){
			
		}else if(mwf.getSaveType().equals(Constants.TXTTYPE)){
			
		}
	}
}
