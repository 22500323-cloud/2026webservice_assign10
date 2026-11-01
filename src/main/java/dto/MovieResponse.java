
package org.example.jpabook.week09_jpa_project.dto;

import org.example.jpabook.week09_jpa_project.entity.Movie;

public record MovieResponse(
        Long id,
        String title,
        String director,
        String genre,
        Integer releaseYear,
        Double rating,
        Integer runningTime
) {
    public static MovieResponse from(Movie movie) {
        return new MovieResponse(
                movie.getId(),
                movie.getTitle(),
                movie.getDirector(),
                movie.getGenre(),
                movie.getReleaseYear(),
                movie.getRating(),
                movie.getRunningTime()
        );
    }
}
