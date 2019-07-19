package manager;


import db.DBConnectionProvider;
import model.Genre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreManager {
    private Connection connection;

    public GenreManager() {
        connection = new DBConnectionProvider().getInstance().getConnection();
    }

    public void addGenre(Genre genre) {
        String query = "INSERT INTO genre(`name`)" + "VALUES(?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, genre.getName());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                genre.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Genre> allGenre() {
        String query = "SELECT * FROM genre";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Genre> genres = new ArrayList<Genre>();
            while (resultSet.next()) {
                Genre genre = new Genre();
                genre.setId(resultSet.getInt(1));
                genre.setName(resultSet.getString(2));
                genres.add(genre);
            }
            return genres;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public List<Integer> getGenreIdByRelationshipTable(int movieId) {
        String query = "SELECT * FROM movie_genre WHERE movie_id = " + movieId;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Integer> genreId = new ArrayList<Integer>();
            while (resultSet.next()) {
                genreId.add(resultSet.getInt(2));
            }
            return genreId;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Genre getGenreById(int id) {

        String query = "SELECT * FROM genre WHERE id =" + id;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = preparedStatement.executeQuery();
            Genre genre = new Genre();
            while (resultSet.next()) {

                genre.setId(resultSet.getInt(1));
                genre.setName(resultSet.getString(2));

            }
            return genre;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;

    }

    public int getGenreIdByName(String name) {
        String query = "SELECT * FROM genre WHERE name = '" + name + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

}
