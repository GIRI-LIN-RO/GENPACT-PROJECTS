package banking_web.controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import banking_web.controller.beans.customerBeans;
import banking_web.controller.util.jdbc;

public class createcustomerDao {
	
	
	public void Create(customerBeans cust,int priv) {
		try {
			String name = cust.getFullname();
			String phone = cust.getPhone();
			String email = cust.getMail();
			String type = cust.getAccount_type();
			String dob = cust.getDob();
			int balance = 1000;
			String id_proof=cust.getIdproof();
			String address = cust.getAddress();
			
			Connection con = jdbc.getConnection();			
			PreparedStatement ps = con.prepareStatement("insert into customer(fullname,phone,email,type,dob,balance,id_proof,address,password,priv) values(?,?,?,?,?,?,?,?,?,?)");
			
			PreparedStatement pass = con.prepareStatement("select banking.generate_pass(8) as pass");
			ResultSet rs = pass.executeQuery();
			rs.next();
			ps.setString(1,name );
			ps.setString(2, phone);
			ps.setString(3, email);
			ps.setString(4, type);
			ps.setString(5, dob);
			ps.setInt(6, balance);
			ps.setString(7, id_proof);
			ps.setString(8, address);
			ps.setString(9, rs.getString("pass"));
			ps.setInt(10, priv);
			ps.executeUpdate();
			
			
		}
		catch(Exception e) {e.printStackTrace();}
		
	}
}
