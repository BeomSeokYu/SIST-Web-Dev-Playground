package market.filter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class LogFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;
	private PrintWriter pw;
	private SimpleDateFormat sdf;
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("- MARKET ACCESS LOGGING start -");
		sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
		String logPath = fConfig.getServletContext().getRealPath("\\resources\\log\\");
		String logFile = "\\" + getDateTime().split(" ")[0] + ".log";
		System.out.println(logPath + logFile);
		try {
			pw = new PrintWriter(new FileWriter(logPath + logFile), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		long start = System.currentTimeMillis();
		
		System.out.println("접속 시간 : " + this.getDateTime());
		System.out.println("클라이언트 IP : " + request.getRemoteAddr());
		System.out.println("요청 URL : " + req.getRequestURI());
		pw.write("접속 시간 : " + this.getDateTime() + "\r\n");
		pw.write("클라이언트 IP : " + request.getRemoteAddr() + "\r\n");
		pw.write("요청 URL : " + req.getRequestURI() + "\r\n");
		
		long end = System.currentTimeMillis();
		System.out.println("처리 완료 : " + this.getDateTime());
		System.out.println("소요 시간 : " + (end - start) + "ms");
		pw.write("처리 완료 : " + this.getDateTime() + "\r\n");
		pw.write("소요 시간 : " + (end - start) + "ms\r\n");
		pw.write("\r\n----------------------------------------\r\n");
		pw.flush();
		chain.doFilter(request, response);
	}
	
	public void destroy() {
		System.out.println("- MARKET ACCESS LOGGING end -");
		pw.close();
	}
	
	public String getDateTime() {
		return sdf.format(new Date());
	}
}
