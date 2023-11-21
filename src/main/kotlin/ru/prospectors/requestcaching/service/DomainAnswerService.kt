package ru.prospectors.requestcaching.service

import org.springframework.stereotype.Service
import ru.prospectors.requestcaching.model.Answer
import ru.prospectors.requestcaching.repository.AnswerRepository

@Service
class DomainAnswerService(
    private val answerRepository: AnswerRepository
): AnswerService {
    override fun findById(id: String) = answerRepository.findById(id)
    override fun addAnswer(answer: Answer) = answerRepository.save(answer)
}
