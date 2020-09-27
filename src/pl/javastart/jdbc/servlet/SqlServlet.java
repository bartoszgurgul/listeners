package pl.javastart.jdbc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.javastart.jdbc.data.City;
import pl.javastart.jdbc.db.DbUtil;

@WebServlet("/SqlServlet")
public class SqlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String param = request.getParameter("get");
		if ("show".equals(param)) {
			try {
				System.out.println("----------------start try");
				List<City> cityList = getCities();
				request.setAttribute("cityList", cityList);
				request.getRequestDispatcher("citylist.jsp").forward(request, response);
				
			} catch (SQLException sqlErr) {
				sqlErr.getSQLState();
				response.sendError(500);
			}
		} else {
			response.sendError(403);
		}
	}

	private List<City> getCities() throws SQLException {
		List<City> cityList = null;
		final String query = "Select name, population from city";
		System.out.println("----------------start connection");
		try(Connection connection = DbUtil.getInstance().getConnection()){
			Statement statement = connection.createStatement();
			System.out.println("Start quering...");
			ResultSet resultSet = statement.executeQuery(query);
			
			String name = null;
			int population;
			cityList = new ArrayList<City>();
			System.out.println("Start preprocessing result..");

			while (resultSet.next()) {
				System.out.println("looping result name: "+resultSet.getString("name") + " population: "+resultSet.getInt("population"));
				name = resultSet.getString("name");
				population = resultSet.getInt("population");
				cityList.add(new City(name, population));
			}
		}
		return cityList;
	}
	
	@Override
	public void destroy() {
		DbUtil.getInstance().close();
	}

}
