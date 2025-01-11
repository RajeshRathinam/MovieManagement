package com.example.Movie.controller;

import com.example.Movie.bean.Movie;
import com.example.Movie.bean.MovieDetails;
import com.example.Movie.bean.ShowTime;
import com.example.Movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/movie")
@Validated
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/getDetails")
    public List<Movie> getDetails() {
        return movieService.getDetails();
    }

    @GetMapping("/getDetails/{id}")
    public Optional<MovieDetails> getDetailsById(@PathVariable("id") int id) {

        return movieService.getDetailsById(id);
    }

    @GetMapping("/getDetails/{id}/showTime")
    public List<ShowTime> getShowTiming( @PathVariable("id") @Positive(message = "Movie ID must be greater than Zero")  int id){
        return movieService.getShowTiming(id);
    }

    @GetMapping("/getDetails/{id}/showTime/{date}")
    public List<ShowTime> getShowTimingByDate(@PathVariable("id") int id,
                 // @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date showDate){
                 @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date showDate){
        System.out.println("usr date="+showDate);
        return movieService.getShowTimingByDate(id,showDate);

    }
    
	
}
