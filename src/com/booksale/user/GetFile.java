package com.booksale.user;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetFile")
public class GetFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GetFile() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filename = request.getParameter("file");
		File file = new File("G:\\BookSale\\");
		for(String s: file.list()) {
			
			if(s.equals(filename)) {
				FileInputStream fis = new FileInputStream(file+"\\"+s);
				ServletOutputStream sos=response.getOutputStream();
				int i;
				while ((i = fis.read()) != -1) {
					sos.write(i);
					sos.flush();
				}
				byte b[]=new byte[fis.available()];
				fis.read(b);
				fis.close();
				sos.close();
			}
		}
	}
}
