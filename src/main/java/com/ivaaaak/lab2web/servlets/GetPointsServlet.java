package com.ivaaaak.lab2web.servlets;

import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/get_points")
public class GetPointsServlet extends HttpServlet {

    Gson parser = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Object allPoints = req.getSession().getAttribute("points");
        if (allPoints != null) {
            resp.getWriter().println(parser.toJson(allPoints));
        } else {
            resp.getWriter().println("{}");
        }
    }
}
