package edu.springz.security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
						"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class MemberTests {
	@Setter(onMethod_ = @Autowired)
	private PasswordEncoder passwordEncoder;
	
	@Setter(onMethod_ = @Autowired)
	private DataSource dataSource;
	
	@Test
	public void testInsertAuthAdmin() {
		
		String sql = "insert into tbl_member_auth(id, auth) values(?,?)";
		
		for(int i=90; i<100; i++) {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "admin" + i);
				pstmt.setString(2, "ROLE_MEMBER");
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(pstmt!=null) {try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}}
				if(con!=null) {try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}}
			}
			
		}
	}
	
//	@Test
	public void testInsertAuth() {
		
		String sql = "insert into tbl_member_auth(id, auth) values(?,?)";
		
		for(int i=0; i<100; i++) {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				
				if(i < 80) {
					
					pstmt.setString(1, "user" + i);
					pstmt.setString(2, "ROLE_USER");
				
				} else if(i < 90) {
					
					pstmt.setString(1, "member" + i);
					pstmt.setString(2, "ROLE_MEMBER");
				
				} else {

					pstmt.setString(1, "admin" + i);
					pstmt.setString(2, "ROLE_ADMIN");
				
				}
				
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(pstmt!=null) {try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}}
				if(con!=null) {try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}}
			}
			
		}
	}
	
//	@Test
	public void testInsertMember() {

		String sql = "INSERT INTO tbl_member(id, pw, name) values(?,?,?)";

		for(int i=0; i<100; i++) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);

				pstmt.setString(2, passwordEncoder.encode("pw" + i));

				if(i < 80) {

					pstmt.setString(1, "user" + i);
					pstmt.setString(3, "일반사용자" + i);

				} else if(i < 90) {

					pstmt.setString(1, "member" + i);
					pstmt.setString(3, "회원" + i);

				} else {

					pstmt.setString(1, "admin" + i);
					pstmt.setString(3, "관리자" + i);

				}

				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(pstmt!=null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

		}
	}
}
