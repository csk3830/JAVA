package day03;

/* 1장의 카드를 생성하기 위한 클래스
 * - 숫자 : 1~13 1(A) 11(J) 12(Q) 13(K)
 * - 모양 : ♦ ♥ ♣ ♠
 * - 한장의 카드를 출력하는 print() => ♥A  ♦3
 * - ♣11 => ♣J	/	♣12 => ♣Q	/	♣13=> ♣K
 * - #1 => ♥A	/	#25 => ♥A	/	♣15 => ♣A
 *   - 모양이 없는 모양이면 무조건♥, 숫자가 없으면 무조건 A
 */
/* 클래스 구성
 * - 멤버변수 : 모양(shape), 숫자(num) => private getter/setter
 * - 메서드 : print()
 * - 생성자 : 기본생성자만 생성 => ♥A
 * - setShape()	/	setNum()	: 설정할 수 있는 숫자와 모양을 제한(setter에서)
 */
//public class Card {
//	private String shape;
//	private int num;
//	
//	public Card() {
//		this.shape = "♥";
//		this.num = 1;
//	}
//	
//	public void print(){  //숫자 모양을 바꿔서 찍기.
//		String printNum;
//		switch(num) {
//		case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10:
//			printNum = String.valueOf(num); 
//			break;
//		case 11: printNum="J"; break;
//		case 12: printNum="Q"; break;
//		case 13: printNum="K"; break;
//		default: printNum="A"; break;
//		}
//		System.out.println(shape+printNum);
//	}
//	
//	public String getShape() {
//		return shape;
//	}
//	public void setShape(String shape) {
//		if (shape == "♦" || shape == "♥" || shape == "♣" || shape == "♠") {
//	        this.shape = shape;
//	    } else {
//	        this.shape = "♥"; 
//	    }
//	}
//	public int getNum() {
//		return num;
//	}
//	public void setNum(int num) {
//	    if (num >= 1 && num <= 13) {
//	        this.num = num;
//	    } else {
//	        this.num = 1; 
//	    }
//	}
//	
//	
//	
//}

public class Card {
	private int num;
	private String shape; // char 가능

	// 생성자
	public Card() {
		this.num = 1;
		this.shape = "♥";
	}

	// print
	public void print() {
		System.out.print(shape); // 1=A, 11=J, 12=Q, 13=K
		switch (num) {
		case 1:
			System.out.print("A ");
			break;
		case 11:
			System.out.print("J ");
			break;
		case 12:
			System.out.print("Q ");
			break;
		case 13:
			System.out.print("K ");
			break;
		default:
			System.out.print(num + " ");
		}
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		// 1~13까지만 가능
		if (num < 1 || num > 13) {
			this.num = 1;
		} else {
			this.num = num;
		}
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		// ♦ ♥ ♣ ♠
		switch (shape) {
		case "♦":
		case "♥":
		case "♣":
		case "♠":
			this.shape = shape;
			break;
		default:
			this.shape = "♥";
		}
	}

}
