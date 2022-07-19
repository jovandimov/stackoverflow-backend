package com.sorsix.backendapplication.api

import com.sorsix.backendapplication.domain.Question
import com.sorsix.backendapplication.service.QuestionService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/questions")
class QuestionController(
    val questionService: QuestionService
) {

    @GetMapping
    fun getAll(): List<Question>? {
        return questionService.findAll();
    }

    @GetMapping("/withoutAnswers")
    fun getAllQuestionsWithoutAnswers(): List<Question>? {
        return questionService.findAllQuestionsWithoutAnswers();
    }
}