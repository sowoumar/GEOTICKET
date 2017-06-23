package geoticket.com.geoticket;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by osow on 23/06/17.
 */

public final class Utils {
	
	public static String formatDate (Date date) {
		
		
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(date);
		
	}
}
