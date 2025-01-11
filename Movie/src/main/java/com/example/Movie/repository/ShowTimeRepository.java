package com.example.Movie.repository;

import com.example.Movie.bean.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface ShowTimeRepository extends JpaRepository<ShowTime,Integer> {

    @Query(value = "select * from show_time where movie_id=:id",nativeQuery = true)
    List<ShowTime> findAllById(@Param("id") int movieId);

    @Query(value = "select * from show_time where movie_id=:id and show_date=:showDate",nativeQuery = true)
    List<ShowTime> findAllByIdAndDate(@Param("id") int movieId,@Param("showDate") Date showDate);
}
