package day08;

public class SaleMenu {
//	Menu  Class 생성
//	제품ID
//	제품명
//	가격
	private int productId; 
	private static int idCnt = 0;
    private String productName; 
    private int price; 
	
    public SaleMenu(String productName, int price) {
        this.productName = productName;
        this.price = price;
        idCnt++;
        this.productId = idCnt;
    }

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return productId+"."+productName+":"+price+"원";
	}


	
    
	
}
