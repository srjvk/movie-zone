package com.ml.movie.zone.movie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movie_statistic")
public class Movie {
    @Id
    @Column(name = "\"rank\"")
    private Integer rank;
    @Column(name="movie_title")
    private String name;
    private Integer year;
    private Float rating;
    private String genre;
    private String certificate;
    @Column(name="run_time")
    private String run_time;
    private String tagline;
    private Integer budget;
    @Column(name="box_office")
    private Integer box_office;
    private String casts;
    private String directors;
    private String writers;

    public Movie() {
    }

    public Movie(int rank, String name, int year, float rating, String genre, String certificate, String run_time, String tagline, int budget, int box_office, String casts, String directors, String writers) {
        this.rank = rank;
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.genre = genre;
        this.certificate = certificate;
        this.run_time = run_time;
        this.tagline = tagline;
        this.budget = budget;
        this.box_office = box_office;
        this.casts = casts;
        this.directors = directors;
        this.writers = writers;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getRun_time() {
        return run_time;
    }

    public void setRun_time(String run_time) {
        this.run_time = run_time;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getBox_office() {
        return box_office;
    }

    public void setBox_office(int box_office) {
        this.box_office = box_office;
    }

    public String getCasts() {
        return casts;
    }

    public void setCasts(String casts) {
        this.casts = casts;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getWriters() {
        return writers;
    }

    public void setWriters(String writers) {
        this.writers = writers;
    }
}
