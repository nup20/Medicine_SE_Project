

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.control2;
import model.booking;


@WebServlet("/bookinglist")
public class bookinglist extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<link href='css/main.css' rel='stylesheet' media='all'>");
		out.print("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>");
		out.print("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js'></script>");
		out.print("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>");
	
   		
   		
		String company=request.getParameter("company");
		String medicine=request.getParameter("medicine");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String quantity=request.getParameter("quantity");
		
		booking u=new booking(company,medicine,name,phone,quantity);
		control2 db2=new control2();
		
        int a= db2.booking(u);
		
        if(a>0)
        {
		request.getRequestDispatcher("userprofile.html").include(request, response);
		out.print("<p><center>Successfully Medicine booked</center></p>");
		
        }
        
	    else
	    {
	    	request.getRequestDispatcher("userprofile.html").include(request, response);
	    	out.print(" <center>Not Booked</center>");
//		response.sendRedirect("profile.html");
		
	    }
         
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
