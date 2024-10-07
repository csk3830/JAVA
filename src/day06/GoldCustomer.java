package day06;

public class GoldCustomer extends Customer{

	public GoldCustomer(int customerID, String customerName) {
		super(customerID, customerName);
		customerGrade = "Gold"; 
        bonusRatio = 0.02;
        discount = 0.1;
	}
}
