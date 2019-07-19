package servlet;

import manager.GenreManager;
import manager.UserManager;
import model.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private UserManager userManager = new UserManager();
    private GenreManager genreManager = new GenreManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = userManager.getUserByEmailAndPassword(email, password);
        if (user == null) {
            resp.sendRedirect("/login.jsp");
        } else {
            req.getSession().setAttribute("user", user);
            req.setAttribute("allGenres",genreManager.allGenre());
           req.getRequestDispatcher("/WEB-INF/adminHome.jsp").forward(req,resp);
        }

    }
}
