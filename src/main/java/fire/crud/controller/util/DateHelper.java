package fire.crud.controller.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateHelper {

	final private static Logger logger = LoggerFactory.getLogger(DateHelper.class);
	
	public static Date getDate(String s){
		if(null == s|| "".equals(s)){
			return null;
		}
		
		String[] pattern = new String[]{"yyyy-MM","yyyyMM","yyyy/MM",   
                "yyyyMMdd","yyyy-MM-dd","yyyy/MM/dd",   
                "yyyyMMddHHmmss",   
                            "yyyy-MM-dd HH:mm:ss",   
                            "yyyy/MM/dd HH:mm:ss"};   
		String[] pattern2 = new String[]{"yyyy-MM-dd"}; 
		
		try {
			return DateUtils.parseDate(s, pattern2);
		} catch (Exception e) {
			logger.error("错误  {}",e);
			return null;
		}
	}
	
	/**
	 * 本月第一天
	 * @return
	 */
	public static String startDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.DATE, 1);
//		System.out.println(sdf.format(calendar.getTime()));
		return sdf.format(calendar.getTime());

		// StringBuilder sb = new StringBuilder(sdf.format(new Date()));
		// System.out.println(sb.toString());
		// return sb.toString();
	}
	
	public static String startDateOfOneDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
//		System.out.println(sdf.format(calendar.getTime()));
		return sdf.format(calendar.getTime());

		// StringBuilder sb = new StringBuilder(sdf.format(new Date()));
		// System.out.println(sb.toString());
		// return sb.toString();
	}
	
	/**
	 * 给定日期的开始日期 00:00:00
	 * @param date
	 * @return
	 */
	public static Date startDate(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	
//	@Test
	public void testStartDate(){
		System.out.println(startDate(new Date()));
	}
	
	/**
	 * 给定日期的第二天的日期  00:00:00
	 * @param date
	 * @return
	 */
	public static Date endDate(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime();
	}
	
//	@Test
	public void testEndDate(){
		System.out.println(endDate());
	}
	
	public static String endDateOfOneDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.DATE, 1);
//		System.out.println(sdf.format(calendar.getTime()));
		return sdf.format(calendar.getTime());

		// StringBuilder sb = new StringBuilder(sdf.format(new Date()));
		// System.out.println(sb.toString());
		// return sb.toString();
	}
	
//	@Test
	public void test(){
		String s = startDateOfOneDay();
		System.out.println(s);
		s = endDateOfOneDay();
		System.out.println(s);
	}

	/**
	 * 下月第一天
	 * @return
	 */
	public static String endDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.DATE, 1);
		
		if(calendar.get(Calendar.MONTH) == Calendar.DECEMBER){
			calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR)+1);
			calendar.set(Calendar.MONTH, Calendar.JANUARY);
			return sdf.format(calendar.getTime());
		}
		
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)+1);
		return sdf.format(calendar.getTime());
	}
	
	/**
	 * 在某时间加上月份
	 * @param date
	 * @param quantity
	 * @return
	 */
	public static Date addMonth(Date date, int quantity) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, quantity);
		return calendar.getTime();
	}
	
	public static String formatDate(Date date, String pattern){
		if(null==date){
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
}
