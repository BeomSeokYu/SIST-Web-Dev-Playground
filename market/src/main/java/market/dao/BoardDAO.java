package market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import market.util.DBCon;
import market.vo.BoardVO;

public class BoardDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BoardDAO() {
		//con = DBCon.getConnection();
	}
	
	public Connection getCon() {
		return con;
	}


	public void setCon(Connection con) {
		this.con = con;
	}
	
	public List<BoardVO> selectAllContent() {
		String sql = "SELECT * FROM board ORDER BY num DESC";
		List<BoardVO> boardList = new ArrayList<>();
		BoardVO bvo = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bvo = new BoardVO();
				bvo.setNum(rs.getInt(1));
				bvo.setUserid(rs.getString(2));
				bvo.setSubject(rs.getString(3));
				bvo.setContent(rs.getString(4));
				bvo.setRegDate(rs.getDate(5));
				bvo.setHit(rs.getInt(6));
				bvo.setIp(rs.getString(7));
				boardList.add(bvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return boardList;
	}
	
	public BoardVO select(int num) {
		String sql = "SELECT * FROM board WHERE num = ?";
	    boolean result = false;
	    BoardVO bvo = null;
		try {
	    	pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bvo = new BoardVO();
				bvo = new BoardVO();
				bvo.setNum(rs.getInt(1));
				bvo.setUserid(rs.getString(2));
				bvo.setSubject(rs.getString(3));
				bvo.setContent(rs.getString(4));
				bvo.setRegDate(rs.getDate(5));
				bvo.setHit(rs.getInt(6));
				bvo.setIp(rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
	    return bvo;
	}
	
	public List<BoardVO> search(String where, String word) {
		String sql = "SELECT * FROM board WHERE "+ where + " LIKE '%' || ? || '%' ORDER BY num DESC";
		List<BoardVO> boardList = new ArrayList<>();
		BoardVO bvo = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, word);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bvo = new BoardVO();
				bvo.setNum(rs.getInt(1));
				bvo.setUserid(rs.getString(2));
				bvo.setSubject(rs.getString(3));
				bvo.setContent(rs.getString(4));
				bvo.setRegDate(rs.getDate(5));
				bvo.setHit(rs.getInt(6));
				bvo.setIp(rs.getString(7));
				boardList.add(bvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return boardList;
	}
	
	public boolean insert(BoardVO bvo) {
		String sql = "INSERT INTO board ("
				+ "num"
				+ ", userid"
				+ ", subject"
				+ ", content"
				+ ", ip)"
				+ " VALUES (board_seq.NEXTVAL, ?, ?, ?, ?)";
		boolean result = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bvo.getUserid());
			pstmt.setString(2, bvo.getSubject());
			pstmt.setString(3, bvo.getContent());
			pstmt.setString(4, bvo.getIp());
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
	
	public boolean update(BoardVO bvo) {
		String sql = "UPDATE board SET subject=?, content=? WHERE num=?";
		boolean result = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bvo.getSubject());
			pstmt.setString(2, bvo.getContent());
			pstmt.setInt(3, bvo.getNum());
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
	
	public boolean updateHit(int num, int hit) {
		String sql = "UPDATE board SET hit=? WHERE num=?";
		boolean result = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, hit);
			pstmt.setInt(2, num);
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
	
	public boolean delete(String num) {
		String sql = "DELETE FROM board WHERE num=?";
		boolean result = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
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
	
	public int totalCount() {
		String sql = "SELECT COUNT(*) FROM board";
		int cnt = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return cnt;
	}
}
