package com.encocns.enfra.util;

import java.text.DecimalFormat;

public class NumberUtil {
	
	private static final DecimalFormat DEFAULT_INTEGER_FORMAT = new DecimalFormat("#,###,###,###");
	private static final DecimalFormat DEFAULT_LONG_FORMAT = new DecimalFormat("#,###,###,###,###,###,###");
	private static final DecimalFormat DEFAULT_DOUBLE_FORMAT = new DecimalFormat("#,###,###,###,###,###,###,###,###,###,###.##");
	private static final DecimalFormat NO_COMMA_DOUBLE_FORMAT3 = new DecimalFormat("###.###");
	
	public static String format(double value, String format) {
		String result = null;
		try {
			result = new DecimalFormat(format).format(value);
		} catch (Exception e) {
			result = String.valueOf(value);
		}
		return result;
	}
	
	public static String format(double value, DecimalFormat formatter) {
		String result = null;
		try {
			result = formatter.format(value);
		} catch (Exception e) {
			result = String.valueOf(value);
		}
		return result;
	}
	
	public static String format(int value) {
		return DEFAULT_INTEGER_FORMAT.format(value);
	}
	
	public static String format(long value) {
		return DEFAULT_LONG_FORMAT.format(value);
	}
	
	public static String format(double value) {
		return DEFAULT_DOUBLE_FORMAT.format(value);
	}
	
	public static String format3(double value) {
		return NO_COMMA_DOUBLE_FORMAT3.format(value);
	}
	
	public static boolean isBetween(int value, int start, int end) {
		if (start < end) {
			return (value >= start) && (value <= end);
		} else {
			return (value <= start) && (value >= end);
		}
	}
	
	public static boolean isBetween2(int value, int start, int end) {
		if (start == end) return false;
		
		if (start < end) {
			return (value >= start) && (value < end);
		} else {
			return (value < start) && (value >= end);
		}
	}
	
	public static int getInt(String strVal, int defaultVal) {
		if (strVal == null || strVal.trim().equals("")) {
			return defaultVal;
		}
		
		int intVal = defaultVal;
		try {
			intVal = Integer.parseInt(strVal.trim());
		} catch (Exception e) {
			intVal = defaultVal;
		}
		
		return intVal;
	}
	
	public static int getInt(String strVal) {
		return getInt(strVal, 0);
	}
	
	public static void main(String[] args) {
		System.out.println("format(double); : " + format(111D));
	}

}
