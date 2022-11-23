package javaz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


// Class.forName(driver) -> DriverManager.getConnection(url, username, password) ->
// Connection 객체 -> createStatement() -> Statement 객체 -> executeQuery(쿼리문) -> ResultSet 객체
// rs.next() 가 있으면 rs.getInt(속성번호) 로 가져옴
public class DBTest {
    
    public static void main(String[] args) {
        String driver = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "madang";
        String password = "1111";
        
        try {
            // 드라이버 로딩
            Class.forName(driver);
            System.out.println("driver ok");
            
            //DB 연결
            System.out.println("DB 연결 준비...");
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("DB 연결 성공");
            
            // DB에 쿼리 결과 가져오기
//            String query = "SELECT * FROM book ORDER BY bookid";    // 세미콜론(;) 생략함
//            Statement stmt = con.createStatement();                 // Query를 실행하기 위해 Statement객체가 필요함
//            ResultSet rs = stmt.executeQuery(query);                // Statement 객체를 이용하여 쿼리문을 실행하고 가져온 데이터를 ResultSet 객체를 통해 저장
//            System.out.printf("%-5s\t%-20s\t%-20s\t%-6s\n","책ID", "책이름", "출판사", "가격");
//            System.out.printf("======================================================================\n");
//            while(rs.next()) { // 다음 읽어올 튜플이 있으면 참
//                System.out.printf("%-5d\t", rs.getInt("bookid"));
//                System.out.printf("%-20s\t", rs.getString(2));
//                System.out.printf("%-20s\t", rs.getString("publisher"));
//                System.out.printf("%6d\n", rs.getInt(4));
//            }
            //--------------------------------- DELETE ------------------------------------
              
              String bookname = "easy java";
              String query = "DELETE FROM BOOK WHERE bookname = ?";
              PreparedStatement pstmt = con.prepareStatement(query);
              pstmt.setString(1, bookname);
              int result = pstmt.executeUpdate();
              if(result == 1) {
                  System.out.println("데이터가 삭제되었습니다.");
              } else {
                  System.out.println("데이터가 삭제되지 않았습니다.");
              }
            
            //--------------------------------- UPDATE ------------------------------------
//              int price = 20000;
//              String query = "UPDATE book SET price = ? WHERE price=10000;
//              PreparedStatement pstmt = con.prepareStatement(query);
//              pstmt.setInt(1, price);
//              int result = pstmt.executeUpdate();
//              if(result == 1) {
//                  System.out.println("데이터가 수정되었습니다.");
//              } else {
//                  System.out.println("데이터가 수정되지 않았습니다.");
//              }
            
            //--------------------------------- INSERT ------------------------------------
//            String bookname = "easy java";
//            String publisher = "SIST";
//            int price = 10000;
//            //query = "INSERT INTO book VALUE (12, '" + bookname + "', '" + publisher + "', '" + price + "')"; // 이 방법은 너무 힘들어 PreparedStatement를 사용함
//            String query1 = "INSERT INTO book VALUES (12, ?, ?, ?)"; // PreparedStatement 생성 전에 변수 자리는 ?러 설정한다
//            PreparedStatement pstmt = con.prepareStatement(query1);
//            pstmt.setString(1, bookname);
//            pstmt.setString(2, publisher);
//            pstmt.setInt(3, price);
//            // INSERT, UPDATE or DELETE 는 executeUpdate 사용
//            int result = pstmt.executeUpdate();  // PreparedStatement를 사용했으므로 입력은 없음
//            if(result == 1) {
//                System.out.println("데이터가 추가되었습니다.");
//            } else {
//                System.out.println("데이터가 추가되지 않았습니다.");
//            }
            //--------------------------------- SELECT -------------------------------------
//            String query = "SELECT * FROM book WHERE bookid = 1";
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            System.out.printf("%-5s\t%-20s\t%-20s\t%-6s\n","책ID", "책이름", "출판사", "가격");
//            if(rs.next()) {
//                System.out.printf("%-5d\t", rs.getInt("bookid"));
//                System.out.printf("%-20s\t", rs.getString(2));
//                System.out.printf("%-20s\t", rs.getString("publisher"));
//                System.out.printf("%6d\n", rs.getInt(4));
//            } else {
//                System.out.println("가져올 데이터가 없습니다.");
//            }
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
