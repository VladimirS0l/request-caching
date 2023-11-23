package ru.prospectors.requestcaching.service

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service
import ru.prospectors.requestcaching.model.Answer
import ru.prospectors.requestcaching.repository.AnswerRepository

@Primary
@Service
class DomainAnswerService(
    @Qualifier("answerRedisRepository") private val answerRepository: AnswerRepository
): AnswerService {
    override fun findById(id: String) = answerRepository.findById(id)
    override fun addAnswer(answer: Answer) = answerRepository.save(answer)
}
