package com.encocns.enfra.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

    public static final String DEFAULT_DATETIME_FORMAT = "yyyyMMddHHmmss";

    /**
     * Calendar 정보 : 입력받은 일자의 Calendar 정보를 받음.
     * @param yyyyMMdd 일자
     * @return Calendar
     */
    public static Calendar getCalendar(String yyyyMMdd) {
        if (yyyyMMdd == null || yyyyMMdd.trim().length() < 8) {
            yyyyMMdd = getDate();
        }

        Calendar cal = Calendar.getInstance();
        try {
            String strDt = yyyyMMdd.trim();
            int year = Integer.parseInt(strDt.substring(0, 4));
            int month = Integer.parseInt(strDt.substring(4, 6));
            int day = Integer.parseInt(strDt.substring(6, 8));
            int hour = 0;
            int min = 0;
            int sec = 1;

            if (strDt.length() >= 10) {
                hour = Integer.parseInt(strDt.substring(8, 10));
            }
            if (strDt.length() >= 12) {
                min = Integer.parseInt(strDt.substring(10, 12));
            }
            if (strDt.length() >= 14) {
                sec = Integer.parseInt(strDt.substring(12, 14));
            }

            cal.set(year,  month - 1, day, hour, min, sec);
        } catch (Exception e) {
            cal.setTimeInMillis(System.currentTimeMillis());
        }

        return cal;
    }

    /**
     * Calendar 정보 : 입력받은 일자 항목의 Calendar 정보를 받음.
     * @param year, month, day 숫자
     * @return Calendar
     * @throws ParseException
     */
    public static Calendar getCalendar(int year, int month, int day) throws ParseException {
        Calendar cal = Calendar.getInstance();

        if (year < 1900 || year > 2100) year = cal.get(Calendar.YEAR);
        if (month < 1 || month > 12) month = cal.get(2) + 1;
        if (day < 1 || day > 31) day = cal.get(5);

        cal.set(year, month - 1, day, 0, 0, 1);

        int tmpMonth = cal.get(2) + 1;
        int tmpDay = 28;

        if (month != tmpMonth) {
            tmpDay = getLastDayOfMonth(year, month);
            cal.set(year, month - 1, tmpDay, 0, 0, 1);
        }

        return cal;
    }

    /**
     * Calendar 정보 : 입력받은 일자 항목의 Calendar 정보를 받음.
     * @param year, month 숫자
     * @return Calendar
     * @throws ParseException
     */
    public static Calendar getCalendar(int year, int month) throws ParseException {
        Calendar cal = Calendar.getInstance();

        if (year < 1900 || year > 2100) year = cal.get(Calendar.YEAR);
        if (month < 1 || month > 12) month = cal.get(2) + 1;
        int day = cal.get(5);

        cal.set(year, month - 1, day, 0, 0, 1);

        int tmpMonth = cal.get(2) + 1;
        int tmpDay = 28;

        if (month != tmpMonth) {
            tmpDay = getLastDayOfMonth(year, month);
            cal.set(year, month - 1, tmpDay, 0, 0, 1);
        }

        return cal;
    }

    /**
     * 일자시간 정보 : 입력받은 타임마일과 포멧으로 일자시간 정보를 받음.
     * @param timeMillis, format
     * @return format형 일자시간
     */
    public static String getDateTime(long timeMillis, String format) {
        if (format == null || format.trim().equals("")) {
            format = "yyyyMMddHHmmss";
        }

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timeMillis);
        String result;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            result = sdf.format(cal.getTime());
        } catch (IllegalArgumentException iae) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            result = sdf.format(cal.getTime());
        }

        return result;
    }

    /**
     * 일자시간 정보 : 입력받은 포멧으로 현재 일자시간 정보를 받음.
     * @param timeMillis, format
     * @return format형 현재 일자시간
     */
    public static String getDateTime(String format) {
        return getDateTime(System.currentTimeMillis(), format);
    }

    /**
     * 일자시간 정보 : 입력받은 Calendar와 포멧으로 일자시간 정보를 받음.
     * @param Calendar, format
     * @return format형 일자시간
     */
    public static String getDateTime(Calendar cal, String format) {
        if (format == null || format.trim().equals("")) {
            format = "yyyyMMddHHmmss";
        }

        if (cal == null) {
            cal = Calendar.getInstance();
        }

        String result;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            result = sdf.format(cal.getTime());
        } catch (IllegalArgumentException iae) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            result = sdf.format(cal.getTime());
        }

        return result;
    }

    /**
     * 일자시간 정보 : 입력받은 타임마일에 addDays의 일수를 더한 일자시간 정보를 포멧 형식으로 받음.
     * @param timeMillis, format, addDays
     * @return format형 일자시간
     */
    public static String getDateTime(long timeMillis, String format, int addDays) {
        if (format == null || format.trim().equals("")) {
            format = "yyyyMMddHHmmss";
        }

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timeMillis);
        cal.add(Calendar.DAY_OF_MONTH, addDays);

        String result;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            result = sdf.format(cal.getTime());
        } catch (IllegalArgumentException iae) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            result = sdf.format(cal.getTime());
        }

        return result;
    }

    /**
     * 일자시간 정보 : 현재 일자시간 정보를 기본 일자시간포멧으로 받음.
     * @return yyyyMMddHHmmss형 현재 일자시간
     */
    public static String getDateTime() {
        return getDateTime(System.currentTimeMillis(), "yyyyMMddHHmmss");
    }

    /**
     * 일자 정보 : 현재 일자시간 정보를 기본 일자포멧으로 받음.
     * @return yyyyMMdd형 현재 일자
     */
    public static String getDate() {
        return getDateTime(System.currentTimeMillis(), "yyyyMMdd");
    }

    /**
     * 일자 정보 : 입력받은 일자의 Date 정보를 받음.
     * @param s 일자, format 포멧
     * @return Date
     * @throws Exception
     */
    public static Date getDate(String s, String format) throws Exception {
        if (s == null) {
            throw new ParseException("Date s is null", 0);
        }
        if (format == null) {
            throw new ParseException("Format string is null", 0);
        }

        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date result = null;

        try {
            result = formatter.parse(s);
        } catch (ParseException e) {
            throw new ParseException("Date parsing error [date:" + s + "] [format:" + format + "]", 0);
        }

        if (!formatter.format(result).equals(s)) {
            throw new ParseException("Out of bound date [date:" + s + "] [format:" + format + "]", 0);
        }

        return result;
    }

    /**
     * 시간 정보 : 현재 일자시간 정보에 addDays의 일수를 더한 일자시간 정보를 포멧 형식으로 받음.
     * @param timeMillis, format, addDays
     * @return format형 일자시간
     */
    public static String getTime(String format, int addDays) {
        return getDateTime(System.currentTimeMillis(), format, addDays);
    }

    /**
     * 일자시간 정보 : 현재 일자시간 정보를 기본 시간포멧으로 받음.
     * @return HHmmss형 현재 일자
     */
    public static String getTime() {
        return getDateTime(System.currentTimeMillis(), "HHmmss");
    }

    /**
     * 월말일자 : 현재 일자시간 정보에 addDays의 일수를 더한 일자시간 정보를 포멧 형식으로 받음.
     * @param timeMillis, format, addDays
     * @return format형 일자시간
     * @throws ParseException
     */
    public static int getLastDayOfMonth(int year, int month) throws ParseException {
        Calendar cal = Calendar.getInstance();

        if (year < 1900 || year > 2100) {
            throw new ParseException("year is out of date", 0);
        }
        if (month < 1 || month > 12) {
            throw new ParseException("month is out of date", 0);
        }

        cal.set(year, month - 1, 1);

        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 월말일자 : 현재 일자시간 정보에 addDays의 일수를 더한 일자시간 정보를 포멧 형식으로 받음.
     * @param timeMillis, format, addDays
     * @return format형 일자시간
     * @throws ParseException
     */
    public static int getLastDayOfMonth(Calendar cal) throws ParseException {
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) - 1;

        return getLastDayOfMonth(year, month);
    }

    /**
     * 월말일자계산 : 입력받은 일자의 월말일자를 계산한다.
     * @param yyyyMMdd 일자
     * @return 월말일자
     * @throws Exception
     */
    public static String getLastDayOfMonth(String yyyyMMdd) throws Exception {
        int year = Integer.parseInt(yyyyMMdd.substring(0, 4));
        int month = Integer.parseInt(yyyyMMdd.substring(4, 6));

        StringBuffer result = new StringBuffer();

        result.append(yyyyMMdd.substring(0, 6));
        result.append(getLastDayOfMonth(year, month));

        return result.toString();

    }

    public static int getDayOfWeek(String yyyyMMdd) {
        if (yyyyMMdd == null || yyyyMMdd.trim().length() != 8) yyyyMMdd = getDate();

        Calendar cal = Calendar.getInstance();
        try {
            int year = Integer.parseInt(yyyyMMdd.substring(0, 4));
            int month = Integer.parseInt(yyyyMMdd.substring(4, 6));
            int day = Integer.parseInt(yyyyMMdd.substring(6, 8));
            cal.set(year, month - 1, day);
        } catch (Exception e) {

        }

        return cal.get(7);
    }

    /**
     * 유효일자 여부 : 입력받은 년, 월, 일 값이 유효한 일자인지 확인한다.
     * @param yyyy 년
     * @param mm 월
     * @param dd 일
     * @return 여부
     * @throws Exception
     */
    public static boolean isValidDate(int yyyy, int mm, int dd) throws Exception {

        boolean result = false;

        Calendar cal = new GregorianCalendar(yyyy, mm - 1, dd);

        int calYyyy = cal.get(Calendar.YEAR);
        int calMm = cal.get(Calendar.MONTH) + 1;
        int calDd = cal.get(Calendar.DATE);

        if (calYyyy == yyyy && calMm == mm && calDd == dd) {
            result = true;
        }

        return result;
    }

    /**
     * 유효일자 여부 : 입력받은 일자가 유효한 일자인지 확인한다.
     * @param yyyyMMdd 일자
     * @return 여부
     * @throws Exception
     */
    public static boolean isValidDate(String yyyyMMdd) throws Exception {

        boolean result = false;

        if (yyyyMMdd.length() != 8) {
            return false;
        }

        try {
            int yyyy = Integer.parseInt(yyyyMMdd.substring(0, 4));
            int mm = Integer.parseInt(yyyyMMdd.substring(4, 6));
            int dd = Integer.parseInt(yyyyMMdd.substring(6));

            result = isValidDate(yyyy, mm, dd);
        } catch (Exception e) {
            return false;
        }

        return result;
    }

    /**
     * 유효일자 여부 : 입력받은 일자가 유효한 일자인지 확인한다.
     * @param s 일자, format 포멧
     * @return 여부
     * @throws Exception
     */
    public static boolean isValidDate(String s, String format) throws Exception {

        boolean result = false;

        if (s == null) {
            throw new ParseException("Date s is null", 0);
        }
        if (format == null) {
            throw new ParseException("Format string is null", 0);
        }

        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date date = null;

        try {
            date = formatter.parse(s);
        } catch (ParseException e) {
            throw new ParseException("Date parsing error [date:" + s + "] [format:" + format + "]", 0);
        }

        SimpleDateFormat newFormatter = new SimpleDateFormat("yyyyMMdd");

        result = isValidDate(newFormatter.format(date));

        return result;
    }

    /**
     * 유효일자 여부 : 입력받은 년월이 유효한 년월인지 확인한다.
     * @param yyyyMM 년월
     * @return 여부
     * @throws Exception
     */
    public static boolean isValidMonth(String yyyyMM) throws Exception {

        boolean result = false;

        if (yyyyMM.length() != 6) {
            return false;
        }

        try {
            int yyyy = Integer.parseInt(yyyyMM.substring(0, 4));
            int mm = Integer.parseInt(yyyyMM.substring(4));
            int dd = 1;

            result = isValidDate(yyyy, mm, dd);
        } catch (Exception e) {
            return false;
        }

        return result;
    }

    public static boolean isSameDate(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) return false;

        if (cal1 == cal2) return true;

        if (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(2) == cal2.get(2)
                && cal1.get(5) == cal2.get(5)) {
            return true;
        }

        return false;
    }

    public static boolean isSameDate(Calendar cal, String yyyyMMdd) {
        if (cal == null || yyyyMMdd == null) return false;

        if (yyyyMMdd.trim().length() < 6) return false;

        Calendar cal2 = getCalendar(yyyyMMdd);

        return isSameDate(cal, cal2);
    }

    public static boolean isLastDayOfMonth(Calendar cal) {
        int month = cal.get(2);

        Calendar clone = (Calendar)cal.clone();
        clone.add(5,  1);

        int cloneMonth = clone.get(2);

        boolean result = false;
        if (cloneMonth == month) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    /**
     * 월말일자 여부 : 입력받은 일자가 월말일자인지 확인한다.
     * @param yyyyMMdd 일자
     * @return 여부
     * @throws Exception
     */
    public static boolean isLastDayOfMonth(String yyyyMMdd) throws Exception {
        String calLastDate = getLastDayOfMonth(yyyyMMdd);

        boolean result = calLastDate.equals(yyyyMMdd);

        return result;
    }

    public static boolean isWeekEnd(String yyyyMMdd) {
        int dayOfWeek = getDayOfWeek(yyyyMMdd);

        return (dayOfWeek == 7) || (dayOfWeek == 1);
    }

    public static boolean isWeekEnd(Calendar cal) {
        int dayOfWeek = cal.get(7);

        return (dayOfWeek == 7) || (dayOfWeek == 1);
    }

    public static String addDays(String s, int day, String format) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date date = getDate(s, format);
        date.setTime(date.getTime() + day * 1000L * 60L * 60L * 24L);
        return formatter.format(date);
    }

    public static String addDays(String yyyyMMdd, int day) throws Exception {
        return addDays(yyyyMMdd, day, "yyyyMMdd");
    }

    public static String addMonths(String s, int addMonth, String format) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date date = getDate(s, format);

        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");

        int year = Integer.parseInt(yearFormat.format(date));
        int month = Integer.parseInt(monthFormat.format(date));
        int day = Integer.parseInt(dayFormat.format(date));

        month += addMonth;

        if (addMonth > 0) {
            while (month > 12) {
                month -= 12;
                year++;
            }
        } else {
            while (month <= 0) {
                month += 12;
                year--;
            }
        }

        String tempDate = String.format("%04d%02d%02d", year, month, day);
        Date targetDate = null;

        try {
            targetDate = getDate(tempDate, "yyyyMMdd");
        } catch (ParseException pe) {
            day = getLastDayOfMonth(year, month);
            tempDate = String.format("%04d%02d%02d", year, month, day);
            targetDate = getDate(tempDate, "yyyyMMdd");
        }

        return formatter.format(targetDate);
    }

    public static String addMonths(String s, int month) throws Exception {
        return addMonths(s, month, "yyyyMMdd");
    }

    public static String getMonthAdd(String sYear, String sMonth, int add) {
        int year = Integer.parseInt(sYear);
        int month = Integer.parseInt(sMonth);

        int mt = 0;
        if (month < 0) {
            mt = 1;
        } else if (month > 12) {
            mt = 12;
        } else {
            mt = month;
        }

        Calendar cal = Calendar.getInstance();
        cal.set(year, mt - 1, 28);
        cal.add(2, add);

        return getDateTime(cal, "yyyy-MM");
    }

    public static String addMonth(int year, int month, int day, int addMonths, String format) throws Exception {
        Calendar cal = getCalendar(year, month, day);
        cal.add(2, addMonths);
        return getDateTime(cal, format);
    }

    public static String addMonth(int year, int month, int day, int addMonths) throws Exception {
        Calendar cal = getCalendar(year, month, day);
        cal.add(2, addMonths);
        return getDateTime(cal, "yyyyMMdd");
    }

    public static String addMonth(int year, int month, int addMonths, String format) throws Exception {
        Calendar cal = getCalendar(year, month);
        cal.add(2, addMonths);
        return getDateTime(cal, format);
    }

    public static String addYears(String s, int year, String format) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date date = getDate(s, format);
        date.setTime(date.getTime() + year * 1000L * 60L * 60L * 24L * 366L);
        return formatter.format(date);
    }

    public static String addYears(String yearstr, int year) throws Exception {
        return addYears(yearstr, year, "yyyyMMdd");
    }

    public static int calDaysBetween(String from, String to, String format) throws Exception {
        Date d1 = getDate(from, format);
        Date d2 = getDate(to, format);

        long duration = d2.getTime() - d1.getTime();

        return (int)(duration / 86400000L);
    }

    public static int calDaysBetween(String from, String to) throws Exception {
        return calDaysBetween(from, to, "yyyyMMdd");
    }

    public static int calMonthsBetween(String from, String to, String format) throws ParseException, Exception {
        int result = 0;

        Date fromDate = getDate(from, format);
        Date toDate = getDate(to, format);
        if (fromDate.compareTo(toDate) == 0) {
            return result;
        }

        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");

        int fromYear = Integer.parseInt(yearFormat.format(fromDate));
        int toYear = Integer.parseInt(yearFormat.format(toDate));
        int fromMonth = Integer.parseInt(monthFormat.format(fromDate));
        int toMonth = Integer.parseInt(monthFormat.format(toDate));

        result += (toYear - fromYear) * 12;
        result += toMonth - fromMonth;
        result++;

        String calTo = addDays(addMonths(from, result), -1);
        if (calTo.compareTo(to) > 0) {
            do {
                result--;
                calTo = addDays(addMonths(from, result), -1);
            } while ((calTo.compareTo(to) > 0) && (result > 0));
        }
        return result;
    }

    public static int calMonthsBetween(String from, String to) throws ParseException, Exception {
        return calMonthsBetween(from, to, "yyyyMMdd");
    }

    public static int calMilisBetween(String from, String to, String format) throws Exception {
        Date d1 = getDate(from, format);
        Date d2 = getDate(to, format);

        long duration = d2.getTime() - d1.getTime();

        return (int)duration;
    }

    public static int calMilisBetween(String from, String to) throws Exception {
        return calMilisBetween(from, to, "HHmmssSSS");
    }

    public static int calSecsBetween(String from, String to, String format) throws Exception {
        return calMilisBetween(from, to, format) / 1000;
    }

    public static int calSecsBetween(String from, String to) throws Exception {
        return calSecsBetween(from, to, "HHmmss");
    }

    public static int calMinsBetween(String from, String to, String format) throws Exception {
        return calSecsBetween(from, to, format) / 60;
    }

    public static int calMinsBetween(String from, String to) throws Exception {
        return calMinsBetween(from, to, "HHmmss");
    }

    public static int calHoursBetween(String from, String to, String format) throws Exception {
        return calMinsBetween(from, to, format) / 60;
    }

    public static int calHoursBetween(String from, String to) throws Exception {
        return calHoursBetween(from, to, "HHmmss");
    }

    public static void main(String[] args) {

        int year = 12345;
        int month = 8;
        int day = 1;

        String tempDate = String.format("%04d%02d%02d", year, month, day);

        System.out.println("getMonthAdd(String sYear, String sMonth, int add) : " + getMonthAdd("2015", "10", 9));
        System.out.println("addMonths(String sYear, String sMonth, int add) : " + tempDate);
        
        System.out.println(DateUtil.getDateTime());
    }

}
