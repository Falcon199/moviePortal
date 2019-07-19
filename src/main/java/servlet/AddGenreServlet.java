package servlet;

import manager.GenreManager;
import manager.MovieManager;
import model.Genre;
import model.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin/addGenre")
public class AddGenreServlet extends HttpServlet {

    private MovieManager movieManager = new MovieManager();
    private GenreManager genreManager = new GenreManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Genre> genres = genreManager.allGenre();
        List<Movie> allMovies = movieManager.allMovie();
        req.setAttribute("allMovies", allMovies);
        req.setAttribute("allGenres", genres);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Genre genre = new Genre();
        genre.setName(name);
        GenreManager genreManager = new GenreManager();
        genreManager.addGenre(genre);
        req.setAttribute("allGenres", genreManager.allGenre());
        resp.sendRedirect("/WEB-INF/adminHome.jsp");
    }
}
