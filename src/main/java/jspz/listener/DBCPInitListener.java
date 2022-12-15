package jspz.listener;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener
public class DBCPInitListener implements ServletContextListener {
	private Connection con;
	
	
	public void contextInitialized(ServletContextEvent sce)  { 
		try {
			// 1. DataBase Connection Pool
			InitialContext initCtx = new InitialContext();
			DataSource ds = (DataSource) initCtx.lookup("java:/comp/env/jdbc/oracle");
			
			// 2. Connection 객체 생성
			con = ds.getConnection();
			
			// 3. 연결 확인
			String msg = null;
			if (con != null) {
				msg = "DBCPInitListener : con OK.";
			} else {
				msg = "DBCPInitListener : con null.";
			}
			System.out.println(msg);
			
			// 4. ServletContext에 담기
			ServletContext sc = sce.getServletContext();
			sc.setAttribute("con", con);
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void contextDestroyed(ServletContextEvent sce)  { 
		// 4. 서버 종료시 con 객체 닫기
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("DBCPInitListener : con closed.");
	}
	
}
