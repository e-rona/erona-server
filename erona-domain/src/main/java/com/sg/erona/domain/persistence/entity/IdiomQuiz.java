package com.sg.erona.domain.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="idiom_quiz")
@Entity
@SuperBuilder
public class IdiomQuiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String quiz;

    @Column(nullable = false)
    private String answer;

    @Column(nullable = false)
    private Long level;
}
