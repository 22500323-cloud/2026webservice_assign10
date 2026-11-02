package org.example.jpabook.week09_jpa_project.service;

import org.example.jpabook.week09_jpa_project.dto.MovieRequest;
import org.example.jpabook.week09_jpa_project.dto.MovieResponse;
import org.example.jpabook.week09_jpa_project.entity.Movie;
import org.example.jpabook.week09_jpa_project.repository.MovieRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public MovieResponse create(MovieRequest request) {
        Movie saved = repository.save(new Movie(request));
        return MovieResponse.from(saved);
    }

    public List<MovieResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(MovieResponse::from)
                .toList();
    }

    public MovieResponse findById(Long id) {
        return MovieResponse.from(findEntity(id));
    }

    public MovieResponse update(Long id, MovieRequest request) {
        Movie movie = findEntity(id);
        movie.update(request);

        return MovieResponse.from(repository.save(movie));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Movie not found: " + id
            );
        }

        repository.deleteById(id);
    }

    private Movie findEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Movie not found: " + id
                ));
    }
}
