package day10;

import java.io.File;

public class File06 {

	public static void main(String[] args) {
		// File 객체 : 경로+확장자
		// D:\sk\java\java_workspace\java_project\test.txt
		// 파일 생성
		// File.separator : 파일 경로 구분자(운영체제마다 다름)	\\	( \ / )
		// txt, xml, json, csv
		// 데이터 센터 => xml, json(가장 많이 사용)	공공데이터포털 : https://www.data.go.kr/
		
		File f = new File("D:\\sk\\java\\java_workspace\\java_project\\test.txt");
		System.out.println(File.separator);
		String name = f.getName();
		System.out.println(name);	//파일명.확장자
		System.out.println(f.getPath());	//경로+파일명+확장자
		System.out.println(f.getParent());	//경로만
		
		//파일 객체를 스트링으로 변환
		String f2 = f.toString();
		System.out.println(f2);
		String f2Name = f2.substring(f2.lastIndexOf(File.separator)+1);
		System.out.println(f2Name);
	}

}
