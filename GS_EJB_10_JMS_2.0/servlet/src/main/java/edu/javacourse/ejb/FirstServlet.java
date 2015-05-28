package edu.javacourse.ejb;

import edu.javacourse.jms.SendMessageBean;

import javax.ejb.EJB;
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


//wildfly http://localhost:8080/jsm-servlet/test
@WebServlet(name = "jmsServlet", urlPatterns = "/test")
public class FirstServlet extends HttpServlet {

    private Logger log = Logger.getLogger(getClass().getName());

    // Пример механизма injection
    @EJB
    private SendMessageBean bean;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.setLevel(Level.FINE);
        log.fine("Servlet started!");

        String jmsType = request.getParameter("jms");

        if (jmsType != null && jmsType.equals("topic"))
            bean.sendMessageToTopic();

        if (jmsType != null && jmsType.equals("queue"))
            bean.sendMessageToQueue();



        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>FirstServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<a href='/jsm-servlet/test?jms=topic'>start topic</a><br/>");
            out.println("<a href='/jsm-servlet/test?jms=queue'>start queue</a>");
            out.println("</body>");
            out.println("</html>");

        } finally {
            out.flush();
            out.close();
        }


        log.fine("Servlet finished!");

    }
}
