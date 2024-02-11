<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sem 2 marks entry</title>
    </head>
    <body>
        <%
            String rollno = request.getParameter("id");
            String classname = request.getParameter("class");
            String sub1 = request.getParameter("subject1");
            String sub2 = request.getParameter("subject2");
            String sub3 = request.getParameter("subject3");
            String sub4 = request.getParameter("subject4");
           

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
                PreparedStatement pst = con.prepareStatement("Insert into sem2 values(?,?,?,?,?,?)");
                pst.setString(1,rollno);
                pst.setString(2,classname);
                pst.setString(3,sub1);
                pst.setString(4,sub2);
                pst.setString(5,sub3);
                pst.setString(6,sub4);
                
                
                
                int r = pst.executeUpdate();
                
                if(r>0){out.println("sucess");}
            }
            catch(Exception e) {
                out.println(e);
            }
        %>
    </body>
</html>
