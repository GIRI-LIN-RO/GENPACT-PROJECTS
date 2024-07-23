package banking_web.controller.dao;
import banking_web.controller.beans.BankTransferBeans;
import banking_web.controller.beans.accountId;
import banking_web.controller.beans.customerBeans;
import banking_web.controller.beans.withdrawdepositBeans;
import banking_web.controller.util.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;







public class customerDao {
	public int Checkbalance(accountId aid ) throws SQLException {
    	int balance = 0;
    	
    	try {
    		int  id =  aid.getAccoutnId() ;
    		Connection con = jdbc.getConnection();
    		PreparedStatement ps = con.prepareStatement("select balance from customer where account_id = ?;"); 
    		ps.setInt(1, id);
    		
    		ResultSet rs = ps.executeQuery();
    		
    		if (rs.next()) {balance = rs.getInt("balance");}
    	}
    	catch(Exception e) {e.printStackTrace();}
	    return balance;	
    }
	
	
	public void delete(accountId customer)throws SQLException{
    	
    	
    	try {
    		Connection con = jdbc.getConnection();
    		PreparedStatement ps = con.prepareStatement("delete from customer where account_id = ?");
    		ps.setInt(1,customer.getAccoutnId());
			ps.executeUpdate();  		
    	}
    	catch(Exception e){
    		System.out.println("wronguda");
    		e.printStackTrace();}
    }
	
	public static void Changepassword(int id , String pwd)throws SQLException {
    	try {
    		Connection con = jdbc.getConnection();
    		PreparedStatement ps = con.prepareStatement("update customer set password = ? where account_id = ?");
    		
    		ps.setString(1,pwd);
    		
    		ps.setInt(2,id);
    		
    		ps.executeUpdate();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		
    	}
    }
	public void Deposit(accountId accountid,withdrawdepositBeans wdb)throws SQLException{
    	try {
    		int id = accountid.getAccoutnId();
    		Connection con = jdbc.getConnection();
    		PreparedStatement ps = con.prepareStatement("update customer set balance=balance+? where account_id = ?;");
    		PreparedStatement ps2 = con.prepareStatement("insert into transactions (amount,type,sender_id) values(?,?,?)");
    		ps.setDouble(1,wdb.getDeposit() );
    		ps.setInt(2,id);    		
    		
    		ps2.setDouble(1, wdb.getDeposit());
    		ps2.setString(2,"self deposit");
    		ps2.setInt(3, id);
    		
    		ps.executeUpdate();
    		ps2.executeUpdate();
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    } 
    

    
    public void Withdraw(accountId accountid,withdrawdepositBeans wdb)throws SQLException{
    	try {
    		int id = accountid.getAccoutnId();
    		Connection con = jdbc.getConnection();
    		PreparedStatement ps = con.prepareStatement("update customer set balance=balance-? where account_id = ?;");
    		PreparedStatement ps2 = con.prepareStatement("insert into transactions (amount,type,recipient_id) values(?,?,?)");
    		ps.setDouble(1,wdb.getWithdraw() );
    		ps.setInt(2,id);    		
    		
    		ps2.setDouble(1, wdb.getWithdraw());
    		ps2.setString(2,"self withdraw");
    		ps2.setInt(3, id);
    		
    		ps.executeUpdate();
    		ps2.executeUpdate();
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    public void transferBank(BankTransferBeans btb) {
    	
    	try {
    		Connection con = jdbc.getConnection();
    		PreparedStatement ps = con.prepareStatement("update customer set balance = balance + ? where account_id = ?");
    		ps.setDouble(1, btb.getAmount());
    		ps.setInt(2, btb.getRecipient());
    		ps.executeUpdate();
    		ps = con.prepareStatement("update customer set balance = balance - ? where account_id = ?");
    		ps.setDouble(1,btb.getSender());
    		ps.setInt(2, btb.getAmount());
    		ps.executeUpdate();
    		ps = con.prepareStatement("insert into transactions (amount,type,sender_id,recipient_id) values(?,?,?,?)");
    		ps.setDouble(3,btb.getSender());
    		ps.setInt(1, btb.getAmount());
    		ps.setString(2, "from"+Integer.toString(btb.getSender())+"to"+Integer.toString(btb.getRecipient()));
    		ps.setInt(4, btb.getRecipient());
    		ps.executeUpdate();
    		
    	}
    	catch(Exception e) {e.printStackTrace();}
    }
public void update(customerBeans customer)throws SQLException{
    	
    	
    	try {
    		Connection con = jdbc.getConnection();
    		PreparedStatement ps = con.prepareStatement("update customer set fullname = ?,phone=?,email=?,type=?,dob=?,id_proof=?,address=? where (account_id =?);");
    		ps.setString(1, customer.getFullname());
			ps.setString(2,customer.getPhone());
			ps.setString(3, customer.getMail());
			ps.setString(4, customer.getAccount_type());
			ps.setString(5, customer.getDob());
			ps.setString(6, customer.getIdproof());
			ps.setString(7, customer.getAddress());
			ps.setInt(8,customer.getAccount_number());
			ps.executeUpdate();
    	}
    	catch(Exception e){e.printStackTrace();
    }
    }
	public String passValid(int id ,String pass) {
		String valid = null;
		
		try {
			
			Connection con = jdbc.getConnection();
			PreparedStatement ps = con.prepareStatement("select fullname from customer where account_id = ? and password = ?");
			ps.setInt(1, id);
			ps.setString(2,pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				valid = "1"; 
			}
			else {
				valid = "2";
			}
			
		}
		catch(Exception e) {e.getStackTrace();}
		return valid;
	}


	public void deleteCust() {
	
	
	}
	
}
