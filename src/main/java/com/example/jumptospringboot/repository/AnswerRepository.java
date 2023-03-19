package com.example.jumptospringboot.repository;

import com.example.jumptospringboot.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
