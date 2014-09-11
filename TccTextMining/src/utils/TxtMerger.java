package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import dao.files.TxtHandler;

public class TxtMerger
{
	public static void main(String[] args)
	{
		
			merge();
	}
	
	public static void merge()
	{
		//Cria o documento com todos os Txts que achar
		File toBeClassifiedFile = new File(Constants.PATH + File.separator + "To Be Classified.txt");
		
		if(toBeClassifiedFile.exists())
		{
			try 
			{
				toBeClassifiedFile.createNewFile();
			} catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
		
		File dir = new File(Constants.PATH);
		String[] categories = dir.list();
		
		for(String category: categories)
		{
			File file = new File(dir, category);
			if(file.isDirectory())
			{
				File [] textFiles = file.listFiles();
				
				for(File textFile: textFiles)
				{
					try
					{
						Scanner scanner = new Scanner(textFile);
						while(scanner.hasNext())
						{
							TxtHandler.writeIntoFile(toBeClassifiedFile, scanner.nextLine());
						}
					} catch (FileNotFoundException e)
					{
						e.printStackTrace();
					}
				}
			}
		}
		
	}
}
