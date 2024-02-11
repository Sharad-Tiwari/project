package signupS;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.EJB;
import mybean.VerfBean;

public class verfS extends HttpServlet {

    @EJB
    mybean.VerfBean obj;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String company_code = request.getParameter("c_code");
        String password = request.getParameter("password");

        if (email.isEmpty() && company_code.isEmpty() && password.isEmpty()) {
            out.print("Enter all the fields");
        } else {
            String msg = obj.loginVerf(email, company_code, password);
            if (msg.equals("Login Successful")) {
                RequestDispatcher rd = request.getRequestDispatcher("main.html");
                rd.forward(request, response);
            }
        }

    }

}
