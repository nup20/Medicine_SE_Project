

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Bookmedicine")
public class Bookmedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession s = request.getSession(true);

		String company = request.getParameter("company");
        String medicine = request.getParameter("medicine");
        String quantity = request.getParameter("quantity");
        

        s.setAttribute("company", company);
        s.setAttribute("medicine", medicine);
       
       

        request.getRequestDispatcher("booking.html").include(request, response);
        
        out.print("<form action='bookinglist' method='get'>");
        out.print("<div class='center'>");
        out.print(" <div class='login-form'>");
        out.print("<h4 style='color: black;'><b>::Booking::</b><br>");
        out.print("Company::<input type='text' value='" + s.getAttribute("company") + "' name='company'><br>");
        out.print("Medicine::<input type='text' value='" + s.getAttribute("medicine") + "' name='medicine'><br>");
        out.print("Name::<input type='text'  ' name='name'><br>");
        out.print("Phone::<input type='text' ' name='phone'><br>");
        out.print("Quantity::<input type='text' ' name='quantity'><br>");
        out.print("<input type='submit'><br><br></h4>");
        out.print("</div></div>");
        out.print("</form>");
        
      
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
