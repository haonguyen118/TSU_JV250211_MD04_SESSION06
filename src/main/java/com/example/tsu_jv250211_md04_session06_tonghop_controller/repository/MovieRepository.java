package com.example.tsu_jv250211_md04_session06_tonghop_controller.repository;

import com.example.tsu_jv250211_md04_session06_tonghop_controller.model.entities.Movie;
import com.example.tsu_jv250211_md04_session06_tonghop_controller.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {
    public List<Movie> getMovies() {
        Connection connection = null;
        CallableStatement callableStatement = null;
        List<Movie> movies = null;
        try {
            connection = ConnectionDB.getConnection();
            callableStatement = connection.prepareCall("{call find_all_movie()}");
            ResultSet resultSet = callableStatement.executeQuery();
            movies = new ArrayList<>();
            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setMovieId(resultSet.getLong("movie_id"));
                movie.setMovieTitle(resultSet.getString("movie_title"));
                movie.setDirector(resultSet.getString("director"));
                movie.setGenre(resultSet.getString("genre"));
                movie.setDescription(resultSet.getString("description"));
                movie.setDuration(resultSet.getInt("duration"));
                movie.setLanguage(resultSet.getString("language"));
                movies.add(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return movies;
    }

    public Boolean addMovie(Movie movie) {
        Connection connection = null;
        CallableStatement callSt = null;
        Boolean result = false;
        try {
            connection = ConnectionDB.getConnection();
            callSt = connection.prepareCall("{call create_movie(?,?,?,?,?,?)}");
            callSt.setString(1, movie.getMovieTitle());
            callSt.setString(2, movie.getDirector());
            callSt.setString(3, movie.getGenre());
            callSt.setString(4, movie.getDescription());
            callSt.setInt(5, movie.getDuration());
            callSt.setString(6, movie.getLanguage());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, callSt);
        }
        return result;
    }

    public Movie getMovieById(long movieId) {
        Connection connection = null;
        CallableStatement callSt = null;
        Movie movie = null;
        try {
            connection = ConnectionDB.getConnection();
            callSt = connection.prepareCall("{call find_movie_by_id(?)}");
            callSt.setLong(1, movieId);
            ResultSet resultSet = callSt.executeQuery();
            if (resultSet.next()) {
                movie = new Movie();
                movie.setMovieId(resultSet.getLong("movie_id"));
                movie.setMovieTitle(resultSet.getString("movie_title"));
                movie.setDirector(resultSet.getString("director"));
                movie.setGenre(resultSet.getString("genre"));
                movie.setDescription(resultSet.getString("description"));
                movie.setDuration(resultSet.getInt("duration"));
                movie.setLanguage(resultSet.getString("language"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, callSt);
        }
        return movie;
    }

    public Boolean updateMovie(Movie movie) {
        Connection connection = null;
        CallableStatement callSt = null;
        Boolean result = false;
        try {
            connection = ConnectionDB.getConnection();
            callSt = connection.prepareCall("{call update_movie(?,?,?,?,?,?,?)}");
            callSt.setLong(1, movie.getMovieId());
            callSt.setString(2, movie.getMovieTitle());
            callSt.setString(3, movie.getDirector());
            callSt.setString(4, movie.getGenre());
            callSt.setString(5, movie.getDescription());
            callSt.setInt(6, movie.getDuration());
            callSt.setString(7, movie.getLanguage());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, callSt);
        }
        return result;
    }

    public Boolean deleteMovie(long movieId) {
        Connection connection = null;
        CallableStatement callSt = null;
        Boolean result = false;
        try {
            connection = ConnectionDB.getConnection();
            callSt = connection.prepareCall("{call delete_movie(?)}");
            callSt.setLong(1, movieId);
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, callSt);
        }
        return result;
    }
}

