package day06;

import java.util.Calendar;
import java.util.Date;

public class Date01 {

	public static void main(String[] args) {
		/* 날짜/시간 클래스
		 * Date 클래스 => Deprecated(비권장)
		 * Calendar => Date 후속작. 추상클래스 => 객체를 생성할 수 없음.
		 * new 키워드로 객체 생성이 불가능.
		 * getInstance() 메서드를 이용하여 객체를 얻어 옴
		 * 
		 * */
		Date d = new Date();
		System.out.println(d);
		Calendar c = Calendar.getInstance();	//오늘날짜
		System.out.println(c);
		System.out.println("-------------------");
		int year = c.get(Calendar.YEAR);
		System.out.println(year);
		//month 0~11 	+1 표현
		int month = c.get(Calendar.MONTH) + 1;
		System.out.println(month);
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		int week = c.get(Calendar.DAY_OF_WEEK);
		// 일요일-1 ...
		System.out.println(week);
		System.out.println(year+"-"+month+"-"+day);
		
		System.out.println("---------------------");
		//2024-10-7(월) 오후 3:51
		String weekStr= "";
		String hourStr= c.get(Calendar.AM_PM)==0 ? "오전" : "오후";
		
		switch(week) {
		case 1: weekStr = "일"; break;
		case 2: weekStr = "월"; break;
		case 3: weekStr = "화"; break;
		case 4: weekStr = "수"; break;
		case 5: weekStr = "목"; break;
		case 6: weekStr = "금"; break;
		case 7: weekStr = "토"; break;
		}
		
		System.out.println( year+"-"+month+"-"+day+"("+weekStr+") "+hourStr+" "+c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE) );
		
		
		
	}

}
