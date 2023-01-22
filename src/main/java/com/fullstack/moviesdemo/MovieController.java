package com.fullstack.moviesdemo;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;// auto instantiate classes
import org.springframework.http.HttpStatus; // response for http requests
import org.springframework.web.bind.annotation.GetMapping; // get request mapping for routes
import org.springframework.web.bind.annotation.PathVariable; // used for query params from url
import org.springframework.web.bind.annotation.RequestMapping; // sets the root route for the getmappings, putmappings ...
import org.springframework.web.bind.annotation.RestController; // designates as a controller for http requests
import org.springframework.http.ResponseEntity; // http response class to send responses to clients

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);// response entity will send list of movies(payload.from service, http status)
    }

    @GetMapping("/{id}")//query params anything that comes after / slash
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id){ //path variable === queryparams conver it to ObjectId type and then set to id variable
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(id), HttpStatus.OK);
    }
}
