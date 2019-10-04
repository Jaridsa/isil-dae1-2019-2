package pe.isil.controller;

import pe.isil.dao.DaoContext;
import pe.isil.dao.UserDao;
import pe.isil.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login",  loadOnStartup = 1, name = "login")
public class LoginController extends HttpServlet {


    @Override
    public void init() throws ServletException {
        DaoContext.init(this.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("login","");
        req.setAttribute("password","");
        req.setAttribute("errorMessage","");

        req.getRequestDispatcher("/login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("txtLogin");
        String password = req.getParameter("txtPassword");

        req.setAttribute("login", login);
        req.setAttribute("password", password);

        User user = UserDao.isValidLogin(login, password);

        if(user != null){
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            req.getRequestDispatcher("/home.jsp").forward(req, resp);
        }else{
            req.setAttribute("errorMessage", "bad credentials");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }
}
