package jspz.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/Hello.do")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		request.setCharacterEncoding("UTF-8");					// 수신데이터 한글 처리
		response.setContentType("text/html; charset=UTF-8");	// 송신데이터 한글 처리
		
		System.out.println(name);
		System.out.println(age);
		PrintWriter out = response.getWriter();
		
		out.print("<html><head><title>Hello World</title></head>");
		out.print("<body>");
		out.print("<h1>Hello world!~</h1>");
		out.print("<div>이름 : "+name+"</div>");
		out.print("<div>나이 : "+age+"</div>");
		out.print("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
