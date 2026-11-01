
package org.example.jpabook.week09_jpa_project.entity;

import org.example.jpabook.week09_jpa_project.dto.MovieRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 100)
    private String director;

    @Column(nullable = false, length = 50)
    private String genre;

    @Column(nullable = false)
    private Integer releaseYear;

    @Column(nullable = false)
    private Double rating;

    @Column(nullable = false)
    private Integer runningTime;

    protected Movie() {}

    public Movie(MovieRequest request) {
        this.title = request.title();
        this.director = request.director();
        this.genre = request.genre();
        this.releaseYear = request.releaseYear();
        this.rating = request.rating();
        this.runningTime = request.runningTime();
    }

    public void update(MovieRequest request) {
        this.title = request.title();
        this.director = request.director();
        this.genre = request.genre();
        this.releaseYear = request.releaseYear();
        this.rating = request.rating();
        this.runningTime = request.runningTime();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public Double getRating() {
        return rating;
    }

    public Integer getRunningTime() {
        return runningTime;
    }
}
