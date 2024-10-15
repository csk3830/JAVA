package jdbc;

public class Product {
	//DB의 테이블과 일치하는 객체 생성
//	pno int auto_increment,
//	pname varchar(50) not null,
//	price int default 0,
//	regdate datetime default now(),
//	madeby text,
//	primary key(pno)
	
	private int pno; //자동생성
	private String pname;
	private int price;
	private String regdate;	//now()
	private String madeby;
	
	//생성자 
	public Product() {}
	
	//상품등록	-> pname, price, madeby
	public Product(String pname, int price, String madeby) {
		this.pname = pname;
		this.price = price;
		this.madeby = madeby;
	}
	
	//상품리스트 -> pno, pname, price
	public Product(int pno, String pname, int price) {
		this.pno = pno;
		this.pname = pname;
		this.price = price;
	}

	//상품상세보기 -> 전부
	public Product(int pno, String pname, int price, String regdate, String madeby) {
		this.pno = pno;
		this.pname = pname;
		this.price = price;
		this.regdate = regdate;
		this.madeby = madeby;
	}
	
	//상품수정 -> pname, price, madeby, pno
	public Product(String pname, int price, String madeby, int pno) {
		this(pname,price, madeby);
		this.pno = pno;
	}

	// gettersetter / toString
	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getMadeby() {
		return madeby;
	}

	public void setMadeby(String madeby) {
		this.madeby = madeby;
	}

	@Override
	public String toString() {
		return  pno + ". 상품명:" + pname + "(" + price + ") / " + regdate + "["
				+ madeby + "]";
	}
	
	public String listPrint() {
		return pno + ". 상품명:" + pname + "(" + price + ")";
	}
	
	
	
	
	
	
	
	
}
