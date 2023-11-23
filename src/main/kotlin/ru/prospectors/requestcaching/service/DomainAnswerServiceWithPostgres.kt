package ru.prospectors.requestcaching.service

import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import ru.prospectors.requestcaching.model.Answer
import ru.prospectors.requestcaching.model.converter.Converter
import ru.prospectors.requestcaching.repository.AnswerPostgresRepository
import ru.prospectors.requestcaching.webclient.WebClientRepository

@Service
class DomainAnswerServiceWithPostgres(
    private val answerRepository: AnswerPostgresRepository,
    private val converter: Converter,
    private val webClient: WebClientRepository
): AnswerService {
    override fun findById(id: String): Mono<Answer?> {
        return answerRepository.findById(id)
            .map { converter.toEntity(it) }
            .switchIfEmpty(webClient.findById(id)).flatMap { answer -> addAnswer(answer) }
    }

    override fun addAnswer(answer: Answer): Mono<Answer> {
        return answerRepository.save(converter.toDto(answer))
            .map { converter.toEntity(it) }
    }
}