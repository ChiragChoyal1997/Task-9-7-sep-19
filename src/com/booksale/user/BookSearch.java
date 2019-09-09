package com.booksale.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookSearch
 */
@WebServlet("/BookSearch")
public class BookSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "xyz";
	String password = "xyz";
	String drivername = "oracle.jdbc.driver.OracleDriver";
    Connection con;
    public BookSearch() {
        super();
    }
    
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			Class.forName(drivername);
			con = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		PrintWriter out = response.getWriter();
		try {
			Statement stmt = con.createStatement();
			String sql = "select title,author,edition,price from book where lower(title) like";
			System.out.println(sql);
			sql = sql + " '"+search+"%'";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.include(request, response);
			while(rs.next()==true) {	
				out.println(rs.getString(1)+" - "+rs.getString(2)+" - "+rs.getString(3)+" - "+rs.getInt(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
