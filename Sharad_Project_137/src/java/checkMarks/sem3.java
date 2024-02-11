
package checkMarks;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class sem3 extends HttpServlet {

   
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String classname = request.getParameter("class");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
            PreparedStatement pst = con.prepareStatement("Select * from sem3 where rollno =? and classname = ?");
            pst.setString(1, id);
            pst.setString(2, classname);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String PythonProgramming = rs.getString("PythonProgramming");
                String DataStructures = rs.getString("DataStructures");
                String ComputerNetworks = rs.getString("ComputerNetworks");
                String DatabaseManagementSystems = rs.getString("DatabaseManagementSystems");
                String AppliedMathematics = rs.getString("AppliedMathematics");

                out.println("Python Programming = "+PythonProgramming + "<br>Data Structures = " + DataStructures + " <br>ComputerNetworks = " + ComputerNetworks + "<br>Database Management Systems =  " + DatabaseManagementSystems+"<br>Applied Mathematics = "+AppliedMathematics);
            }
        } catch (Exception e) {
            out.println(e);
        }
    }

   
}
