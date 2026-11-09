package org.example.jpabook.week09_jpa_project.repository;

import org.example.jpabook.week09_jpa_project.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//Repository는 데이터베이스에 저장된 영화 정보를 관리하는 역할
//JpaRepository를 상속받으면 저장, 조회, 수정, 삭제 기능을 기본으로 사용
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByGenre(String genre);
    List<Movie> findByGenreAndRatingGreaterThanEqual(String genre, Double rating);
    List<Movie> findByGenreOrderByRatingDesc(String genre);

}


//<Movie, Long>에서 Movie는 관리할 Entity 클래스, Long은 Movie 클래스에서 기본 키로 사용

//JpaRepository가 기본으로 제공하는 주요 메서드
//save():새로운 데이터를 저장하거나 기존 데이터 수정
//findById():전달한 ID와 일치하는 데이터 조회
//findAll():데이터베이스에 저장된 모든 데이터 조회
//existsById():전달한 ID에 해당하는 데이터가 있는지 확인
//count():데이터베이스에 저장된 전체 데이터의 개수 반환
//deleteById():전달한 ID에 해당하는 데이터 삭제

//findById()는 Optional을 반환
//조회하려는 ID의 데이터가 존재할 수도 있고 존재하지 않을 수도 있음
//Optional을 사용하면 데이터가 없는 경우도 안전하게 처리할 수 있음

//JpaRepository가 제공하는 기본 메서드는 일반적인 데이터 관리 기능 수행
//Query Method= 개발자가 메서드 이름을 직접 작성하여 원하는 조건으로 데이터 검색
