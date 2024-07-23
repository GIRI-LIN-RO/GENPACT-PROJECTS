package banking_web.controller.beans;

public class loginBeans {
	private int accountId ; 
	private String password ;
	public loginBeans(int accountId, String password) {
		super();
		this.accountId = accountId;
		this.password = password;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
