package com.sg.erona.domain.persistence.repository;

import com.sg.erona.domain.persistence.entity.ConnectionTestQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConnectionTestQuizRepository extends JpaRepository<ConnectionTestQuiz, Long> {
    List<ConnectionTestQuiz> findAllByIdIn(List<Long> ids); //test
}
