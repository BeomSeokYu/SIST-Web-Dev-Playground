package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.zerock.sample.SampleTests;

import lombok.extern.log4j.Log4j;


@Log4j
public class JDBCTests {
	//oracle.jdbc.OracleDriver
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		try ( Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "madang", "1111") ) {
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
