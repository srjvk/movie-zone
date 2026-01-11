package com.ml.movie.zone.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/movie")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getMovies(@RequestParam(required = false) String director,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(required = false) String casts,
                                 @RequestParam(required = false) Integer rank,
                                 @RequestParam(required = false) String genre,
                                 @RequestParam(required = false) String certificate
                                 ) {
        if (director != null) {
            return movieService.getMovieFromDirector(director);
        } else if (name != null) {
            return movieService.getMovieByName(name);
        }
        else if (rank != null) {
            return movieService.getMoviesByRank(rank);
        }
        else if (genre != null) {
            return movieService.getMoviesByGenre(genre);
        }
        else if (casts != null) {
            return movieService.getMoviesByCast(casts);
        }
        else if (certificate != null) {
            return movieService.getMoviesByCertificate(certificate);
        } else {
            return movieService.getMovies();
        }
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        Movie createdMovie = movieService.addMovie(movie);
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie){
        Movie resultMovie = movieService.updateMovie(movie);
        if(resultMovie != null){
            return new ResponseEntity<>(resultMovie, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{movieName}")
    public ResponseEntity<String> deleteMovie(@PathVariable String movieName){
        movieService.deleteMovie(movieName);
        return new ResponseEntity<>("Movie deleted successfully",HttpStatus.OK);
    }



}
