package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DbCon;
import Model.Product;
import Model.ProductDetail;

public class ProductDetailDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public ProductDetailDao() {
		// TODO Auto-generated constructor stub
	}
	public List<ProductDetail> getProductById(int id) {
		List<ProductDetail> ds = new ArrayList();
		String sql = "SELECT * FROM productDetail where id_product=?";
		try {
			con = DbCon.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductDetail s=new ProductDetail(rs.getInt("id"), rs.getString("img"), rs.getInt("id_product"));
				ds.add(s);
			}
		} catch (Exception e) {
		}
		return ds;
	}
	
}
