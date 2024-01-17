

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.control2;
import model.User;



@WebServlet("/Userlist")
public class Userlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<link href='css/main.css' rel='stylesheet' media='all'>");
		out.print("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>");
		out.print("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js'></script>");
		out.print("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>");
	
   		
   		
   		
		String Fname=request.getParameter("rname");
		String Lname=request.getParameter("rsirname");
		String email=request.getParameter("remail");
		String phone=request.getParameter("rphone");
		String pass=request.getParameter("rpass");
		String role=request.getParameter("role");
       
		
		
		User u=new User(Fname,Lname,email,phone,pass,role);
		control2 db=new control2();
		
            int a= db.insert(u);
		
        
            
         
        int pageId = 1;
		if(pageId==1)
		{ }
		else
		{
			pageId-=1;  
			pageId=pageId*5;
			pageId+=1;  
		}
		
		
		
		ArrayList<User>	ull=db.show1(pageId,5);
		
		out.print("<div class='divped'>");
		out.print("<table class='table table-condensed' >");
		out.print("<h1><center>Available Medicine</center></h1>");
		out.print("<thead><tr><th>Sr.No.</th><th>company</th><th>medicine</th></tr></thead>");
		
		
		out.print(" <tbody>");
		
		for(User x:ull) {
		    out.println("<tr><td>"+x.getUid()+"</td><td>"+x.getFname()+"</td><td>"+x.getLname()+"</td><td>"+x.getemail()+"</td><td>"+x.getphone()+"</td><td>"+x.getpassword()+"</td><td>"+x.getrole()+"</td></tr>");
		}

		
		out.print("</tbody>");	
		out.print("</table>");	
		
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
