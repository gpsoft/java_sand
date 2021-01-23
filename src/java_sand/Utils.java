package java_sand;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
	public static void prn(String s) {
		System.out.println(s);
	}

	public static void prn(int i) {
		System.out.println(String.valueOf(i));
	}

	public static String timestr(LocalDateTime dt) {
		return dt.format(DateTimeFormatter.ofPattern("hh:mm:ss"));
	}

	public static void sleep(int secs) {
		sleep(secs, false);
	}

	public static void sleep(int secs, boolean verbose) {
		if (verbose) {
			prn("  ...sleeping");
		}
		try {
			Thread.sleep(secs * 1000);
		} catch (InterruptedException e) {
		}
	}

	public static int parseInt(String intStr, int def) {
		try {
			return Integer.parseInt(intStr);
		} catch (NumberFormatException ex) {
			return def;
		}
	}
}
