package com.booksale.admin;

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
 * Servlet implementation class BookEntry
 */
@WebServlet("/BookEntry")
public class BookEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "xyz";
	String password = "xyz";
	String drivername = "oracle.jdbc.driver.OracleDriver";
	Connection con;
	String sql = "insert into book(title,author,edition,price) values(?,?,?,?)";
	PrintWriter out;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookEntry() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			Class.forName(drivername);
			con = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String edition = request.getParameter("edition");
		int price = Integer.parseInt(request.getParameter("price"));
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, title);
			stmt.setString(2, author);
			stmt.setString(3, edition);
			stmt.setInt(4, price);
			
			int i = stmt.executeUpdate();
			out = response.getWriter();
			if(i == 1) {
				out.println("Book data has been recorded");
				RequestDispatcher rd = request.getRequestDispatcher("BookEntry.jsp");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			out.println("Unable to insert record of book");
			RequestDispatcher rd = request.getRequestDispatcher("/BookEntry.jsp");
			rd.include(request, response);
		}
		
	}

}
