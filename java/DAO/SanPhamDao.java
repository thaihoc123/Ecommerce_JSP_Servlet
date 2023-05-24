package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DbCon;
import Model.Account;
import Model.Product;

public class SanPhamDao {
	Connection con = null;
	PreparedStatement ps = null; 
	ResultSet rs = null;
	public SanPhamDao() {
	}
	public List<Product> AllSanPham() {
		List<Product> ds = new ArrayList();
		String sql = "SELECT * FROM product";
		try {
			con = DbCon.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Product s=new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5));
				ds.add(s);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}
	public List<Product> SearchSanPham(String searchValue) {
		List<Product> ds = new ArrayList();
		String sql = "SELECT * FROM product where name like ?";
		try {
			con = DbCon.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1,"%"+searchValue+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				Product s=new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5));
				ds.add(s);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}
	
	public Product getProductById(String id) {
		Product p=null;
		String sql = "SELECT * FROM product where id=?";
		try {
			con = DbCon.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				p=new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return p;
	}
	
	public void AddNew(String tenSanPham, String gia, String hinhAnh,String des) {
		String sql = "INSERT INTO `webbanhang`.`product` (`name`, `img`, `description`, `price`) VALUES (?, ?, ?, ?);";
		try {
			con=DbCon.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, tenSanPham);
			ps.setString(2, hinhAnh);
			ps.setString(3, des);
			ps.setInt(4, Integer.parseInt(gia));
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public Account login(String user, String pass) {
		Account account=null;
		String query = "SELECT * FROM account where user=? and pass=?";
		try {
			con=DbCon.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs=ps.executeQuery();
			if(rs.next()) {
				account = new Account(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	return account;
	}
	
	public boolean CheckUser(String user) {
		String query = "SELECT * FROM webbanhang.account where user=?";
		try {
			con=DbCon.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, user);
			rs=ps.executeQuery();
			while(rs.next()) {
				return true;
			}
		} catch (Exception e) {
		}
	return false;
	}
	
	public void AddUser(String user, String password) {
		String sql = "INSERT INTO `webbanhang`.`account` (`user`, `pass`, `isAdmin`) VALUES (?, ?, ?)";
		
		try {
			con=DbCon.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, password);
			ps.setInt(3, 0);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}
	
	public void DeleteSanPham(String id) {
		String sql = "DELETE FROM `webbanhang`.`product` WHERE (`id` = ?)";
		
		try {
			con=DbCon.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void UpdateProduct(String name, String image, String des,String price,String id) {
//		System.out.println(name);
		String sql = "UPDATE product SET name = ?,img = ?, description = ?, price = ? WHERE id = ?";
		try {
			con=DbCon.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, image);
			ps.setString(3, des);
			ps.setString(4, price);
			ps.setString(5, id);
			ps.executeUpdate();
			
			System.out.println("updated");
		} catch (Exception e) {
		}
		
	}
	public boolean UpdateAccount(String user, String pass) {
		String sql = "UPDATE account SET pass = ? WHERE user = ?";
		try {
			con=DbCon.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, pass);
			ps.setString(2, user);
			ps.executeUpdate();
			int row = ps.executeUpdate();
			if(row > 0) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}
}
