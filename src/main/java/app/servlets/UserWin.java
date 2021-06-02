package app.servlets;

import app.dao.ApplicationDao;
import app.dao.UserDao;
import app.entities.Application;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserWin extends HttpServlet {

    private ApplicationDao appDao;

    public void init() {
        appDao = new ApplicationDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("auth_user_window.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        Pattern streetCheck =
                Pattern.compile("^(\\p{IsL}{2,}\\s\\p{IsL}+'?-?\\p{IsL}{2,}\\s?(\\p{IsL}+)?)");
        String city = req.getParameter("city");
        String street = req.getParameter("street");
        Matcher streetMatcher = streetCheck.matcher(street);
        if(!streetMatcher.find()) {
            session = req.getSession();
            session.setAttribute("streetMessage", "Please, enter a real street name");
            resp.sendRedirect("auth_user_window.jsp");
        }
        String num = req.getParameter("streetNum");
        String baggageType = req.getParameter("baggageType");
        String weight = req.getParameter("weight");
        String volume = req.getParameter("volume");
        String date = req.getParameter("date");
        Application app = new Application(city + ", " + street + ", " + num, baggageType,
                Double.parseDouble(weight),
                Double.parseDouble(volume), date, (Integer) session.getAttribute("id"));
        try {
            appDao.addApplication(app);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
