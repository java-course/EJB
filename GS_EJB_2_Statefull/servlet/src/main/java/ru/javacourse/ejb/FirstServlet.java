package ru.javacourse.ejb;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Author: Georgy Gobozov
 * Date: 07.07.13
 */
//http://localhost:8080/servlet-stateful/first
@WebServlet(name = "firstServlet", urlPatterns = "/first")
public class FirstServlet extends HttpServlet {

    private Logger log = Logger.getLogger(getClass().getName());

    @EJB
    StateFulCart cart; // dont!

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.setLevel(Level.FINE);
        log.fine("Servlet started!");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        ShopCart stateLessCart = getStateLessCart(request);
        ShopCart stateFulCart = getStateFulCart(request);
//        ShopCart noEjbCart = getNoEjbCart(request);

        stateLessCart.addItem(System.currentTimeMillis() + "");
        stateFulCart.addItem(System.currentTimeMillis() + "");
       // noEjbCart.addItem(System.currentTimeMillis() + "");


        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>FirstServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>StateLess Content</h1>");


            out.println("<ul>");
            for (String item : stateLessCart.getItems()) {
                out.println("<li>" + item + "</li>");
            }
            out.println("</ul>");


            out.println("<h1>StateFul Content</h1>");
            out.println("<ul>");
            for (String item : stateFulCart.getItems()) {
                out.println("<li>" + item + "</li>");
            }
            out.println("</ul>");

//            out.println("<h1>No Ejb cart Content</h1>");
//            out.println("<ul>");
//            for (String item : noEjbCart.getItems()) {
//                out.println("<li>" + item + "</li>");
//            }
//            out.println("</ul>");


            out.println("</body>");
            out.println("</html>");

        } finally {
            out.flush();
            out.close();
        }


        log.fine("Servlet finished!");

    }

    private ShopCart getStateLessCart(HttpServletRequest request) {
        try {
//            ShopCart cart;
            HttpSession session = request.getSession(true);
            ShopCart cart = (ShopCart) session.getAttribute("stateLessCart");
            if (cart == null) {
                System.out.println("Lookup stateless cart...");
                Context ic = new InitialContext();
                cart = (ShopCart) ic.lookup("java:global/ejb-ear-stateful/ejb-stateful/StateLessCart");
                session.setAttribute("stateLessCart", cart);
            }
            return cart;

        } catch (NamingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ShopCart getStateFulCart(HttpServletRequest request) {
        try {

            HttpSession session = request.getSession(true);
            ShopCart cart = (ShopCart) session.getAttribute("stateFulCart");
            if (cart == null) {
                System.out.println("Lookup stateFulCart cart...");
                Context ic = new InitialContext();
                cart = (ShopCart) ic.lookup("java:global/ejb-ear-stateful/ejb-stateful/StateFulCart");
                session.setAttribute("stateFulCart", cart);
          }
            return cart;

        } catch (NamingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ShopCart getNoEjbCart(HttpServletRequest request) {

        HttpSession session = request.getSession(true);
        ShopCart cart = (ShopCart) session.getAttribute("noEjbCart");
        if (cart == null) {
            System.out.println("Lookup noEjbCart cart...");
            cart = new NoEjbCart();
            session.setAttribute("noEjbCart", cart);
        }
        return cart;

    }

}
