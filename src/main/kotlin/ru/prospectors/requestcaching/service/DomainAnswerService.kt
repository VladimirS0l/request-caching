package ru.prospectors.requestcaching.service

import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import ru.prospectors.requestcaching.model.Answer
import ru.prospectors.requestcaching.repository.AnswerRepository
import ru.prospectors.requestcaching.webclient.WebClientRepository

@Primary
@Service
class DomainAnswerService(
    private val answerRepository: AnswerRepository,
    private val webClient: WebClientRepository
): AnswerService {
    override fun findById(id: String): Mono<Answer?> {
        return answerRepository.findById(id)
            .switchIfEmpty(webClient.findById(id)).flatMap { answer ->
                if (answer != null) {
                    addAnswer(answer)
                } else {
                    Mono.empty()
                }
            }
    }

    override fun addAnswer(answer: Answer) = answerRepository.save(answer)
}
