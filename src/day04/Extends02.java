package day04;

class Animal{
	// 동물의 이름과 종류를 나타내는 클래스
	// 메서드 : 이름과 종류를 출력하는 메서드, 동물의 울음소리를 출력하는 메서드
	private String name;
	private String category;
	
	public Animal() {}
	public Animal(String name, String category){
		this.name = name;
		this.category= category;
	}
	
	//출력메서드
	public void printInfo() {
		System.out.println("이름:"+name+" / 종류:"+category);
	}
	
	//울음소리 메서드
	public void howl() {
		System.out.println("--"+name+"의 울음소리");
		// 나머지는 자식이 구현
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}

// Dog, Cat Animal 클래스를 상속받아 생성
// printInfo() 	/ howl() 	: 오버라이딩 후 본인의 울음소리를 추가해서 출력

class Dog extends Animal{
	//생성자
	public Dog() {
		setName("강아지");
		setCategory("개과");
	}
	
	@Override
	public void howl() {
		super.howl();	//부모의 howl() 메서드 값
		System.out.println("왈왈!!");
	}
}
class Cat extends Animal{
	
	public Cat(String name, String category) {
		super.setName(name);
		super.setCategory(category);
	}
	
	@Override
	public void howl() {
		super.howl();
		System.out.println("그릉그릉..");
	}
}
class Tiger extends Animal{
	public Tiger(String name, String category) {
		super(name, category); 	//부모 생성자 호출
	}
	
	@Override
	public void howl() {
		super.howl();
		System.out.println("어흥~!!");
	}
}

public class Extends02 {

	public static void main(String[] args) {
		// 오버라이딩 : 부모클래스의 메서드를 재정의하여 사용하는 것
		// - 부모클래스의 메서드와 선언부가 일치해야 함. { 구현만 재정의 가능. }
		// - 접근제한자는 더 넓은 범위만 가능, 축소는 안됨.
		Dog d = new Dog();
		d.printInfo();
		d.howl();
		System.out.println("-------------------------");
		
		Cat c = new Cat("나비", "고양이과");
		c.printInfo();
		c.howl();
		System.out.println("--------------------------");
		
		Tiger t = new Tiger("산신", "고양이과");
		t.printInfo();
		t.howl();
		
	}

}
