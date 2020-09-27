package pl.javastart.jdbc.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ReqListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("ReqListener.requestDestroyed: Request destroy");
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("ReqListener.requestInitialized: Request initalized");
		
	}
	
	

}
