package checkMarks;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class sem1 extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String classname = request.getParameter("class");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
            PreparedStatement pst = con.prepareStatement("Select * from sem1 where rollno =? and classname = ?");
            pst.setString(1, id);
            pst.setString(2, classname);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String TechnicalCommunicationSkill = rs.getString("TechnicalCommunicationSkill");
                String ProgramminginC = rs.getString("ProgramminginC");
                String ComputerFundamental = rs.getString("ComputerFundamental");
                String NetworkingandInternetEnvironment = rs.getString("NetworkingandInternetEnvironment");
                String OperatingSystem = rs.getString("OperatingSystem");

                out.println("TechnicalCommunicationSkill = "+TechnicalCommunicationSkill + " <br>ProgramminginC = " + ProgramminginC + "<br>ComputerFundamental =  " + ComputerFundamental + "<br>NetworkingandInternetEnvironment = " + NetworkingandInternetEnvironment+" <br>OperatingSystem = "+OperatingSystem);
            }
        } catch (Exception e) {
            out.println(e);
        }
    }

}
