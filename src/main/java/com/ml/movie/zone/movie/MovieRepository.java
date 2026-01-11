package com.ml.movie.zone.movie;

import com.ml.movie.zone.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    void deleteByName(String name);
    Optional<Movie> findByName(String name);
    Optional<Movie> findByRank(int rank);
}

