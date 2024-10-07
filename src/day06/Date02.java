package day06;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date02 {

	public static void main(String[] args) {
		// LocalDateTime
		LocalDateTime today = LocalDateTime.now();
		System.out.println(today);
		System.out.println(today.getYear());
		String t = today.toString();
		System.out.println(t);
		String date = t.substring(0, t.indexOf("1"));
		System.out.println(date);
		// 시:분:초 추출
		String time = t.substring(t.indexOf("T")+1, t.indexOf("."));
		System.out.println(time);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
		System.out.println(dtf.format(today));

		LocalDateTime sDate = LocalDateTime.of(2009, 9, 30, 8, 30);
		System.out.println(sDate.format(dtf));
	}

}
