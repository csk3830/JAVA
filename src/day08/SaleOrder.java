package day08;

public class SaleOrder extends SaleMenu {
	//Order Class 생성 Menu 상속
	//주문번호
	//제품ID
	//제품명
	//수량
	//가격
	//금액
	private int orderId; 
	private int quantity;
	private int totalPrice;
	private static int orderCnt = 0;
	
	public SaleOrder(int productId, String productName, int price, int quantity) {
        super(productName, price);
        this.quantity = quantity;
        orderCnt++;
        this.orderId = orderCnt;
        this.totalPrice = price * quantity;
    }

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
    

	
}
