/**
 * Created by: dagrawal on Apr 20, 2009
 * Contact: dev.agrawal@gmail.com for help
 */
package com.library.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DateUtil {
	public static final String dateFormat = "mm/dd/yyyy";
	
	public static Log logger = LogFactory.getLog(DateUtil.class);
	
	public static Date addDays(Date date, int days){
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date);
		c1.add(Calendar.DATE, days);
		return c1.getTime();
	}
	public static String getDayofTheDate(Date date) {
		String day = null;
		DateFormat f = new SimpleDateFormat("EEEE");
		try {
			day = f.format(date);
		}
		catch(Exception e) {
			logger.error("error occured in getDayofTheDate()", e);
		}
		return day;
	}
	public static Date parseDate(String date, String format){
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(format);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			logger.error("unable to parse date "+date, e);
			return null;
		}
	}
	public static int daysBetween2Dates(Date d1, Date d2){
		int days = 0;
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(d1);
		c2.setTime(d2);
		days = (int)(c2.getTime().getTime() - c1.getTime().getTime())/(24*3600*1000);
		return days;
	}
}
