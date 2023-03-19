package com.example.jumptospringboot.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Answer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "questionId")
    private Question question;

    public Answer(Long answerId, String content, Question question, LocalDateTime createdAt) {
        this.answerId = answerId;
        this.content = content;
        this.question = question;
        this.setCreatedAt(createdAt);
    }
}
