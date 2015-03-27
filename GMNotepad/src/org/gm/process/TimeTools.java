package org.gm.process;

import java.sql.Date;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TimeTools {
	static public long CurrentTime() {
		return System.currentTimeMillis() / 1000;
	}

	static public String Convert(long time) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
				Locale.getDefault());
		Date d = new Date(time * 1000);
		String t = format.format(d);
		return t;
	}

	public static Long Convert(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = (Date) formatter.parse(strDate, pos);
		return strtodate.getTime();
	}
}
