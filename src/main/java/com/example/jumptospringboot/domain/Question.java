package com.example.jumptospringboot.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Question extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

    public Question(String subject, String content, LocalDateTime createdAt) {
        this.subject = subject;
        this.content = content;
        this.setCreatedAt(createdAt);
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
