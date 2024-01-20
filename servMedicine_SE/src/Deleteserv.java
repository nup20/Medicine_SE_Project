

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.control2;
import model.User2;





@WebServlet("/Deleteserv")
public class Deleteserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
	
		String aid2P = request.getParameter("id");
		
		out.print(aid2P);
		if (aid2P != null && !aid2P.isEmpty()) {
		    int aid2 = Integer.parseInt(aid2P);

		    control2 db2 = new control2();
		    int a;
		    try {
		        a = db2.deletUser(aid2);
		        if (a > 0) {
		            request.getRequestDispatcher("medicinedata").forward(request, response);
		        }
		    } catch (ClassNotFoundException | SQLException e) {
		        e.printStackTrace();  
		    }
		} else {
		    out.print("aid2 is empty");
		}

		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
