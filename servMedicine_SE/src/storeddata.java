

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.control2;
import model.User2;


@WebServlet(name = "medicinedata", urlPatterns = { "/medicinedata" })
public class storeddata extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<link href='css/main.css' rel='stylesheet' media='all'>");
		out.print("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>");
		out.print("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js'></script>");
		out.print("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>");
	
   		
   		
   		
		String company=request.getParameter("company");
		String medicine=request.getParameter(""
				+ "medicine");
		
		
		User2 u=new User2(company,medicine);
		control2 db2=new control2();
		
            int a= db2.insert_med(u);
		
        
         
        int pageId = 1;
		if(pageId==1)
		{ }
		else
		{
			pageId-=1;  
			pageId=pageId*5;
			pageId+=1;  
		}
		
		
		
		ArrayList<User2>	ul=db2.show(pageId,5);
		
		out.print("<div class='divped'>");
		out.print("<table class='table table-condensed' >");
		out.print("<h1><center>Available Medicine</center></h1>");
		out.print("<thead><tr><th>Sr.No.</th><th>company</th><th>medicine</th><th>Update</th></th><th>Delete</th></tr></thead>");

		out.print("<tbody>");

		for (User2 x : ul) {
		    out.println("<tr>");
		    out.println("<td>" + x.getaid2() + "</td>");
		    out.println("<td>" + x.getcompany2() + "</td>");
		    out.println("<td>" + x.getmedicine2() + "</td>");
		    
		
		    out.println("<td><a href='Updateserv?id=" + x.getaid2() + "'>Update</a></td>");
		    out.println("<td><a href='Deleteserv?id=" + x.getaid2() + "'>Delete</a></td>");
		    
		    out.println("</tr>");
		}

		out.print("</tbody>");out.print("</table>");	
		
		out.print("<a href='regServ?page=1'>1</a> ");  
	    out.print("<a href='regServ?page=2'>2</a> ");  
	    out.print("<a href='regServ?page=3'>3</a> "); 
	    out.print("<a href='regServ?page=4'>4</a> "); 
		
		out.print("</div>");
		
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
