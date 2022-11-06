package com.sg.erona.domain.persistence.repository;

import com.sg.erona.domain.persistence.entity.MovieQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieQuizRepository extends JpaRepository<MovieQuiz, Long> {
    Long countBy();
    List<MovieQuiz> findAllByIdIn(List<Long> ids);
}
