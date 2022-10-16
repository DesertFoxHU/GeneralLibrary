package java.me.desertfox.gl;

import java.text.DecimalFormat;

public class Formatter {

	public static double formatDouble(double DoubleValue, int length) {
		StringBuilder count = new StringBuilder("#.");
		for(int i = 0; i < length; i++) {
			count.append("#");
		}
		
		DecimalFormat df = new DecimalFormat(count.toString());
		String format = df.format(DoubleValue);
		format = format.replaceAll("\\,", "\\.");
		return Double.parseDouble(format);
	}
	
}
