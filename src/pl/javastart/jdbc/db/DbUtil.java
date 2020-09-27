package pl.javastart.jdbc.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DbUtil {
    private static DbUtil dbUtil;
    private HikariDataSource dataSource;

    private DbUtil() {
        HikariConfig config = new HikariConfig();
		System.out.println("DbUtil: ----------------start init DbUtil..");
		config.setJdbcUrl("jdbc:mysql://localhost:3306/world?useSSL=false&serverTimezone=UTC");
		config.setDriverClassName("com.mysql.cj.jdbc.Driver");
		config.setUsername("root");
		config.setPassword("root");
		dataSource = new HikariDataSource(config);
		System.out.println("DbUtil: ----------------finish init DbUtils");
	}
	
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	public void close() {
		if( dataSource != null) 
			dataSource.close();
	}
	
	public static DbUtil getInstance() {
		if(dbUtil == null)
			dbUtil = new DbUtil();
		return dbUtil;
	}
}
