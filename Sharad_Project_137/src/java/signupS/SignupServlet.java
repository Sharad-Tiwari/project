
package signupS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SignupServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
       String fname = request.getParameter("fname");
       String lname = request.getParameter("lname");
       String email = request.getParameter("email");
       String company_code = request.getParameter("c_code");
       String password = request.getParameter("password");
       
       try {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
           if(fname.isEmpty() && lname.isEmpty() && password.isEmpty() && email.isEmpty() && company_code.isEmpty()){
               out.println("Please enter all the values!!");
           } 
           else {
               PreparedStatement pst = con.prepareStatement("Insert into "+ company_code+" values(?,?,?,?)");
               
               pst.setString(1,fname);
               pst.setString(2,lname);
               pst.setString(3,email);
               pst.setString(4,password);
               int r = pst.executeUpdate();
               if(r>0){
                   out.print("Data inserted Successfully");
                   RequestDispatcher rd = request.getRequestDispatcher("login.html");
                   rd.forward(request, response);
               }
           }
       }
       catch(Exception e) {
           out.println(e);
       }
    }

   

}
