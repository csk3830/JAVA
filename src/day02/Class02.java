package day02;

public class Class02 {

	public static void main(String[] args) {
		
		Car c = new Car();
		
		//이름 색상 연식 출력메서드
		c.setName("소나타");
		c.setColor("블랙");
		c.setYear("2024");
		c.print();
		
		//power on
		c.setPower();
		System.out.println(c.isPower());
		
		//speed up
		c.setSpeedUp();
		c.setSpeedUp();
		c.setSpeedUp();
		c.setSpeedUp();
		c.setSpeedUp();
		System.out.println(c.getSpeed());
		
		//speed down
		c.setSpeedDown();
		c.setSpeedDown();
		c.setSpeedDown();
		System.out.println(c.getSpeed());
		
		
	}

}

// Car 클래스 생성
// 멤버변수 : name, color, year, power, speed => private 선언 (getter/ setter 생성)
// 소나타(블랙/2024) => 출력 메서드
// power : 시동 상태 나타내는 메서드 (true / false)
// speed : 속도 up / down 메서드

class Car {
	private String name, color, year;
	private boolean power;
	private int speed;
	
	public void print() { //출력 메서드
		System.out.println(this.name + "("+this.color+"/"+this.year+")");
	}
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
	public void setPower() {
		this.power = !power;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeedUp() {
		this.speed++;
	}
	public void setSpeedDown() {
		this.speed--;
	}
	
	
	
}

