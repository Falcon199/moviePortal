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
import java.util.*;

@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    private MovieManager movieManager = new MovieManager();
    private GenreManager genreManager = new GenreManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Movie> movies = movieManager.allMovie();
        List<Movie> allMovies = new LinkedList<Movie>();
        for (Movie i : movies) {
            int id = i.getId();
            List<Genre> genreById = new ArrayList<Genre>();
            List<Integer> genreIdByRelationshipTable = genreManager.getGenreIdByRelationshipTable(id);
            for (Integer integer : genreIdByRelationshipTable) {
                Genre genreId = genreManager.getGenreById(integer);
                genreById.add(genreId);
            }

            i.setGenres(genreById);
            allMovies.add(i);

        }
        List<Genre> genres = genreManager.allGenre();

        req.setAttribute("allMovies", allMovies);
        req.setAttribute("allGenres", genres);

        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }
}
