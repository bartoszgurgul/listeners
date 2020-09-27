package pl.javastart.jdbc.listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class AttributeListener implements 
	HttpSessionAttributeListener, ServletContextAttributeListener, ServletRequestAttributeListener {

	public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("AttributeListener.attributeAdded");
    }

    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("AttributeListener.attributeRemoved");
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("AttributeListener.attributeRemoved: Request Attribute removed " + srae.getName());
    }

    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("AttributeListener.attributeAdded: Request Attribute added " + srae.getName());
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("AttributeListener.attributeReplaced: Request Attribute replaced " + srae.getName());
    }

    public void attributeAdded(HttpSessionBindingEvent se) {
        // TODO Auto-generated method stub
    }

    public void attributeRemoved(HttpSessionBindingEvent se) {
        // TODO Auto-generated method stub
    }

    public void attributeReplaced(HttpSessionBindingEvent se) {
        // TODO Auto-generated method stub
    }

    public void attributeReplaced(ServletContextAttributeEvent scae) {
        // TODO Auto-generated method stub
    }

}
