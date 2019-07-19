package servlet;

import dateutil.StaticConfig;
import manager.GenreManager;
import manager.MovieManager;
import model.Genre;
import model.Movie;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@WebServlet(urlPatterns = "/admin/addMovia")
public class AddMovieServlet extends HttpServlet {

    private GenreManager genreManager = new GenreManager();
    private MovieManager movieManager = new MovieManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Genre> genres = genreManager.allGenre();
        List<Movie> allMovies = movieManager.allMovie();
        req.setAttribute("allMovies", allMovies);
        req.setAttribute("allGenres", genres);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(req)) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(1024 * 1024);
            factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(1024 * 1024 * 50);
            upload.setSizeMax(1024 * 1024 * 5 * 50);
            String uploadPath = StaticConfig.IMAGE_PATH;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            try {
                Movie movie = new Movie();
                List<Genre> genres = new LinkedList<Genre>();
                List<FileItem> formItems = upload.parseRequest(req);
                if (formItems != null && formItems.size() > 0) {
                    for (FileItem item : formItems) {
                        if (!item.isFormField()) {
                            String fileName = System.currentTimeMillis() + "_" + new File(item.getName()).getName();
                            String filePath = uploadPath + fileName;
                            File storeFile = new File(filePath);
                            item.write(storeFile);
                            movie.setPicUrl(fileName);
                        } else {
                            if (item.getFieldName().equals("title")) {
                                movie.setTitle(item.getString());
                            } else if (item.getFieldName().equals("description")) {
                                movie.setDescription(item.getString());
                            } else if (item.getFieldName().equals("year")) {
                                movie.setYear(Integer.parseInt(item.getString()));
                            } else if (item.getFieldName().equals("genreId")) {
                                Genre genreById = genreManager.getGenreById(Integer.parseInt(item.getString()));
                                genres.add(genreById);
                                movie.setGenres(genres);
                            } else if (item.getFieldName().equals("director")) {
                                movie.setDirector(item.getString());
                            }
                        }
                    }

                    movie.setCreatedDate(new Date());
                    movieManager.addMovie(movie);
                    movieManager.addRelationshipTable(movie,genres);
                    req.setAttribute("allGenres", genreManager.allGenre());
                    resp.sendRedirect("/WEB-INF/adminHome.jsp");
                }

            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }
}







