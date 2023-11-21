package ru.prospectors.requestcaching.service

import reactor.core.publisher.Mono
import ru.prospectors.requestcaching.model.Answer

interface AnswerService {
    fun findById(id: String): Mono<Answer?>
    fun addAnswer(answer: Answer): Mono<Answer>
}