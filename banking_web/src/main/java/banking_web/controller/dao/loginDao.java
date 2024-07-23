package banking_web.controller.dao;
import banking_web.controller.util.jdbc ;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import banking_web.controller.beans.loginBeans;

public class loginDao{
	
	Connection con ;
	public int validate(loginBeans logins) throws SQLException {
		con = jdbc.getConnection();
		int cond = 0 ;
		int accountId  = logins.getAccountId();
		String password = logins.getPassword();
		try {
		PreparedStatement ps = con.prepareStatement("select priv from customer where account_id = ? and password = ?;");
		ps.setInt(1, accountId);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			int priv = rs.getInt("priv");
			if (priv == 1) {
				cond =  1;
			}
			else if(priv == 2) {
				cond =  2;
			}
		}
		else {
			cond =  0 ;
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return cond;
	}
}
