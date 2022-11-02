package com.sg.erona.domain.persistence.repository;

import com.sg.erona.domain.persistence.entity.ConnectionTestQuiz;
import com.sg.erona.domain.persistence.entity.IdiomQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdiomQuizRepository extends JpaRepository<IdiomQuiz, Long> {
    Long countBy();
    List<IdiomQuiz> findAllByIdIn(List<Long> ids);
}
