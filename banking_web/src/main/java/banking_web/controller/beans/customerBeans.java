package banking_web.controller.beans;
public class customerBeans {
	private int account_number;
	private String fullname;
	private String password;
	private String mail;
	private String phone;
	private String dob ;
	private String account_type;
	private String idproof;
	private String address;
	private int balance ;

	public customerBeans(int account_number, String fullname, String password, String mail, String phone, String dob,
			String account_type, String idproof, String address, int balance) {
		super();
		this.account_number = account_number;
		this.fullname = fullname;
		this.password = password;
		this.mail = mail;
		this.phone = phone;
		this.dob = dob;
		this.account_type = account_type;
		this.idproof = idproof;
		this.address = address;
		this.balance = balance;

	}
	public customerBeans(int account_number, String fullname, String mail, String phone, String dob,
			String account_type, String idproof, String address) {
		super();
		this.account_number = account_number;
		this.fullname = fullname;
		this.mail = mail;
		this.phone = phone;
		this.dob = dob;
		this.account_type = account_type;
		this.idproof = idproof;
		this.address = address;
		
	}
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public String getIdproof() {
		return idproof;
	}
	public void setIdproof(String idproof) {
		this.idproof = idproof;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

	
	
	
	
}
