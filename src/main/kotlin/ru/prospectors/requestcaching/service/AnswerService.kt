package ru.prospectors.requestcaching.service

import org.springframework.stereotype.Service
import ru.prospectors.requestcaching.model.Answer
import ru.prospectors.requestcaching.repository.AnswerRepository

@Service
class AnswerService(
    private val answerRepository: AnswerRepository
) {
    fun findById(id: String) = answerRepository.findById(id)
    fun addAnswer(answer: Answer) = answerRepository.save(answer)

    init {
        println("init")
    }
}