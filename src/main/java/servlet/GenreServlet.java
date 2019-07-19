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
import java.util.LinkedList;
import java.util.List;

@WebServlet(urlPatterns = "/genreHome")
public class GenreServlet extends HttpServlet {
        private MovieManager movieManager = new MovieManager();
        private GenreManager genreManager = new GenreManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        List<Integer>  movieByGenreId = movieManager.getMovieIdByRelationshipTable(Integer.parseInt(idStr));
        List<Movie> movies = new LinkedList<Movie>();
        for (Integer id : movieByGenreId) {
            Movie movieById = movieManager.getMovieById(id);
            movies.add(movieById);
        }
        List<Genre> genres = genreManager.allGenre();
        List<Movie> allMovies = movieManager.allMovie();

        req.setAttribute("movies",movies);
        req.setAttribute("allMovies",allMovies);
        req.setAttribute("allGenres",genres);
        req.getRequestDispatcher("/WEB-INF/genreHome.jsp").forward(req,resp);
    }
}
