package com.example.tsu_jv250211_md04_session06_tonghop_controller.service;

import com.example.tsu_jv250211_md04_session06_tonghop_controller.model.entities.Movie;
import com.example.tsu_jv250211_md04_session06_tonghop_controller.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getMovies(){
        return movieRepository.getMovies();
    }
    public Boolean addMovie(Movie movie){
        return movieRepository.addMovie(movie);
    }
    public Movie getMovieById(Long id){
        return movieRepository.getMovieById(id);
    }
    public Boolean updateMovie(Movie movie){
        return movieRepository.updateMovie(movie);
    }
    public Boolean deleteMovie(Long id){
        return movieRepository.deleteMovie(id);
    }
}
