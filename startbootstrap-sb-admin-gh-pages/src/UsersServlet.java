
import java.sql.*; 
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UsersServlet
 */
@WebServlet("/UsersServlet")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
 
		if (request.getParameter("button1") != null) {
            showUser(request, response);
        }
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	public void showUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{  
			PrintWriter out = response.getWriter(); 
			
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/ecommerce","root" , "root");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from USERS");  
			while(rs.next())  
				
				
				//printing out users into table 
			out.println("<td>" + rs.getString(1) + "</td>" + "<td>" + rs.getString(2) + "</td>" + "<td>" + rs.getString(3) + "</td>"
					+ "<td>" + rs.getString(4) + "</td>" + "<td>" + rs.getString(5) + "</td>" + "<td>" + rs.getString(6) + "</td>" + "<td>" 
					+ rs.getString(7) + "</td>" + "<td>" + rs.getString(8) + "</td>" + "<td>" + rs.getString(9) + "</td>"
					+ "<td>" + rs.getString(10) + "</td>" + "<td>" + rs.getString(11) + "</td>" + "<td>" + rs.getString(12)
					+ "</td>" + "<td>" + rs.getString(13) + "</td>");  
			
			
			
			
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
	}
}
