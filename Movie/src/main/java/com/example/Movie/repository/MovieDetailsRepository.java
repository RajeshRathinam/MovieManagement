package com.example.Movie.repository;

import com.example.Movie.bean.MovieDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieDetailsRepository extends JpaRepository<MovieDetails, Integer> {

   @Query(value = "select * from movie_details where movie_id=:id",nativeQuery = true)
    Optional<MovieDetails> findById(int id);
}
