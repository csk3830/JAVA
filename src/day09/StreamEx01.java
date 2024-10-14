package day09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StreamEx01 {

	public static void main(String[] args) {
		/* 여행사 상품
		 * 여행비용이 15세 이상은 100만원, 미만은 50만원으로 계산
		 * 
		 * 고객 5명이 패키지 여행을 떠난다고 했을 경우
		 * 1. 비용계산 => 출력
		 * 2. 고객 명단 출력
		 * 고객 클래스를 생성하고, ArrayList로 고객관리
		 * 
		 * 예)
		 * 이름:이순신 나이:40 비용:100
		 * 이름:신사임당 나이:38 비용:100
		 * 이름:홍길동 나이:30 비용:100
		 * 이름:이짱구 나이:10 비용:50
		 * 이름:이짱아 나이:5 비용:50
		 * 총 여행경비 : xxx
		 * 
		 * 20세 이상 고객명단 => 이름순으로 정렬
		 * 이름:이순신 나이:40 비용:100
		 * 이름:신사임당 나이:38 비용:100
		 * 이름:홍길동 나이:30 비용:100
		 * 
		 *  */
		
		List<Customer> ct = new ArrayList<>();
		ct.add(new Customer("이순신", 40));
		ct.add(new Customer("신사임당", 38));
		ct.add(new Customer("홍길동", 30));
		ct.add(new Customer("이짱구", 10));
		ct.add(new Customer("이짱아", 5));
		
		ct.stream()
		.forEach(n->System.out.println(n));
		
		int sum = ct.stream()
		.mapToInt(n->n.getCost())
		.sum();
		System.out.println("총 여행경비:"+sum);
		
		Collections.sort(ct);	// 클래스에 정렬이 구현되어 있을경우 사용가능
		
		System.out.println("--20세 이상(이름 가나다순)--");
		
		ct.stream()
		.filter(n->n.getAge()>=20)
		//Comparator 구현이 없는 경우
//		.sorted(new Comparator<Customer>() {
//
//			@Override
//			public int compare(Customer o1, Customer o2) {
//				return o1.getName().compareTo(o2.getName());
//			}
//			
//		})
		.sorted()	// Comparator를 기존 클래스에서 구현
		.forEach(System.out::println);
		
		//익명클래스 사용할 경우 Comparator 대상값이 (매개변수가 2개)
		//클래스 내부에서 구현할 경우 Comparable 대상값이 (매개변수 1개)

	}

}
class Customer implements Comparable<Customer> {
	//멤버변수 : 각 인원마다 가져야 할 고유 값
	private String name;
	private int age;
	private int cost;
	
	//생성자
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
		this.cost = age<=15 ? 100 : 50;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "이름:" + name + " 나이:" + age + " 비용:" + cost ;
	}

	@Override
	public int compareTo(Customer o) {
		// this와 o객체를 정렬
		return this.name.compareTo(o.name);
	}
	
}
