

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.mycontroll;



@WebServlet("/loginserv")
public class loginserv extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String rname=request.getParameter("uname");
		String rpass=request.getParameter("upass");
		
		mycontroll db=new mycontroll();
		
	        boolean a;
			
				a = db.checkUser(rname,rpass);
				if(a)
				{
					out.print("Visit Profile");
					out.print("hello");
					
				}
				else
				{
					out.print("User Not found<br>");
					out.print(a);
					out.print(db);
				}
			
	
			
	        
	        
	        
	        
	        
		}
		
          
        		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
