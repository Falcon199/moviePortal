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

@WebServlet(urlPatterns = "/movie")
public class MovieServlet extends HttpServlet {
    private MovieManager movieManager = new MovieManager();
    private GenreManager genreManager = new GenreManager();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        Movie movieById = movieManager.getMovieById(Integer.parseInt(idStr));
        List<Genre> genres = genreManager.allGenre();
        List<Movie> movies = movieManager.allMovie();
        req.setAttribute("movie",movieById);
        req.setAttribute("allGenres",genres);
        req.setAttribute("allMovies",movies);
        req.getRequestDispatcher("/WEB-INF/movie.jsp").forward(req,resp);
    }
}
