
package mybean;

import javax.ejb.Stateless;
import java.sql.*;


@Stateless
public class VerfBean {

    public VerfBean() {}
    public String loginVerf(String email, String company, String password){
        String message="";
        try{
             Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
           PreparedStatement pst = con.prepareStatement("Select * from " +company+ " where email=? and password=?");
           pst.setString(1,email);
           pst.setString(2,password);
           ResultSet rs = pst.executeQuery();
           if(rs.next()) 
           {
               message = "Login Successful";
               
           }
           else {
               message = "No User Found Please Signup!";
               
           }
        }
        catch(Exception e){return e.toString();}
      return message;  
    }
    
    
    
}
