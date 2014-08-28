package dao.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TxtHandler {
	public static void createAndWriteTxt(String toWrite, String path){
		Writer writer = null;
		
		try{
			int num = getLastFileNumberFromDirectory(path)+1;
			File file = new File(path+"\\tweet-"+num+".txt");
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(toWrite);
		}catch(FileNotFoundException e){
			System.err.println("== FileNotFoundException txtHandler.createAndWriteTxt");
		} catch (IOException ex) {
			System.err.println("== IOException txtHandler.createAndWriteTxt");
		}finally{
			try{
				if(writer!=null)
					writer.close();
			}catch(IOException exc){
				System.err.println("== IOException txtHandler.createAndWriteTxt");
			}	
		}	
	}
	
	public static File createTxt(String path){
		File file = new File(path+"\\tweets.txt");
		
		try{
			if(!file.exists())
				file.createNewFile();
			
		}catch(IOException e){
			System.err.println("== IOException txtHandler.createTxt");
		}
		
		
		return file;
	}
	
	public static File writeIntoFile(File file, String toWrite){
		
		try{
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter writer = new BufferedWriter(fw);
			writer.newLine();
			writer.write(toWrite);
			writer.close();
		}catch(IOException e){
			System.err.println("== IOException txtHandler.writeIntoFile");
		}
		
		
		return file;
	}
	
	public static int getLastFileNumberFromDirectory(String path){
		File folder = new File(path);
		File[] listOfFile = folder.listFiles();
		List<Integer> nums = new ArrayList<Integer>();
		boolean exists = false;
		int num=0;
		
		if(listOfFile.length >0 || listOfFile!=null){
			for (int i=0; i< listOfFile.length; i++) {
				File file = listOfFile[i];
				if(file.isFile() && file.getName().endsWith(".txt") && file.getName().startsWith("tweet-")){
					exists = true;
					String filename = file.getName();
					String aux[]=filename.split("tweet-");
					filename = aux[1].substring(0, aux[1].length()-4);
					nums.add(Integer.parseInt(filename));
				}
			}
			
		}

		if(exists)
			num = Collections.max(nums); //nums.get(nums.size()-1);
		
		return num;
			
	}

}
