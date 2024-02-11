
package checkMarks;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class sem4 extends HttpServlet {

    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String classname = request.getParameter("class");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
            PreparedStatement pst = con.prepareStatement("Select * from sem4 where rollno =? and classname = ?");
            pst.setString(1, id);
            pst.setString(2, classname);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String CoreJava = rs.getString("CoreJava");
                String IntroductiontoEmbeddedSystems = rs.getString("IntroductiontoEmbeddedSystems");
                String  COST = rs.getString("COST");
                String SoftwareEngineering = rs.getString("SoftwareEngineering");
                String ComputerGraphicsandAnimation = rs.getString("ComputerGraphicsandAnimation");

                out.println("Core Java = "+CoreJava + "<br> Introduction to Embedded Systems = " + IntroductiontoEmbeddedSystems + "<br>COST = " +  COST + " <br>Software Engineering = " + SoftwareEngineering+"<br>Computer Graphics and Animation = "+ComputerGraphicsandAnimation);
            }
        } catch (Exception e) {
            out.println(e);
        }
    }

    

}
