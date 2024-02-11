
package checkMarks;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class sem5 extends HttpServlet {

    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String classname = request.getParameter("class");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
            PreparedStatement pst = con.prepareStatement("Select * from sem5 where rollno =? and classname = ?");
            pst.setString(1, id);
            pst.setString(2, classname);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String SoftwareProjectManagement = rs.getString("SoftwareProjectManagement");
                String InternetofThings = rs.getString("InternetofThings");
                String AdvancedWebProgramming = rs.getString("AdvancedWebProgramming");
                String ArtificialIntelligence = rs.getString("ArtificialIntelligence");
                String EnterpriseJava = rs.getString("EnterpriseJava");

                out.println("Software Project Management = "+SoftwareProjectManagement + "<br>Internet of Things " + InternetofThings + "<br>Advanced Web Programming = " + AdvancedWebProgramming + "<br>Artificial Intelligence = " + ArtificialIntelligence+"<br>Enterprise Java = "+EnterpriseJava);
            }
        } catch (Exception e) {
            out.println(e);
        }
    }

   

}
