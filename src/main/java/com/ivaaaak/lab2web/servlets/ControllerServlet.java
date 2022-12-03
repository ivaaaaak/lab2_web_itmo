package com.ivaaaak.lab2web.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {

    private final String indexJsp = "/views/index.jsp";
    private final String areaCheckServlet = "/area_check";
    private final String clearResultsServlet = "/clear_results";
    private final String getPointsServlet = "/get_points";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("pointsFlag") != null) {
            getServletContext().getRequestDispatcher(getPointsServlet).forward(request, response);
        } else {
            getServletContext().getRequestDispatcher(indexJsp).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");

        if (request.getAttribute("args") != null) {
            getServletContext().getRequestDispatcher(areaCheckServlet).forward(request, response);
        } else {
            getServletContext().getRequestDispatcher(indexJsp).forward(request, response);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter("clearFlag") != null) {
            getServletContext().getRequestDispatcher(clearResultsServlet).forward(request, response);
        }
    }
}
