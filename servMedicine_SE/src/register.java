

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import controller.mycontroll;
import model.User;


@WebServlet("/register")
public class register extends HttpServlet {
	
    public register() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		String Fname=request.getParameter("rname");
		String Lname=request.getParameter("rsirname");
		String email=request.getParameter("remail");
		String phone=request.getParameter("rphone");
		String pass=request.getParameter("rpass");
		String role=request.getParameter("role");
        out.print(Fname );
		User u=new User(Fname,Lname,email,phone,pass,role);
		
		mycontroll db=new mycontroll();
		
		
		int a= db.insert(u);
		
        if(a>0)
        {	
        RequestDispatcher rd=request.getRequestDispatcher("login.html");
		rd.forward(request, response);
		out.print("<p>Successfully Registered!</p>");
        }
        
	    else
	    {
		out.print("Not Registered!");
	    }
        
       
		
        
        
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
