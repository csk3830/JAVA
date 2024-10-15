package day11;

import java.util.Calendar;

public class Singleton01 {

	public static void main(String[] args) {
		/* 디자인 패턴 : 개발자들이 개발 과정에서 하나의 패턴으로 묶어놓은 코드 조합
		 * https://refactoring.guru/ko/design-patterns
		 * 디자인 패턴 중 하나
		 * 싱글톤 : 단 1개만 존재해야 하는 객체를 생성하여 => 공유하고자 할 때 사용
		 * */
		
		// Singleton 객체 생성
		// Singleton s = new Singleton();	// 생성자가 private라서 생성이 안 됨.
		// static 메서드/멤버변수는 클래스명으로부터 바로 접근
		Singleton s = Singleton.getInstance();
		Singleton s1 = Singleton.getInstance();
		// 하나의 객체를 공유
		System.out.println(s);
		System.out.println(s1);
		
		Calendar c = Calendar.getInstance(); //캘린더도 싱글턴임.
		System.out.println(c);
		Calendar c1 = Calendar.getInstance();
		System.out.println(c1);
	}

}

class Singleton{
	
	// 단 1개만 존재하기 위해 객체의 인스턴스 생성 (공유)
	private static Singleton instance;
	// 생성자를 통해 객체 생성을 막기 위해 생성자를 private 설정
	private Singleton() {}
	
	// getInstance() 메서드를 사용하여 instance를 생성 리턴
	// instance가 있으면 기존 instance를 리턴
	// instance가 없으면 새로 생성해서 리턴
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}