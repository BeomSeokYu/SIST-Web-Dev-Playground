package jspz.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SimpleListener implements ServletContextListener, HttpSessionListener, ServletRequestListener {

    public SimpleListener() {
    	System.out.println("SimpleListener");
    }
    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("sessionCreated");
    }

    public void requestDestroyed(ServletRequestEvent sre)  { 
    	System.out.println("requestDestroyed");
    }

    public void requestInitialized(ServletRequestEvent sre)  { 
    	System.out.println("requestInitialized");
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("sessionDestroyed");
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("contextDestroyed");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("contextInitialized");
    }
	
}
