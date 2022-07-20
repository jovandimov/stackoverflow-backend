package com.sorsix.backendapplication.api

import com.sorsix.backendapplication.api.dto.QuestionRequest
import com.sorsix.backendapplication.domain.Question
import com.sorsix.backendapplication.domain.Tag
import com.sorsix.backendapplication.service.QuestionService
import com.sorsix.backendapplication.service.TagService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/questions")
class QuestionController(
    val questionService: QuestionService,
    val tagService: TagService,
) {

    @GetMapping
    fun getAll(): List<Question>? {
        return questionService.findAll();
    }

    @GetMapping("/withoutAnswers")
    fun getAllQuestionsWithoutAnswers(): List<Question>? {
        return questionService.findAllQuestionsWithoutAnswers();
    }

    @PostMapping
    fun createQuestion(@RequestBody request: QuestionRequest) {
        questionService.createQuestion(request.title,
            request.questionText,
            request.parentQuestionId,
            request.appUserId,
            request.tagsId)

    }
}