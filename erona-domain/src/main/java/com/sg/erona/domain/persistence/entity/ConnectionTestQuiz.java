package com.sg.erona.domain.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="connection_test_quiz")
@Entity
@SuperBuilder
public class ConnectionTestQuiz{

    @Id
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String testQuiz;

    @Column(nullable = false)
    private String testAnswer;

    @Column(nullable = false)
    private Long testLevel;
}
