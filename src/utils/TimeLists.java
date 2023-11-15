package utils;

import java.util.Iterator;

public class TimeLists {

	public static String[] getHours() {
		String[] hours = new String[24];
		for (int i = 0; i < hours.length; i++) {
//			Add a 0 to single digits (ie. 7 -> 07)
			if(i < 10) {
				hours[i] = "0" + i;
				continue;
			}
			hours[i] = Integer.toString(i);
		}
		return hours;
	}
	
	public static String[] getMinutes() {
		String[] minutes = new String[60];
		for (int i = 0; i < minutes.length; i++) {
//			Add a 0 to single digits (ie. 7 -> 07)
			if(i < 10) {
				minutes[i] = "0" + i;
				continue;
			}
			minutes[i] = Integer.toString(i);
		}
		return minutes;
	}
	
}
