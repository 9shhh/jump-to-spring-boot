package com.example.jumptospringboot.repository;

import com.example.jumptospringboot.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Question findBySubject(String subject);
}
