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
//@Service는 이 클래스가 서비스 역할을 하는 클래스라는 것을 Spring에게 알려준다
//Controller의 요청을 받아 실제 영화 등록, 조회, 수정, 삭제 작업
public class MovieService {
    //MovieRepository를 사용하기 위해 객체를 변수로 저장
    //final을 사용하면 생성된 이후 다른 객체로 변경할 수 없음

    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }
    //생성자를 통해 MovieRepository 객체 전달받음.
    //직접 객체를 만들지 않아도 Spring이 필요한 객체를 연결해줌.

    public MovieResponse create(MovieRequest request) {
        //새로운 영화를 등록하는 메서드
        Movie saved = repository.save(new Movie(request));
        //new Movie(request)를 이용하여 새로운 영화 객체 생성
        //repository.save()는 새로운 영화 정보를 데이터베이스에 저장
        //새로운 데이터이므로 데이터베이스에는 INSERT 작업이 실행
        return MovieResponse.from(saved);
        //저장된 영화 정보를 MovieResponse 형태로 바꾸어 반환
    }

    public List<MovieResponse> findAll() {
        //데이터베이스에 저장된 모든 영화 정보를 조회
        return repository.findAll()
                .stream()
                .map(MovieResponse::from)
                .toList();
        //findAll()은 데이터베이스에 저장된 모든 영화 정보 가져오기
        //stream()과 map()을 이용하여 Movie 객체를 MovieResponse로 변환
        //toList()는 변환된 결과를 리스트로 만들어 반환
    }

    public MovieResponse findById(Long id) {
        //id를 이용하여 영화 한 개를 조회
        return MovieResponse.from(findEntity(id));
        //findEntity()를 이용하여 해당 id의 영화를 찾음
        //조회한 영화 정보를 MovieResponse 형태로 바꾸어 반환
    }

    public MovieResponse update(Long id, MovieRequest request) {
        //영화 정보를 수정
        Movie movie = findEntity(id);
        //먼저 데이터베이스에서 수정할 영화를 찾음
        movie.update(request);
        //조회한 영화 객체의 정보를 새로운 값으로 변경

        return MovieResponse.from(repository.save(movie));
        //save()를 다시 호출
    }

    public void delete(Long id) {
        //id를 이용하여 영화 삭제
        if (!repository.existsById(id)) {
            //existsById()는 해당 id의 영화가 데이터베이스에 존재하는지 확인
            //!는 존재하지 않는 경우를 의미
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Movie not found: " + id
                    //해당 영화가 존재하지 않으면 404 NOT_FOUND 오류를 발생
                    //오류 메시지에 찾으려는 영화의 id를 함께 표시
            );
        }

        repository.deleteById(id);
        //해당 id의 영화 데이터를 데이터베이스에서 삭제
    }

    private Movie findEntity(Long id) {
        //다른 메서드에서 사용할 수 있도록 영화 조회 기능을 따로 생성
        //private이므로 MovieService 클래스 내부에서만 사용
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Movie not found: " + id
                        //findById()는 id에 해당하는 영화를 조회
                        //조회 결과가 없으면 orElseThrow()를 이용하여 404 오류
                ));
    }
}
