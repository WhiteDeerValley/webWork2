package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "logoutServlet",urlPatterns = {"/logoutServlet"})
public class logoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if(session.getAttribute("login") == null)
        {
            PrintWriter writer = response.getWriter();
            writer.println("ERRORRRRRRRRRRRRRR");
        }
        else
        {
            session.removeAttribute("login");
            PrintWriter writer = response.getWriter();
            writer.println("Logout");
        }

    }
}
