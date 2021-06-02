package app.servlets;

import app.dao.UserDao;
import app.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Register extends HttpServlet {

    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("register.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        String name = req.getParameter("userName");
        String password = req.getParameter("password");
        String position = req.getParameter("position");
        User user;
        if("user".equals(position)) {
            user = new User(name, password, position);
            try {
                userDao.registerUser(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
            session.setAttribute("id", user.getUserId());
            resp.sendRedirect("auth_user_window.jsp");
        } else {
            user = new User(name, password, position);
            try {
                userDao.registerUser(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
            session.setAttribute("id", user.getUserId());
            resp.sendRedirect("manager_win.jsp");
        }
    }
}
