package com.example.Movie.service;

import com.example.Movie.bean.Movie;
import com.example.Movie.bean.MovieDetails;
import com.example.Movie.bean.ShowTime;
import com.example.Movie.exception.NoSuchMovieExistsException;
import com.example.Movie.repository.MovieDetailsRepository;
import com.example.Movie.repository.MovieRepository;
import com.example.Movie.repository.ShowTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieDetailsRepository movieDetailsRepository;

    @Autowired
    ShowTimeRepository showTimeRepository;

    public List<Movie> getDetails(){

       return movieRepository.findAll();
    }

    public Optional<MovieDetails> getDetailsById(int id) {

    	Optional<MovieDetails> md=movieDetailsRepository.findById(id);
    	if(md.isPresent()) {
    		return md;
    	}else {
    		throw new NoSuchMovieExistsException("No  movie exist with id "+id);
    	}
       // return movieDetailsRepository.findById(id);
    }

    public List<ShowTime> getShowTiming(int id) {

        return showTimeRepository.findAllById(id);
    }

    public List<ShowTime> getShowTimingByDate(int id, Date showDate) {
        return showTimeRepository.findAllByIdAndDate(id,showDate);
    }
}
