package utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import main.MainClass;

public class ApplicationUtils {
	
	public static String createFormatDate(String pattern){
		String formatedDate;
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		formatedDate = sdf.format(c.getTime());
		
		return formatedDate;
	}
	
	public static String getRatingCount(){
		int pos = 0;
		int neg = 0;
		int neu = 0;
		
		for (String rating : MainClass.ratingList) {
			switch (rating) {
			case Constants.POSITIVE:
				pos++;
				break;	
			case Constants.NEGATIVE:
				neg++;
				break;
			case Constants.NEUTRAL:
				neu++;
				break;
			}
		}
		
		String result = pos + Constants.PIPE_REGEX + neg + Constants.PIPE_REGEX + neu;
		return result;
	}
	
}
