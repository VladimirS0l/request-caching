package ru.prospectors.requestcaching.repository

import reactor.core.publisher.Mono
import ru.prospectors.requestcaching.model.Answer

interface AnswerRepository {
    fun findById(id: String): Mono<Answer?>
    fun save(answer: Answer): Mono<Answer>
}
