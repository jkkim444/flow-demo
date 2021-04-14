/*
 * Copyright LINE Bank.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of LINE Bank.,LTD. ("Confidential Information").
 */
/**
 * @file DateUtil.java
 * @brief
 * \~english Date Utility
 * \~korean Date Utility
 * @section Major History
 * <pre>
 *   - CHOI, YOUNG-HWAN | 2016. 8. 1. | First Created
 * </pre>
 */
/**
 * @namespace com.encocns.ifrs.co.util
 * @brief Common Utility Package
 */
package com.encocns.ifrs.co.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @brief
 * \~english Date Utility
 * \~korean Date Utility
 * @details
 * \~english Date Utility
 * \~korean Date Utility
 * @author : CHOI, YOUNG-HWAN
 * @date : 2016. 8. 1.
 * @version : 1.0.0
 */
public class DateUtil {

    private static final Log LOGGER = LogFactory.getLog(DateUtil.class);

    public static final String DEFAULT_DATETIME_FORMAT = "yyyyMMddHHmmss";

    /**
     * @brief
     * \~english Date information: Date information of the date entered is received.
     * \~korean 일자 정보 : 입력받은 일자의 Date 정보를 받음.
     * @details
     * <pre>
     * \~english Date information: Date information of the date entered is received.
     * \~korean 일자 정보 : 입력받은 일자의 Date 정보를 받음.
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 8. 1
     * @param s day
     * @param format format
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

        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.KOREA);
        Date result = null;

//        try {
        result = formatter.parse(s);
//        } catch (Exception e) {
//            throw new ParseException("Date parsing error [date:" + s + "] [format:" + format + "]", 0);
//        }

        if (!formatter.format(result).equals(s)) {
            throw new ParseException("Out of bound date [date:" + s + "] [format:" + format + "]", 0);
        }

        return result;
    }

    /**
     * @brief
     * \~english Date information: Date information of the date entered is received.
     * \~korean 일자 정보 : 입력받은 일자의 Date 정보를 받음.
     * @details
     * <pre>
     * \~english Date information: Date information of the date entered is received.
     * \~korean 일자 정보 : 입력받은 일자의 Date 정보를 받음.
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 8. 1
     * @param yyyyMMdd day
     * @return Date
     * @throws Exception
     */
    public static Date getDate(String yyyyMMdd) throws Exception {
        return getDate(yyyyMMdd, "yyyyMMdd");
    }

    /**
     * @brief
     * \~english Monthly end date: Date time information in formal format, including the number of days added to the current date time information.
     * \~korean 월말일자 : 현재 일자시간 정보에 addDays의 일수를 더한 일자시간 정보를 포멧 형식으로 받음.
     * @details
     * <pre>
     * \~english Monthly end date: Date time information in formal format, including the number of days added to the current date time information.
     * \~korean 월말일자 : 현재 일자시간 정보에 addDays의 일수를 더한 일자시간 정보를 포멧 형식으로 받음.
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 8. 1
     * @param year year
     * @param month month
     * @return int Date Time Information
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
     * @brief
     * \~english Monthly end date: Date time information in formal format, including the number of days added to the current date time information.
     * \~korean 월말일자 : 현재 일자시간 정보에 addDays의 일수를 더한 일자시간 정보를 포멧 형식으로 받음.
     * @details
     * <pre>
     * \~english Monthly end date: Date time information in formal format, including the number of days added to the current date time information.
     * \~korean 월말일자 : 현재 일자시간 정보에 addDays의 일수를 더한 일자시간 정보를 포멧 형식으로 받음.
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 8. 1
     * @param cal Calendar
     * @return int Date Time Information
     * @throws ParseException
     */
    public static int getLastDayOfMonth(Calendar cal) throws ParseException {
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) - 1;

        return getLastDayOfMonth(year, month);
    }

    /**
     * @brief
     * \~english Calculate the input date of the end of the month of the date of the operators who have been : at the end of the date calculation.
     * \~korean 월말일자계산 : 입력받은 일자의 월말일자를 계산한다.
     * @details
     * <pre>
     * \~english Calculate the input date of the end of the month of the date of the operators who have been : at the end of the date calculation.
     * \~korean 월말일자계산 : 입력받은 일자의 월말일자를 계산한다.
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 8. 1
     * @param yyyyMMdd year month day
     * @return String Monthly end date
     * @throws Exception
     */
    public static String getLastDayOfMonth(String yyyyMMdd) throws Exception {
        int year = Integer.parseInt(yyyyMMdd.substring(0, 4));
        int month = Integer.parseInt(yyyyMMdd.substring(4, 6));

        StringBuilder result = new StringBuilder();

        result.append(yyyyMMdd.substring(0, 6));
        result.append(getLastDayOfMonth(year, month));

        return result.toString();

    }

    /**
     * @brief
     * \~english Monthly First Date Calculation: Calculate the first date of the month of the date entered.
     * \~korean 월첫일자계산 : 입력받은 일자의 월첫일자를 계산한다.
     * @details
     * <pre>
     * \~english Monthly First Date Calculation: Calculate the first date of the month of the date entered.
     * \~korean 월첫일자계산 : 입력받은 일자의 월첫일자를 계산한다.
     * </pre>
     * @author : daniel
     * @date : 2016. 8. 1
     * @param yyyyMMdd year month day
     * @return String Monthly start date
     * @throws Exception
     */
    public static String getFrstDayOfMonth(String yyyyMMdd) throws Exception {
        int year = Integer.parseInt(yyyyMMdd.substring(0, 4));
        int month = Integer.parseInt(yyyyMMdd.substring(4, 6));

        StringBuilder result = new StringBuilder();

        result.append(yyyyMMdd.substring(0, 6));

        Calendar cal = Calendar.getInstance();

        if (year < 1900 || year > 2100) {
            throw new ParseException("year is out of date", 0);
        }
        if (month < 1 || month > 12) {
            throw new ParseException("month is out of date", 0);
        }

        cal.set(year, month - 1, 1);
        String day = "0" + String.valueOf(cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        result.append(day);

        return result.toString();
    }

    /**
     * @brief
     * \~english Effective Date: Check if the entered year, month, and date are valid dates.
     * \~korean 유효일자 여부 : 입력받은 년, 월, 일 값이 유효한 일자인지 확인한다.
     * @details
     * <pre>
     * \~english Effective Date: Check if the entered year, month, and date are valid dates.
     * \~korean 유효일자 여부 : 입력받은 년, 월, 일 값이 유효한 일자인지 확인한다.
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 8. 1
     * @param yyyy 년
     * @param mm 월
     * @param dd 일
     * @return boolean Valid date status
     */
    public static boolean isValidDate(int yyyy, int mm, int dd) {

        boolean result = false;

        Calendar cal = new GregorianCalendar(yyyy, mm - 1, dd);

        int calYyyy = cal.get(Calendar.YEAR);
        int calMm = cal.get(Calendar.MONTH) + 1;
        int calDd = cal.get(Calendar.DATE);

        if (calYyyy == yyyy && calMm == mm && calDd == dd) {
            result = true;
        }

//        if (result == false) {
//        	LOGGER.error("Date is error. yyyy[" + yyyy + "] mm[" + mm + "] dd[" + dd + "]");
//        }

        return result;
    }

    /**
     * @brief
     * \~english Valid date: Check if the date entered is a valid date.
     * \~korean 유효일자 여부 : 입력받은 일자가 유효한 일자인지 확인한다.
     * @details
     * <pre>
     * \~english Valid date: Check if the date entered is a valid date.
     * \~korean 유효일자 여부 : 입력받은 일자가 유효한 일자인지 확인한다.
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 8. 1
     * @param yyyyMMdd year month day
     * @return boolean Valid date status
     */
    public static boolean isValidDate(String yyyyMMdd) {

        boolean result = false;

        if (yyyyMMdd.length() != 8) {
        	if(LOGGER.isErrorEnabled()) LOGGER.error("Date is error. yyyyMMdd[" + yyyyMMdd + "]");
            return false;
        }

        try {
            int yyyy = Integer.parseInt(yyyyMMdd.substring(0, 4));
            int mm = Integer.parseInt(yyyyMMdd.substring(4, 6));
            int dd = Integer.parseInt(yyyyMMdd.substring(6));

            result = isValidDate(yyyy, mm, dd);
        } catch (Exception e) {
        	if(LOGGER.isErrorEnabled()) LOGGER.error("Date is error. yyyyMMdd[" + yyyyMMdd + "]");
            return false;
        }

        return result;
    }

    /**
     * @brief
     * \~english Valid date: Check if the date entered is a valid date.
     * \~korean 유효일자 여부 : 입력받은 일자가 유효한 일자인지 확인한다.
     * @details
     * <pre>
     * \~english Valid date: Check if the date entered is a valid date.
     * \~korean 유효일자 여부 : 입력받은 일자가 유효한 일자인지 확인한다.
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 8. 1
     * @param s date
     * @param format format
     * @return boolean Valid date status
     */
    public static boolean isValidDate(String s, String format) {

        boolean result = false;

        if (s == null) {
        	if(LOGGER.isErrorEnabled()) LOGGER.error("Date is error. s[" + s + "] format[" + format + "]");
            return false;
        }
        if (format == null) {
        	if(LOGGER.isErrorEnabled()) LOGGER.error("Date is error. s[" + s + "] format[" + format + "]");
            return false;
        }

        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.KOREA);
        Date date = null;

        try {
            date = formatter.parse(s);
        } catch (ParseException e) {
        	if(LOGGER.isErrorEnabled()) LOGGER.error("Date is error. s[" + s + "] format[" + format + "]");
            return false;
        }

        if (!formatter.format(date).equals(s)) {
        	if(LOGGER.isErrorEnabled()) LOGGER.error("Date is error. s[" + s + "] format[" + format + "]");
            return false;
        }

        SimpleDateFormat newFormatter = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);

        result = isValidDate(newFormatter.format(date));

        return result;
    }

    /**
     * @brief
     * \~english Month end date: Check if the date entered is the month end date.
     * \~korean 월말일자 여부 : 입력받은 일자가 월말일자인지 확인한다.
     * @details
     * <pre>
     * \~english Month end date: Check if the date entered is the month end date.
     * \~korean 월말일자 여부 : 입력받은 일자가 월말일자인지 확인한다.
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 8. 1
     * @param yyyyMMdd year month day
     * @return boolean Monthly end date status
     * @throws Exception
     */
    public static boolean isLastDayOfMonth(String yyyyMMdd) throws Exception {

        String calLastDate = getLastDayOfMonth(yyyyMMdd);

        boolean result = calLastDate.equals(yyyyMMdd);

        return result;
    }

    /**
     * @brief
     * \~english Date + addDay processing received
     * \~korean 일자 + addDay 처리 받음
     * @details
     * <pre>
     * \~english Date + addDay processing received
     * \~korean 일자 + addDay 처리 받음
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 8. 1
     * @param s Date
     * @param day addDay
     * @param format format
     * @return String Calculated date
     * @throws Exception
     */
    public static String addDays(String s, int day, String format) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.KOREA);
        Date date = getDate(s, format);
        date.setTime(date.getTime() + day * 1000L * 60L * 60L * 24L);
        return formatter.format(date);
    }

    /**
     * @brief
     * \~english Date + addDay processing received
     * \~korean 일자 + addDay 처리 받음
     * @details
     * <pre>
     * \~english Date + addDay processing received
     * \~korean 일자 + addDay 처리 받음
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 8. 1
     * @param yyyyMMdd year month hday
     * @param day additional date
     * @return String Calculated date
     * @throws Exception
     */
    public static String addDays(String yyyyMMdd, int day) throws Exception {
        return addDays(yyyyMMdd, day, "yyyyMMdd");
    }

    /**
     * @brief
     * \~english Date + addMonth processed
     * \~korean 일자 + addMonth 처리 받음
     * @details
     * <pre>
     * \~english Date + addMonth processed
     * \~korean 일자 + addMonth 처리 받음
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 8. 1
     * @param s Date
     * @param addMonth add day
     * @param format format
     * @return String Calculated date
     * @throws Exception
     */
    public static String addMonths(String s, int addMonth, String format) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.KOREA);
        Date date = getDate(s, format);

        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy", Locale.KOREA);
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM", Locale.KOREA);
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd", Locale.KOREA);

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

    /**
     * @brief
     * \~english Date + addMonth processed
     * \~korean 일자 + addMonth 처리 받음
     * @details
     * <pre>
     * \~english Date + addMonth processed
     * \~korean 일자 + addMonth 처리 받음
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 8. 1
     * @param s date
     * @param month additional month
     * @return String Calculated date
     * @throws Exception
     */
    public static String addMonths(String s, int month) throws Exception {
        return addMonths(s, month, "yyyyMMdd");
    }

    /**
     * @brief
     * \~english Date Range Computation Results Received
     * \~korean 날짜 범위 연산 결과 받음
     * @details
     * <pre>
     * \~english Date Range Computation Results Received
     * \~korean 날짜 범위 연산 결과 받음
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 8. 1
     * @param from start date
     * @param to end date
     * @param format format
     * @return int Calculated date
     * @throws Exception
     */
    public static int calDaysBetween(String from, String to, String format) throws Exception {
        Date d1 = getDate(from, format);
        Date d2 = getDate(to, format);

        long duration = d2.getTime() - d1.getTime();

        return (int)(duration / 86400000L);
    }

    /**
     * @brief
     * \~english Date Range Computation Results Received
     * \~korean 날짜 범위 연산 결과 받음
     * @details
     * <pre>
     * \~english Date Range Computation Results Received
     * \~korean 날짜 범위 연산 결과 받음
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 8. 1
     * @param from start date
     * @param to end date
     * @return int Calculated date
     * @throws Exception
     */
    public static int calDaysBetween(String from, String to) throws Exception {
        return calDaysBetween(from, to, "yyyyMMdd");
    }

    /**
     * @brief
     * \~english Receive date range results
     * \~korean 날짜 월 범위 결과 받음
     * @details
     * <pre>
     * \~english Receive date range results
     * \~korean 날짜 월 범위 결과 받음
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 8. 1
     * @param from start date
     * @param to end date
     * @param format format
     * @return int Calculated date
     * @throws ParseException
     * @throws Exception
     */
    public static int calMonthsBetween(String from, String to, String format) throws ParseException, Exception {
        int result = 0;

        Date fromDate = getDate(from, format);
        Date toDate = getDate(to, format);
        if (fromDate.compareTo(toDate) == 0) {
            return result;
        }

        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy", Locale.KOREA);
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM", Locale.KOREA);

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

    /**
     * @brief
     * \~english Receive date range results
     * \~korean 날짜 월 범위 결과 받음
     * @details
     * <pre>
     * \~english Receive date range results
     * \~korean 날짜 월 범위 결과 받음
     * </pre>
     * @author : CHOI, YOUNG-HWAN
     * @date : 2016. 8. 1
     * @param from start date
     * @param to end date
     * @return int Calculated date
     * @throws ParseException
     * @throws Exception
     */
    public static int calMonthsBetween(String from, String to) throws ParseException, Exception {
        return calMonthsBetween(from, to, "yyyyMMdd");
    }

//    public static void main(String[] args) {
//
//        System.out.println("isValidDate(int yyyy, int mm, int dd) : " + isValidDate(2014, 2, 29));
//
//        System.out.println("isValidDate(String yyyyMMdd) : " + isValidDate("20140229"));
//
//        System.out.println("isValidDate(String s, String format) : " + isValidDate("2014-12-28", "yyyy-MM-dd"));
//
//    }
    
    /**
     * @brief 
     * \~english 
     * \~korean 일자 정보 : 입력받은 일자의 윤년여부를 산출함..
     * @details
     * \~english 
     * \~korean 일자 정보 : 입력받은 일자의 윤년여부를 산출함.
     * </pre>
     * @author : KIM, YOUNG-HOON
     * @date : 2020. 6. 22
     * @param from date
     * @return to bLpyrYn
     * @throws ParseException
     * @throws Exception
     */
    public static boolean clclLpyrYn(String date) throws Exception {
        boolean bLpyrYn = false;
        
        int year = Integer.parseInt(date.substring(0, 4));
        
        if ((year % 4 ==0 && year % 100 !=0)||  year % 400 == 0) {
            bLpyrYn = true;
        }
        
        return bLpyrYn;
    }
    

}
