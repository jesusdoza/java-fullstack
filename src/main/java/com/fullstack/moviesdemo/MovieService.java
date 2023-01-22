package com.fullstack.moviesdemo;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.annotation.ModelAndViewResolver;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired// will auto instanticate the movie repo
    private MovieRepository movieRepository;
    public List<Movie> allMovies(){

        return movieRepository.findAll();//find all comes from the movie repo extending the mongo repository

    }

    public Optional<Movie>  singleMovie(ObjectId id){ //optional class may return null if it does not find it
        return movieRepository.findById(id);
    }
}
