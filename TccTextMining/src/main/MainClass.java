package main;

import forms.MainWindowForm;
import gui.Coletar;
import gui.MainWindow;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.files.ARFFHandler;
import mining.Tokenizer;
import twitter.TwitterListener;
import twitter.TwitterQueryManager;
import utils.ApplicationUtils;
import utils.Constants;
import weka.core.Instances;

public class MainClass {
	
	public static ArrayList<String> ratingList = new ArrayList<String>();
	
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
		
		if(mwf.getFetchType().equals(Constants.STREAMTYPE))
		{
			TwitterListener.createListener(mwf);
		}
		else
		{
			TwitterQueryManager tqm = new TwitterQueryManager(mwf);
			for(String inQuery: keyWords)
			{
				tqm.performQuery(inQuery, 1000);
			}
		}
		
		JOptionPane.showMessageDialog(null, ApplicationUtils.getRatingCount());
		
		if(mwf.getSaveType().equals(Constants.ARFFTYPE)){
			
		}else if(mwf.getSaveType().equals(Constants.TXTTYPE)){
			
		}
	}
}
