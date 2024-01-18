

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.control2;



@WebServlet("/loginserv")
public class loginserv extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String rname=request.getParameter("uname");
		String rpass=request.getParameter("upass");
	    
	    
		
		control2 db=new control2();
		
		
		String aa;
	       
		
		 boolean a;
		
		try {
			a = db.checkUser(rname,rpass);
		
			if(a)
			{
				out.print("User  found<br>");
				
				  aa = db.getUserRole(rname);
				 
				 
				 out.print(aa);
				 if (aa != null) {
					    if (!"Admin".equals(aa)) {
					    	 out.print("Userget found<br>");
					            out.print("Visit Profile");
					            request.getRequestDispatcher("userprofile.html").forward(request, response);
					    } else if ("Admin".equals(aa)) {
					    	out.print("Hello Admin!");
				            request.getRequestDispatcher("profile.html").forward(request, response);
					    }
					}
			
			}
			else
			{
				out.print("User Not found<br>");
				
				out.print(db);
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
				
	      
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
