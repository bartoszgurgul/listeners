package pl.javastart.jdbc.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
	
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("SessionListener.sessionCreated: Session created " + se.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("SessionListener.sessionDestroyed: Session Destroyed");
    }

}
