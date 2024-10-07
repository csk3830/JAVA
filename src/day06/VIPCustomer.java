package day06;

public class VIPCustomer extends Customer{
	private int agentID;

	public VIPCustomer(int customerID, String customerName, int agentID) {
		super(customerID, customerName);
		customerGrade = "VIP"; 
        bonusRatio = 0.05;
        discount = 0.1;
        this.agentID = agentID;
	}

	@Override
	public String toString() {
		return super.toString() +"\n전담 상담사 번호는 "+agentID+"입니다.";
	}

	public int getAgentID() {
		return agentID;
	}

	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}
	
	
	
}
