package banking_web.controller.beans;

public class withdrawdepositBeans {
	private double deposit ;
	private double withdraw;
	public withdrawdepositBeans(double deposit, double withdraw) {
		super();
		this.deposit = deposit;
		this.withdraw = withdraw;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public double getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}
	
  
}
