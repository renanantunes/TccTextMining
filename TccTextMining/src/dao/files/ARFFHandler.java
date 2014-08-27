package dao.files;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import twitter.Tweet;
import utils.ApplicationUtils;
import utils.Constants;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;


public class ARFFHandler {
	
	
	public static Instances creatARFF(){
		FastVector atts;
		Instances data;

		atts = new FastVector();
		atts.addElement(new Attribute("id"));
		atts.addElement(new Attribute("User", (FastVector) null));
		atts.addElement(new Attribute("tweet", (FastVector) null));
		atts.addElement(new Attribute("date", Constants.DATEFORMAT1));
		
		data = new Instances("MyRelation", atts, 0);
		return data;
	}
	
	public static Instances addDatatoARFF(Tweet tweet, Instances data){
		double[] vals = new double[data.numAttributes()];
		
		try {
			vals[0] = tweet.getId();
			vals[1] = data.attribute(1).addStringValue(tweet.getUser());
			vals[2] = data.attribute(2).addStringValue(tweet.getTweet());
			vals[3] = data.attribute(3).parseDate(tweet.getDate());
			data.add(new Instance(1.0, vals));
			
			saveARFF(data);
		} catch (ParseException e) {
			System.err.println("===ARFFHandler.addDatatoARFF error during parsing date");
		}
		
		return data;
	}
	
	public static void saveARFF(Instances data) {
		
		
		String fileName = "Tweets_"+ApplicationUtils.createFormatDate(Constants.DATEFORMAT2)+".arff";
		try {
			PrintWriter writer = new PrintWriter(new FileWriter(Constants.ARFFPATH+"\\"+fileName));
			writer.print(data);
			writer.close();
		}
		catch (IOException e) {
			System.err.println("===Problem found when writing arff file");
			System.err.println(e);
		}
	}
	
}
