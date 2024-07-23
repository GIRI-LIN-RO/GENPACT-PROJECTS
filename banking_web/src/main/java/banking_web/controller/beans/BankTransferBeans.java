package banking_web.controller.beans;

public class BankTransferBeans {
	private int recipient;
	private int sender;
	private int amount;
	public BankTransferBeans(int recipient, int sender, int amount) {
		super();
		this.recipient = recipient;
		this.sender = sender;
		this.amount = amount;
	}
	public int getRecipient() {
		return recipient;
	}
	public void setRecipient(int recipient) {
		this.recipient = recipient;
	}
	public int getSender() {
		return sender;
	}
	public void setSender(int sender) {
		this.sender = sender;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
