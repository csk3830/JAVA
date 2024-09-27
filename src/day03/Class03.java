package day03;

// Tv 클래스 생성
/* 멤버변수 : brand, power, ch, vol
 * 메서드 : 
 * power()
 * chUp() / chDown() : 1씩증가 20까지 있음. 20이 넘어가면 다시 0번으로 돌아오는 순환구조
 * volUp() / volDown() : 1씩증가 / 1씩감소 10까지 있음 10이 넘어가면 10. 0이면 음소거 출력
 */

class Tv{
	private final String BRAND = "LG";	//final : 변경할 수 없는 값을 지정 대문자로 쓰는 것을 원칙으로 함. get은 가능, set은 불가능.
	private boolean power;
	private int ch;
	private int vol;
	
	public Tv() {
		this.vol = 3;
	}
//	public Tv(String brand) {
//		this.BRAND = brand;
//		this.vol = 3;
//	}
//	
	public void print() {
		System.out.println(BRAND+"TV / CH:"+ch+" / VOL:"+vol);
	}
	
	public void power() {
		power =!power;
		if(power) {
			System.out.println("전원 ON");
			print();
		}else {
			System.out.println("전원 OFF");
		}
	}
	
	public void chUp() {
		if(power) {
			if(ch >=20) {
				ch=-1;
			}
			ch++;
		}
		System.out.println("ch:"+ch);
	}

	public void chDown() {
		if(power) {
			if(ch<=0) {
				ch=21;
			}
			ch--;
		}
		System.out.println("ch:"+ch);
	}
	
	public void volUp() {
		if(power) {
			if(vol >=10) {
				vol = 10; 
			}else {
				vol++;
			}
			
		}
		System.out.println("vol:"+vol);
	}
	public void volDown() {
		if(power) {
			if(vol <=0) {
				vol = 0; 
				System.out.println("음소거");
			}else {
				System.out.println("vol:"+vol);
				vol--;
			}
			
		}
	}
	
	public String getBrand() {
		return BRAND;
	}
//	public void setBrand(String brand) {
//		this.BRAND = brand;
//	}
	public boolean isPower() {
		return power;
	}
	public void setPower(boolean power) {
		this.power = power;
	}
	public int getCh() {
		return ch;
	}
	public void setCh(int ch) {
		this.ch = ch;
	}
	public int getVol() {
		return vol;
	}
	public void setVol(int vol) {
		this.vol = vol;
	}
	
	
}





public class Class03 {

	public static void main(String[] args) {
		Tv t = new Tv();
		t.power();
		t.chUp();
		t.chUp();
		t.chUp();
		t.setCh(19);
		t.chUp();
		t.chUp();
		t.chUp();
		t.chDown();
		t.chDown();
		t.setCh(1);
		t.chDown();
		t.chDown();
		t.volUp();
		t.volUp();
		t.volUp();
		t.volUp();
		t.volUp();
		t.volUp();
		t.volUp();
		t.volUp();
		t.volUp();
		t.volUp();
		t.volUp();
		t.volUp();
		t.volDown();
		t.volDown();
		t.setVol(2);
		t.volDown();
		t.volDown();
		t.volDown();
		t.setVol(9);
		t.volUp();
		t.volUp();
		t.setVol(1);
		t.volDown();
		
//		Tv t = new Tv();
//		t.setBrand("삼성");
//		t.power();
//		t.print();
//		t.chUp();
//		t.chUp();
//		t.chUp();
//		t.chUp();
//		t.chUp();
//		t.chUp();
//		t.chUp();
//		t.chUp();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.chDown();
//		t.volUp();
//		t.volUp();
//		t.volUp();
//		t.volUp();
//		t.volUp();
//		t.volUp();
//		t.volDown();
//		t.volDown();
//		t.volDown();
//		t.volDown();
//		t.volDown();
//		t.volDown();
//		t.print();
		
	}

}

// Tv 클래스 생성
/* 멤버변수 : brand, power, ch, vol
 * 메서드 : 
 * power()
 * chUp() / chDown() : 1씩증가 20까지 있음. 20이 넘어가면 다시 0번으로 돌아오는 순환구조
 * volUp() / volDown() : 1씩증가 / 1씩감소 10까지 있음 10이 넘어가면 10. 0이면 음소거 출력
 */
//class Tv{
//	private String brand;
//	private boolean power;
//	int ch;
//	int vol;
//	
//	public void print() {
//		System.out.println(brand+"TV | 채널:"+ch+" | 볼륨:"+vol );
//	}
//	
//	public void power() {
//		power = !power;
//		System.out.println(power ? "전원 ON" : "전원 OFF");
//	}
//	
//	public void chUp() {
//		if (ch >= 20) {
//			ch = 0;
//		}else {
//			ch++;
//		}
//		System.out.println("현재 채널 : " + ch);
//	}
//	public void chDown() {
//		if (ch <= 0) {
//			ch = 20;
//		}else {
//			ch--;
//		}
//		System.out.println("현재 채널 : " + ch);
//	}
//	
//	public void volUp() {
//		if (vol >= 10) {
//			vol = 10;
//		} else {
//			vol ++;
//		}
//		System.out.println("현재 음량 : "+vol);
//	}
//	public void volDown() {
//		if (vol <= 0) {
//			vol = 0;
//		} else {
//			vol --;
//		}
//		System.out.println("현재 음량: " + (vol <= 0 ? "음소거" : vol) );
//	}
//	
//	public String getBrand() {
//		return brand;
//	}
//	public void setBrand(String brand) {
//		this.brand = brand;
//	}
//	public boolean isPower() {
//		return power;
//	}
//	public void setPower(boolean power) {
//		this.power = power;
//	}
//	public int getCh() {
//		return ch;
//	}
//	public void setCh(int ch) {
//		this.ch = ch;
//	}
//	public int getVol() {
//		return vol;
//	}
//	public void setVol(int vol) {
//		this.vol = vol;
//	}
//	
//	
//	
//}
