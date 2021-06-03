package app.servlets;

import app.dao.ApplicationDao;
import app.entities.Application;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ManagerWin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationDao appDao = new ApplicationDao();
        List<Application> appList = appDao.getAllApplications();
        req.setAttribute("applications", appList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("manager_win.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
