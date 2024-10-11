package day09;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Stream03 {

	public static void main(String[] args) {
		/* Student 클래스로 리스트 구성
		 * Student 이름, 점수만 가지는 클래스
		 * 
		 * 학생 5명을 추가하고, 콘솔에 출력
		 * 홍길동 : 80
		 */
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("홍길동", 80));
		students.add(new Student("홍길순", 90));
		students.add(new Student("김길남", 75));
		students.add(new Student("박영희", 60));
		students.add(new Student("최영숙", 49));
		
		//스트림을 이용하여 콘솔에 출력
		students.stream()
		.forEach(n->System.out.println(n));
		System.out.println("-------------");
		
		//toString이용하지 않고 출력
		students.stream()
		.forEach(n->{
			String name = n.getName();
			int score = n.getScore();
			System.out.println(name+"=>"+score);
		});
		
		System.out.println();
		//students의 점수 합계 / 전체 인원수
		int sum = students.stream()
				.mapToInt(n->n.getScore())
				.sum();
		System.out.println("점수합계:"+sum);
		long count =
				students.stream().count();
		System.out.println("인원수:"+count);
		
		System.out.println("-----------------");
		//이름순으로 정렬하여 출력
		students.stream()
		.sorted(new Comparator<Student>() {
			public int compare(Student o1, Student o2) {
				// o2 => 내림차순
				return o1.getName().compareTo(o2.getName());
			}
			
		}).forEach(System.out::println);
		
		
	}

}

class Student{
	private String name;
	private int score;
	
	public Student() {}
	
	public Student(String name, int score ){
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return name + ":" + score;
	}
	
	
	
	
}
