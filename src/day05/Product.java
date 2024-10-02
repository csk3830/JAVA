package day05;

public class Product {
	private int num;
	private String name;
	private int price;
	private static int idx = 0;
	
	public Product() {}
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
		this.idx++;
		this.num = idx;
	}
	
	public void insertProduct(String name, int price) {
		this.name = name;
		this.price = price;
		this.idx++;
		this.num = idx;
	}
	@Override
	public String toString() {
		return num+"."+name + ":" + price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
