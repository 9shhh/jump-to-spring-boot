package com.example.jumptospringboot;

import com.example.jumptospringboot.domain.Question;
import com.example.jumptospringboot.repository.QuestionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class JumpToSpringBootApplicationTests {

    private static final LocalDateTime CREATED_AT = LocalDateTime.now();

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    @DisplayName("등록 테스트")
    void test1() {
        var q1 = new Question(
                "제목",
                "컨텐츠",
                CREATED_AT);
        questionRepository.save(q1);

        var q2 = new Question(
                "제목2",
                "컨텐츠2",
                CREATED_AT);
        questionRepository.save(q2);
    }

    @Test
    @DisplayName("조회 테스트 - id")
    void test2() {
        var byId = questionRepository.findById(1L);
        if (byId.isPresent()) {
            var question = byId.get();
            assertThat("제목").isEqualTo(question.getSubject());
        }
    }

    @Test
    @DisplayName("조회 테스트 - subject")
    void test3() {
        var question = questionRepository.findBySubject("제목");
        assertThat(1L).isEqualTo(question.getQuestionId());
    }

    @Test
    @DisplayName("조회 테스트 - subject and content")
    void test4() {
        var question = questionRepository.findBySubjectAndContent("제목", "컨텐츠");
        assertThat(1L).isEqualTo(question.getQuestionId());
    }

    @Test
    @DisplayName("조회 테스트 - content like")
    void test5() {
        var qList = questionRepository.findBySubjectLike("제%");
        var q = qList.get(0);
        assertThat("제목").isEqualTo(q.getSubject());
    }

    @Test
    @DisplayName("수정 테스트")
    void test6() {
        var question = questionRepository.findById(1L);
        assertTrue(question.isPresent());
        var q = question.get();
        q.setSubject("수정된 제목");
        this.questionRepository.save(q);
    }
}
