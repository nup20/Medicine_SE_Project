

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.control2;

import model.User;
import model.User2;


@WebServlet("/adminserv")
public class adminserv extends HttpServlet {
	 
   	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<link href='css/main.css' rel='stylesheet' media='all'>");
		out.print("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>");
		out.print("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js'></script>");
		out.print("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>");
	
   		out.print("hello admin");
   		
   		
		String company=request.getParameter("company");
		String medicine=request.getParameter("medicine");
		
		
		User2 u=new User2(company,medicine);
		control2 db2=new control2();
		
            int a= db2.insert_med(u);
		
        if(a>0)
        {	

		out.print("<p>Successfully Medicine Added</p>");
		request.getRequestDispatcher("profile.html").include(request, response);
		
		out.print(" sucessfully Added!");
        }
        
	    else
	    {
		out.print("Not Added");
//		response.sendRedirect("profile.html");
		request.getRequestDispatcher("profile.html").include(request, response);
		out.print(" <center>Add more medicine </center>");
		
	    }
         
        
		
		
		
		
	}
	
		
   	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
