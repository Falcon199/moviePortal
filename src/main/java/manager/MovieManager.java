package manager;

import dateutil.DateUtil;
import db.DBConnectionProvider;
import model.Genre;
import model.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    private Connection connection;

    public MovieManager() {
        connection = DBConnectionProvider.getInstance().getConnection();
    }

    public void addMovie(Movie movie) {
        String query = "INSERT INTO movie(`title`,`description`,year,`pic_url`,`created_date`,`director`)" + "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, movie.getDescription());
            preparedStatement.setInt(3, movie.getYear());
            preparedStatement.setString(4, movie.getPicUrl());
            preparedStatement.setString(5, DateUtil.convertDateToString(movie.getCreatedDate()));
            preparedStatement.setString(6, movie.getDirector());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                movie.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public List<Movie> allMovie() {
        String query = "SELECT * FROM movie";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Movie> movies = new ArrayList<Movie>();
            List<Genre> genreById = null;
            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setId(resultSet.getInt(1));
                movie.setTitle(resultSet.getString(2));
                movie.setDescription(resultSet.getString(3));
                movie.setYear(resultSet.getInt(4));
                movie.setPicUrl(resultSet.getString(5));
                movie.setCreatedDate(DateUtil.convertStringToDate(resultSet.getString(6)));
                movie.setDirector(resultSet.getString(7));
                movie.setGenres(genreById);
                movies.add(movie);
            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    public void addRelationshipTable(Movie movie, List<Genre> genre) {
        String query = "INSERT INTO movie_genre(movie_id, genre_id) VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            for (Genre genreList : genre) {
                int genreId = genreList.getId();
                preparedStatement.setInt(1, movie.getId());
                preparedStatement.setInt(2, genreId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Movie> moviesByYear(int year) {
        String query = "SELECT * FROM movie WHERE year = " + year;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Movie> movies = new ArrayList<Movie>();
            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setId(resultSet.getInt(1));
                movie.setTitle(resultSet.getString(2));
                movie.setDescription(resultSet.getString(3));
                movie.setYear(resultSet.getInt(4));
                movie.setPicUrl(resultSet.getString(5));
                movie.setCreatedDate(DateUtil.convertStringToDate(resultSet.getString(6)));
                movie.setDirector(resultSet.getString(7));
                movies.add(movie);
            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Integer> getMovieIdByRelationshipTable(int genreId) {
        String query = "SELECT * FROM movie_genre WHERE genre_id = " + genreId;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Integer> movieId = new ArrayList<Integer>();
            while (resultSet.next()) {
                movieId.add(resultSet.getInt(1));
            }
            return movieId;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public Movie getMovieById(int id) {

        String query = "SELECT * FROM movie WHERE id =" + id;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = preparedStatement.executeQuery();
            Movie movie = new Movie();
            while (resultSet.next()) {

                movie.setId(resultSet.getInt(1));
                movie.setTitle(resultSet.getString(2));
                movie.setDescription(resultSet.getString(3));
                movie.setYear(resultSet.getInt(4));
                movie.setPicUrl(resultSet.getString(5));
                movie.setCreatedDate(DateUtil.convertStringToDate(resultSet.getString(6)));
                movie.setDirector(resultSet.getString(7));

            }
            return movie;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;

    }


}
