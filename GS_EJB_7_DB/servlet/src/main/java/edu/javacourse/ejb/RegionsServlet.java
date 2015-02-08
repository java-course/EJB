package edu.javacourse.ejb;

import edu.javacourse.ejb.model.Region;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Author: Georgy Gobozov
 * Date: 07.07.13
 */

@WebServlet(name = "dbServlet", urlPatterns = "/regions")
public class RegionsServlet extends HttpServlet {


    @EJB
    private RegionService regionService;

    @EJB
    private RegionServiceManual regionServiceManual;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        if (request.getParameter("submit") != null) {

            String name = request.getParameter("name");
            Region region = new Region();
            region.setRegionName(name);
            regionService.createRegion(region);
        }


        if (request.getParameter("submit2") != null) {

            String name = request.getParameter("name");
            Region region = new Region();
            region.setRegionName(name);
            regionServiceManual.createRegion(region);
        }

        response.sendRedirect("/databaseservlet/regions");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        String id = request.getParameter("id");

        if ("remove".equals(action) && id != null) {

            Region toDelete = regionService.getRegion(Integer.parseInt(id));
            regionService.removeRegion(toDelete);
            response.sendRedirect("/databaseservlet/regions");

        }else {


            List<Region> allRegions = regionService.getAllRegions();
            request.setAttribute("regions", allRegions);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }



    }
}
