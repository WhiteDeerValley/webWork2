package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "addServlet", urlPatterns = {"/addServlet/*"})
public class addServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url =  request.getRequestURI();
        String[] urlSp = url.split("/");
        if (urlSp.length == 4)
        {
            String regex = "^a=(-?[0-9]+)&b=(-?[0-9]+)$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(urlSp[3]);
            boolean flag = false;
            while (m.find())
            {
                flag = true;
                Integer a = Integer.parseInt(m.group(1));
                Integer b = Integer.parseInt(m.group(2));
                request.setAttribute("a",a);
                request.setAttribute("b",b);

            }
            if (flag == true)
            {
                request.getRequestDispatcher("/doneServlet").forward(request,response);
            }
            else
            {
                PrintWriter writer = response.getWriter();
                writer.println("You Errorrrrrr not done");
            }
        }
        else
        {
            PrintWriter writer = response.getWriter();
            writer.println("You Errorrrrrr not 4");
        }
    }
}
