package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Connection.DbCon;
public class AccountDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public AccountDao() {
		// TODO Auto-generated constructor stub
	}
	public int getIdBuyer(int id) {
		String sql = "SELECT * FROM webbanhang.buyer where id=?";
		try {
			con = DbCon.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt("idBuyer");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
}
