package day02;

public class Class02 {
	// 생성자 : 객체를 생성하기 위해 객체의 초기화를 담당
	// Car c = new Car();	=> 클래스 객체명 = new 생성자();
	// 생성자는 여러개 만들 수 있음. (생성자 오버로딩)
	// 생성자명은 클래스명과 동일
	// 생성자가 하나도 없는 경우는 기본 생성자를 자동으로 생성 Car()
	// 생성자를 하나라도 생성하면 기본 생성자는 주지 않음.
	// 생성자를 사용자 지정으로 생성하려면 기본 생성자도 같이 생성해야 함.
	// 생성자 오버로딩 조건 (매개변수 개수가 달라야 함 || 매개변수 타입이 달라야 함.)
	// 생성자 호출 가능. (생성자 내에서만)
	// this : 내 클래스의 요소라는 것을 나타내는 키워드
	// super : 부모 클래스의 요소라는 것을 나타내는 키워드

	public static void main(String[] args) {
		
		Car c = new Car(); 	//생성자 호출은 단 1번 객체생성시만 가능.
		c.setName("SONATA");
		c.setColor("red");
		c.setYear("2024");
		c.printInfo();
		c.power();
		c.speedUp();
		c.speedUp();
		c.speedUp();
		c.speedUp();
		c.speedUp();
		c.speedUp();
		c.speedUp();
		c.print();
		c.power();
		c.speedDown();
		c.speedDown();
		c.speedDown();
		c.speedDown();
		c.speedDown();
		c.speedDown();
		c.speedDown();
		c.print();
		c.power();
		c.print();
		System.out.println("--------------");
		Car c1 = new Car("BMW");
		c1.printInfo();
		Car c2 = new Car("BMW","gray");
		c2.printInfo();
		Car c3 = new Car("BMW","gray","2024");
		c3.printInfo();
	}

}

// Car 클래스 생성
// 멤버변수 : name, color, year, power, speed => private 선언 (getter/ setter 생성)
// 소나타(블랙/2024) => 출력 메서드
// power : 시동 상태 나타내는 메서드 (true / false)
// speed : 속도 up / down 메서드
// 과제로 제출
class Car{
	private String name; //필수
	private String color; //선택
	private String year; //선택
	private boolean power;
	private int speed;
	
	// Class의 위치 순서는 보통 이렇다 : 멤버변수 => 생성자 => 메서드 => getter/setter
	// 생성자 위치
	// 객체를 생성할 때 초기값 지정
	// 생성자의 접근제한자는 반드시 public 이어야 함.
	// 생성자명은 클래스명과 반드시 같아야 함.
	// 생성자는 메서드와 달리 return 타입이 없음.
	public Car() {} // 기본 생성자. 필수!
	public Car(String name) {
		this.name = name;
	}
	public Car(String name, String color) {
		this.name = name;
		this.color = color;
	}
	//불가능 : 오버로딩 조건에 충족이 안됨.
//	public Car(String name, String year) {
//		
//	}
	//생성자 호출 : 생성자 내에 다른 생성자의 값과 완전히 동일한 값이 있을 경우 사용 가능
	public Car(String name, String color, String year) {
		this(name, color); // 생성자 호출 : 반드시 첫줄에서 호출
//		this.name = name;
//		this.color = color;
//		this.year = year;
		this.year = year;
	}
	
	//생성자 생성 => 우클릭 Source => Generate Constructor usign Fields...
	public Car(String name, String color, String year, boolean power, int speed) {
		this(name, color,year); // 생성자 호출 : 반드시 첫줄에서 호출
		this.power = power;
		this.speed = speed;
	}
	
	public void printInfo() {
		System.out.println(name+"("+color + "/"+year+")");
	}
	
	public void print() {
		System.out.println("------------------");
		System.out.println("power:"+ ((power)? "ON" : "OFF"));
		if(!power) {
			System.out.println("시동을 켜주세요.");
		}else {			
			if(speed >= 200) {
				System.out.println("최고 속도입니다. 속도를 줄이세요.");
			} 
			if (speed <= 0) {
				System.out.println("정지된 상태입니다.");
			}
			System.out.println("speed:"+speed);	
		}
		
	}
	
	// 꺼져 있으면 => 켜짐
	// 켜져 있으면 => 꺼짐
	// speed 가 있으면 시동이 꺼지면 안됨.
	public void power() {
		if(speed == 0) {			
			this.power = !this.power;
		}else {
			System.out.println("속도를 줄이세요. 시동을 끌 수 없습니다.");
		}
	}
	
	//speedUp : power 켜져야 스피드가 올라갈수 있음.  200까지만 가능
	public void speedUp() {
		if(power) {
			if(speed <200) {
				speed += 10;			
			}
		}
	}
	//speedDown : power 켜져야 스피드가 내려갈수 있음.  0까지만 가능
	public void speedDown() {
		if(power) {
			if(speed >0) {
				speed -= 10;			
			}
		}
	}
	
	//getter/setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public boolean isPower() {
		return power;
	}
	public void setPower(boolean power) {
		this.power = power;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}
