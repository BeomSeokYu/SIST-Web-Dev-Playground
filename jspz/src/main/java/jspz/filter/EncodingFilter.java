package jspz.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

public class EncodingFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;
	private String charSet;

	public void destroy() {
		//System.out.println("EncodingFilter destroy()");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(charSet);
		response.setCharacterEncoding("text/html; charset=" + charSet);
		//System.out.println("EncodingFilter doFilter()");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		//System.out.println("EncodingFilter init()");
		charSet = fConfig.getInitParameter("charSet");
	}

}
