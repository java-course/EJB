package edu.javacourse.ejb;

import javax.ejb.EJB;
import javax.naming.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Author: Georgy Gobozov
 * Date: 07.07.13
 */
//http://localhost:8080/servlet-jndi/first
@WebServlet(name = "firstServlet", urlPatterns = "/first")
public class FirstServlet extends HttpServlet {

    private Logger log = Logger.getLogger(getClass().getName());


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.setLevel(Level.FINE);
        log.fine("Servlet started!");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {

            Context ic = new InitialContext();

            // className
            // lookup ejb:app-name/ejb-module/class
            SayHelloBean sayHelloBean = (SayHelloBean) ic.lookup("java:global/ear-jndi/ejb-jndi/SayHelloBean");


            // name parameter
            edu.javacourse.ejb.SayBye sayByeBean = (edu.javacourse.ejb.SayBye) ic.lookup("java:global/ear-jndi/ejb-jndi/ByeBye");

            sayByeBean.printBye();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>FirstServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Hello :" + sayHelloBean.sayHello() + "</h1>");
            out.println("<h1>Bye :" + sayByeBean.sayBye() + "</h1>");
            out.println("</body>");
            out.println("</html>");

        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
        }


        log.fine("Servlet finished!");

    }
}
