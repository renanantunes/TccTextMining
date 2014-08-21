package main;

import javax.swing.JOptionPane;

import twitter.TwitterListener;
import weka.core.Instances;
import arff.ARFFHandler;

public class MainClass {
	public static void main(String[] args) {
		Instances data = ARFFHandler.creatARFF();
		//ARFFHandler.saveARFF(data);
		String keyWords[] = {"globo"};


		int option = -1;

		do
		{
			System.out.println("Options:\n 1- Twitter Listener\n 2- Tokenizer\n 0- Exit");
			option = Integer.parseInt(JOptionPane.showInputDialog("Options:\n 1- Twitter Listener\n 2- Tokenizer\n 0- Exit"));

			switch(option)
			{
			case 1 : TwitterListener.createLitener(keyWords, data); break;
			case 2 : break;
			}

		} while (option != 0);
	}
}
