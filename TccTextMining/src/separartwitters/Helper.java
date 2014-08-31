package separartwitters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.files.TxtHandler;
import utils.Constants;

public class Helper {
	public static ArrayList<String> getListFromTxt(File file){
		ArrayList<String>tweets = new ArrayList<String>();
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()){
				tweets.add(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tweets;
	}
	
	public static void saveTweet(String tweet, String type){
		if(type.equals(Constants.POSITIVE)){
			TxtHandler.createAndWriteTxt(tweet, Constants.POSITIVE_PATH);
		}else if(type.equals(Constants.NEGATIVE)){
			TxtHandler.createAndWriteTxt(tweet, Constants.NEGATIVE_PATH);
		}else if(type.equals(Constants.NEUTRAL)){
			TxtHandler.createAndWriteTxt(tweet, Constants.NEUTRAL_PATH);
		}
	}

}
