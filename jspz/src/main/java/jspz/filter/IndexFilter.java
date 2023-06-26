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

@WebFilter("/index.jsp")
public class IndexFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	public void destroy() {
		//System.out.println("destroy()");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		//System.out.println("doFilter() - BEFORE");
		// pass the request along the filter chain
		chain.doFilter(request, response);
		//System.out.println("doFilter() - AFTER");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		//System.out.println("init()");
	}

}
