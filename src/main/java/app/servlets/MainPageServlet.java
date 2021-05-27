package app.servlets;

import app.entities.Direction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Direction> directions = new ArrayList<>();
        directions.add(new Direction("Lviv", "Truck", 14, 2000, 200));
        directions.add(new Direction("Kyiv", "Taxi", 1, 300, 1400));
        req.setAttribute("directions", directions);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("main_page.jsp");
        requestDispatcher.forward(req, resp);
    }
}
