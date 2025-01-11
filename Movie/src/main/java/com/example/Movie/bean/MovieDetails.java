package com.example.Movie.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movie_details")
public class MovieDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int movieId;
    int ratings;
    String synobsis;
    @Temporal(TemporalType.DATE)
    Date releaseDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public String getSynobsis() {
        return synobsis;
    }

    public void setSynobsis(String synobsis) {
        this.synobsis = synobsis;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
