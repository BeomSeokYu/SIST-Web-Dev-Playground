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
		//con = DBCon.getConnection();
	}
	
	public Connection getCon() {
		return con;
	}


	public void setCon(Connection con) {
		this.con = con;
	}
	
	public boolean isId(String id) {
		String sql = "SELECT * FROM member WHERE userid = ?";
	    boolean result = false;
		try {
	    	pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result =  true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
	    return result;
	}

	public boolean isMember(MemberVO mvo) {
		String sql = "SELECT userid FROM member WHERE userid = ? AND userpw = ?";
	    boolean result = false;
		try {
	    	pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getUserid());
			pstmt.setString(2, mvo.getUserpw());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result =  true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
	    return result;
	}
	
	public MemberVO select(String id) {
		String sql = "SELECT * FROM member WHERE userid = ?";
	    boolean result = false;
	    MemberVO mvo = null;
		try {
	    	pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mvo = new MemberVO();
				mvo.setUserid(rs.getString("userid"));
				mvo.setUserpw(rs.getString("userpw"));
				mvo.setUsernm(rs.getString("usernm"));
				mvo.setEmail(rs.getString("email"));
				mvo.setGender(rs.getString("gender"));
				mvo.setPhoto(rs.getString("photo"));
				mvo.setJoinDate(rs.getDate("joindate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
	    return mvo;
	}
	
	public boolean insert(MemberVO mvo) {
		String sql = "INSERT INTO member ("
				+ "userid"
				+ ", userpw"
				+ ", usernm"
				+ ", email"
				+ ", gender"
				+ ", photo"
				+ ", joindate)"
				+ " VALUES (?, ?, ?, ?, ?, NVL(?,'memberDefault.png'), SYSDATE)";
		boolean result = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getUserid());
			pstmt.setString(2, mvo.getUserpw());
			pstmt.setString(3, mvo.getUsernm());
			pstmt.setString(4, mvo.getEmail());
			pstmt.setString(5, mvo.getGender());
			pstmt.setString(6, mvo.getPhoto());
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
	
	public boolean update(MemberVO mvo, String id_old) {
		String sql = "UPDATE member SET "
				+ "userid=?"
				+ ", userpw=?"
				+ ", usernm=?"
				+ ", email=?"
				+ ", gender=?"
				+ ", photo=?"
				+ " WHERE userid=?";
		boolean result = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getUserid());
			pstmt.setString(2, mvo.getUserpw());
			pstmt.setString(3, mvo.getUsernm());
			pstmt.setString(4, mvo.getEmail());
			pstmt.setString(5, mvo.getGender());
			pstmt.setString(6, mvo.getPhoto());
			pstmt.setString(7, id_old);
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
	
	public boolean delete(String id) {
		String sql = "DELETE FROM member WHERE userid=?";
		boolean result = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
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
