package market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import market.util.DBCon;
import market.vo.MemberVO;

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public MemberDAO() {
		con = DBCon.getConnection();
	}
	
	public boolean isMember(MemberVO mvo) {
		String sql = "SELECT userid FROM member WHERE userid = ? AND userpw = ?";
	    boolean result = false;
		try {
	    	pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getUserid());
			pstmt.setString(2, mvo.getUserpw());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result =  true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
	    return result;
	}
}
