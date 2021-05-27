package app.servlets;

import app.entities.User;
import app.dao.UserDao;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class AddServlet extends HttpServlet {

    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("userName");
        String password = req.getParameter("password");
        User user = new User(name, password);
        char res = 0;
        try {
            res = userDao.isInDatabase(user);
        } catch (ClassNotFoundException | NamingException | SQLException e) {
            e.printStackTrace();
        }
        switch(res) {
            case 'u':
                resp.sendRedirect("auth_user_window.jsp");
                break;
            case 'm':
                resp.sendRedirect("manager_win.jsp");
                break;
            case 'n':
                req.setAttribute("register", "You are not registered yet");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("add.jsp");
                requestDispatcher.forward(req, resp);
                break;
            case 'p':
                req.setAttribute("pass_incorr", "Password is incorrect\n" +
                        "Please, try again");
                requestDispatcher = req.getRequestDispatcher("add.jsp");
                requestDispatcher.forward(req, resp);
        }
    }

}
