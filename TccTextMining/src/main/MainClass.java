package main;

import forms.MainWindowForm;
import gui.MainWindow;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import separartwitters.Main;
import twitter.Tweet;
import twitter.TwitterListener;
import twitter.TwitterQueryManager;
import utils.ApplicationUtils;
import utils.Constants;

public class MainClass {
	
	public static ArrayList<Tweet> tweetList = new ArrayList<Tweet>();

	public static void main(String[] args) {
		
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
				tqm.performQuery(inQuery, 10);
			}
		}
		
		if(JOptionPane.showConfirmDialog(null,ApplicationUtils.getRatingCount()+"\nDeseja classificar os tweets?",null, JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
			Main.initFromApp();
		}
		
		if(mwf.getSaveType().equals(Constants.ARFFTYPE)){
			
		}else if(mwf.getSaveType().equals(Constants.TXTTYPE)){
			
		}
	}
}
