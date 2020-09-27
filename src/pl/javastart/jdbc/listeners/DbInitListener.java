package pl.javastart.jdbc.listeners;

import javax.servlet.annotation.WebListener;

import pl.javastart.jdbc.db.DbUtil;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@WebListener 
public class DbInitListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		DbUtil.getInstance().close();
		System.out.println("DbInitListener.contextDestroyed: Context close...");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("DbInitListener.contextInitialized: Context init...");
		try {
			DbUtil.getInstance().getConnection();
		} catch(SQLException exception) {
			exception.getStackTrace();
		}
	}

}
