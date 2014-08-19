package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ApplicationUtils {
	
	public static String createFormatDate(String pattern){
		String formatedDate;
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		formatedDate = sdf.format(c.getTime());
		
		return formatedDate;
	}
	
}
