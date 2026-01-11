package com.ml.movie.zone.movie;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }


    public List<Movie> getMovieFromDirector(String director){
        return movieRepository.findAll().stream().filter(movie ->director.equals(movie.getDirectors())).collect(Collectors.toUnmodifiableList());
    }

    public List<Movie> getMovieByName(String searchText){
        return movieRepository.findAll().stream().filter(movie->movie.getName().toLowerCase().contains(searchText.toLowerCase())).collect(Collectors.toUnmodifiableList());
    }

    public List<Movie> getMoviesByGenre(String searchText){
        return movieRepository.findAll().stream().filter(movie -> movie.getGenre().toLowerCase().contains(searchText.toLowerCase())).collect(Collectors.toUnmodifiableList());
    }

    public List<Movie> getMoviesByRank(int rank) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getRank() == rank)
                .toList();
    }


    public List<Movie> getMoviesByCertificate(String searchText){
        return movieRepository.findAll().stream().filter(movie -> movie.getCertificate().toLowerCase().contains(searchText.toLowerCase())).collect(Collectors.toUnmodifiableList());
    }

    public List<Movie> getMoviesByCast(String searchText){
        return movieRepository.findAll().stream().filter(movie -> movie.getCasts().toLowerCase().contains(searchText.toLowerCase())).collect(Collectors.toUnmodifiableList());
    }



    public Movie addMovie(Movie movie){
        movieRepository.save(movie);
        return movie;
    }

    public Movie updateMovie(Movie updateMovie){
        Optional<Movie> existingMovie = movieRepository.findByRank(updateMovie.getRank());

        if(existingMovie.isPresent()){
            Movie movieToUpdate = existingMovie.get();
            movieToUpdate.setName(updateMovie.getName());
            movieToUpdate.setCasts(updateMovie.getCasts());
            movieToUpdate.setCertificate(updateMovie.getCertificate());
            movieToUpdate.setDirectors(updateMovie.getDirectors());
            movieToUpdate.setRank(updateMovie.getRank());
            movieToUpdate.setBudget(updateMovie.getBudget());
            movieToUpdate.setBox_office(updateMovie.getBox_office());
            movieToUpdate.setRun_time(updateMovie.getRun_time());
            movieToUpdate.setRating(updateMovie.getRating());
            movieToUpdate.setGenre(updateMovie.getGenre());
            movieToUpdate.setTagline(updateMovie.getTagline());
            movieToUpdate.setWriters(updateMovie.getWriters());
            movieToUpdate.setYear(updateMovie.getYear());

            movieRepository.save(movieToUpdate);
            return movieToUpdate;



        }
        return null;
    }

    @Transactional
    public void deleteMovie(String movieName){
        movieRepository.deleteByName(movieName);
    }






}
