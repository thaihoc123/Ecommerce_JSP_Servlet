package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DbCon;
import Model.Account;
import Model.Oder;
import Model.OderDetail;
import Model.OderUser;

public class OderDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public OderDao() {
		// TODO Auto-generated constructor stub
	}
	
	public void insert(String date,int idBuyer) {
		String sql = "INSERT INTO `webbanhang`.`oder` (`NgayMua`, `idBuyer`) VALUES (?, ?);";
		try {
			con=DbCon.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, date);
			ps.setInt(2, idBuyer);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public int getLast() {
		String sql="SELECT * FROM oder order by idOder desc limit 1";
		try {
			con = DbCon.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt("idOder");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	public void insertOderDetail(int idP,int idO,int quanlity) {
		String sql = "INSERT INTO `webbanhang`.`oderdetail` (`quanlity`, `id_product`, `id_oder`) VALUES (?, ?, ?);";
		try {
			con=DbCon.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, quanlity);
			ps.setInt(2, idP);
			ps.setInt(3, idO);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	public List<Oder>getAll(){
		List<Oder> ds = new ArrayList();
		String sql = "SELECT * FROM oder";
		try {
			con = DbCon.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ds.add(new Oder(rs.getInt("idOder"), rs.getString("NgayMua"),rs.getInt("idBuyer")));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}
	public List<Account>getUserbyidBuyer(){
		List<Account> ds = new ArrayList();
		String sql = "select id,user,pass,isAdmin from account a join oder o where a.id = o.idBuyer;";
		try {
			con = DbCon.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ds.add(new Account(rs.getInt("id"), rs.getString("user"),rs.getString("pass"), rs.getInt("isAdmin")));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}
	public List<OderUser>getOrderUsers(){
		List<OderUser> ds = new ArrayList();
		String sql = "select o.*,a.user from account a join oder o on a.id = o.idBuyer;";
		try {
			con = DbCon.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ds.add(new OderUser(rs.getInt("idOder"), rs.getString("NgayMua"),rs.getInt("idBuyer"), rs.getString("user")));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}
	public void deleteOder(String id) {
		String sql = "DELETE FROM `webbanhang`.`oder` WHERE (`idOder` = ?);";
		try {
			con=DbCon.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void deleteOderDetail(String id) {
		String sql = "DELETE FROM `webbanhang`.`oderdetail` WHERE (`id_oder` = ?);";
		try {
			con=DbCon.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		OderDao dao=new OderDao();
		System.out.println(dao.getAll());
	}
}
