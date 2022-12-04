package com.ivaaaak.lab2web.servlets;

import com.ivaaaak.lab2web.model.AreaChecker;
import com.ivaaaak.lab2web.model.Point;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;


@WebServlet("/area_check")
public class AreaCheckServlet extends HttpServlet {

    @Inject
    private AreaChecker areaChecker;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final float[] args = (float[]) request.getAttribute("args");

        final float x = args[0];
        final float y = args[1];
        final float r = args[2];
        final boolean hit = areaChecker.isHit(x, y, r);

        final var newPoint = new Point(x, y, r, hit);

        final var session = request.getSession();
        final Object allPoints = session.getAttribute("points");

        if (allPoints == null) {
            LinkedList<Point> points = new LinkedList<>();
            points.add(newPoint);
            session.setAttribute("points", points);
        } else {
            ((LinkedList<Point>) allPoints).add(newPoint);
        }
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
