package market.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import market.util.DBCon;
import market.vo.ProductVO;

public class ProductDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ProductDAO() {
		con = DBCon.getConnection();
	}
	
	public List<ProductVO> selectAllProduct() {
		String sql = "SELECT * FROM product ORDER BY pid";
		List<ProductVO> memberList = new ArrayList<>();
		ProductVO pvo = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pvo = new ProductVO();
				pvo.setPid(rs.getString(1));
				pvo.setPname(rs.getString(2));
				pvo.setPrice(rs.getInt(3));
				pvo.setDescription(rs.getString(4));
				pvo.setMaker(rs.getString(5));
				pvo.setCategory(rs.getString(6));
				pvo.setStock(rs.getInt(7));
				pvo.setCondition(rs.getString(8));
				pvo.setPimage(rs.getString(9));
				memberList.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			memberList =  null;
		} finally {
			DBCon.close(rs, pstmt);
		}
		return memberList;
	}
	
	public ProductVO select(String pid) {
		ProductVO pvo = null;
		String sql = "SELECT * FROM product WHERE pid = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pvo = new ProductVO();
				pvo.setPid(rs.getString(1));
				pvo.setPname(rs.getString(2));
				pvo.setPrice(rs.getInt(3));
				pvo.setDescription(rs.getString(4));
				pvo.setMaker(rs.getString(5));
				pvo.setCategory(rs.getString(6));
				pvo.setStock(rs.getInt(7));
				pvo.setCondition(rs.getString(8));
				pvo.setPimage(rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			pvo = null;
		} finally {
			DBCon.close(rs, pstmt);
		}
		return pvo;
	}
	
	public boolean insert(ProductVO pvo) {
		String sql = "INSERT INTO product ("
				+ "pid"
				+ ", pname"
				+ ", price"
				+ ", description"
				+ ", maker"
				+ ", category"
				+ ", stock"
				+ ", condition"
				+ ", pimage)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, NVL(?,'default.png'))";
		boolean result = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pvo.getPid());
			pstmt.setString(2, pvo.getPname());
			pstmt.setInt(3, pvo.getPrice());
			pstmt.setString(4, pvo.getDescription());
			pstmt.setString(5, pvo.getMaker());
			pstmt.setString(6, pvo.getCategory());
			pstmt.setInt(7, pvo.getStock());
			pstmt.setString(8, pvo.getCondition());
			pstmt.setString(9, pvo.getPimage());
			if(pstmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(pstmt);
		}
		return result;
	}
}
