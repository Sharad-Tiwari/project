
package checkMarks;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class sem6 extends HttpServlet {

    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String classname = request.getParameter("class");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
            PreparedStatement pst = con.prepareStatement("Select * from sem6 where rollno =? and classname = ?");
            pst.setString(1, id);
            pst.setString(2, classname);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                 String SoftwareQualityAssurance = rs.getString("SoftwareQualityAssurance");
                String SecurityinComputing = rs.getString("SecurityinComputing");
                String PrinciplesofGeographicInformationSystems = rs.getString("PrinciplesofGeographicInformationSystems");
                String  EnterpriseNetworking = rs.getString("EnterpriseNetworking");
                String ITServiceManagement = rs.getString("ITServiceManagement");

                out.println("Software Quality Assurance = "+SoftwareQualityAssurance + " <br>Security in Computing = " + SecurityinComputing + "<br>Principles of Geographic Information Systems = " + PrinciplesofGeographicInformationSystems + " <br>Enterprise Networking = " +  EnterpriseNetworking+"<br>IT Service Management = "+ITServiceManagement);
             }
        } catch (Exception e) {
            out.println(e);
        }
    }

    

}
