package dao.files;

import separartwitters.FileChooserDirectory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import utils.Constants;
import dao.files.TxtHandler;

public class Csv 
{

	public static void main(String[] args) 
	{
		try 
		{
			String[] strSplit;
			String sCurrentLine;
			File condensedTweets = FileChooserDirectory.initialize();
			
			String neuDir = "C:\\Temp\\neutral";
			String negDir = "C:\\Temp\\negative";
			String posDir = "C:\\Temp\\positve";
			
			BufferedReader br = new BufferedReader(new FileReader(condensedTweets));
			
			while ((sCurrentLine = br.readLine()) != null) 
			{
				strSplit = sCurrentLine.split(";");
				String category = strSplit[strSplit.length-1];
				String path = "";
				System.out.println(category);
				switch (category)
				{
					case "neutral": path = Constants.NEUTRAL_PATH; break;
					case "negative": path = Constants.POSITIVE_PATH; break;
					case "positive": path = Constants.NEGATIVE_PATH; break;
				}
				
				TxtHandler.createAndWriteTxt(strSplit[0], path);
			}
			
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			
		}
	}
}
