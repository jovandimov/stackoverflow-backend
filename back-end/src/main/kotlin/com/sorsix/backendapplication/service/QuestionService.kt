package com.sorsix.backendapplication.service

import com.sorsix.backendapplication.domain.Question
import com.sorsix.backendapplication.repository.QuestionRepository
import com.sorsix.backendapplication.repository.QuestionTagRepository
import com.sorsix.backendapplication.repository.TagRepository
import org.springframework.stereotype.Service

@Service
class QuestionService(
    val questionRepository: QuestionRepository,
    val tagRepository: TagRepository,
    val questionTagRepository: QuestionTagRepository
) {

    fun findAllQuestionsWithoutAnswers(): List<Question>? {
        return questionRepository.findAll().filter { it.parentQuestion == null };
    }

    fun findAll(): List<Question>? {
        return questionRepository.findAll();
    }

    fun saveQuestion(){

    }

}