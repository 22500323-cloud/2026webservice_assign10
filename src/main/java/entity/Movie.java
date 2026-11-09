
package org.example.jpabook.week09_jpa_project.entity;

import org.example.jpabook.week09_jpa_project.dto.MovieRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.EntityListeners;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;

@Entity
//Movie 객체의 정보를 데이터베이스에 저장하고 관리할 수 있게 한다
@EntityListeners(AuditingEntityListener.class)
@Table(name = "movies")
//Movie 클래스의 데이터가 movies테이블과 연결되도록
public class Movie {

    @Id
    //각 영화를 구분하기 위한 고유 번호
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //영화의 고유번호를 자동 생성
    //IDENTITY는 데이터 베이스의 AUTO_INCREMENT 기능 사용
    private Long id;

    @Column(nullable = false, length = 200)
    //영화 제목을 저장
    //데이터베이스에 저장될 때 적용할 조건 설정(nullable=false -> 제목을 비워둘 수 없다,length=200-> 최대 200자까지 저장)
    private String title;

    @Column(nullable = false, length = 100)
    //영화 감동 이름
    //데이터베이스에 NULL값으로 저장 불가, 최대 100자까지 저장가능
    private String director;

    @Column(nullable = false, length = 50)
    //영화 장르
    //데이터베이스에 NULL값으로 저장 불가, 최대 50자까지 저장가능
    private String genre;

    @Column(nullable = false)
    //개봉연도
    //반드시 값이 있어야함
    private Integer releaseYear;

    @Column(nullable = false)
    //영화 평점
    //반드시 값이 있어야함
    private Double rating;

    @Column(nullable = false)
    //영화 상영시간
    //반드시 값이 있어야함
    private Integer runningTime;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    protected Movie() {}
    //내부적으로 객체를 생성할 수 있도록 protected

    public Movie(MovieRequest request) {
        //제목, 감독, 장르 등의 정보를 받아 새로운 영화 생성
        this.title = request.title();
        this.director = request.director();
        this.genre = request.genre();
        this.releaseYear = request.releaseYear();
        this.rating = request.rating();
        this.runningTime = request.runningTime();
    }

    public void update(MovieRequest request) {
        //영화 정보 수정
        //MovieRequest에서 새로운 정보를 받아 기존 영화 정보 덮어쓰기
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
    //영화의 고유 번호 가져오기

    public String getTitle() {
        return title;
    }
    //영화 제목 가져오기

    public String getDirector() {
        return director;
    }
    //감독 이름 가져오기

    public String getGenre() {
        return genre;
    }
    //장르 가져오기

    public Integer getReleaseYear() {
        return releaseYear;
    }
    //개봉 연도 가져오기

    public Double getRating() {
        return rating;
    }
    //영화 평점 가져오기

    public Integer getRunningTime() {
        return runningTime;
    }
    //상영시간 가져오기

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
