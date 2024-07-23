package banking_web.controller.beans;

public class changepwdBeans {
	private int accountId;
	private String oldpwd ;
	private String newpwd1;
	private String newpwd2;
	public changepwdBeans(int accountId, String oldpwd, String newpwd1, String newpwd2) {
		super();
		this.accountId = accountId;
		this.oldpwd = oldpwd;
		this.newpwd1 = newpwd1;
		this.newpwd2 = newpwd2;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getOldpwd() {
		return oldpwd;
	}
	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}
	public String getNewpwd1() {
		return newpwd1;
	}
	public void setNewpwd1(String newpwd1) {
		this.newpwd1 = newpwd1;
	}
	public String getNewpwd2() {
		return newpwd2;
	}
	public void setNewpwd2(String newpwd2) {
		this.newpwd2 = newpwd2;
	}
	
	
}
