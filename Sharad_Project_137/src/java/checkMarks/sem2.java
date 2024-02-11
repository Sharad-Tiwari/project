package checkMarks;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class sem2 extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String classname = request.getParameter("class");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
            PreparedStatement pst = con.prepareStatement("Select * from sem2 where rollno =? and classname = ?");
            pst.setString(1, id);
            pst.setString(2, classname);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String DataStructure = rs.getString("DataStructure");
                String WebProgramming = rs.getString("WebProgramming");
                String ComputerOrganizationandArchitecture = rs.getString("ComputerOrganizationandArchitecture");
                String MathematicasandStatisticas = rs.getString("MathematicasandStatisticas");
                

                out.println("DataStructure = "+DataStructure + "<br>WebProgramming = " + WebProgramming + " <br>ComputerOrganizationandArchitecture = " + ComputerOrganizationandArchitecture + "<br>MathematicasandStatisticas =  " + MathematicasandStatisticas);
            }
        } catch (Exception e) {
            out.println(e);
        }
    }

}
