package ru.prospectors.requestcaching.webclient

import org.springframework.stereotype.Repository
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import ru.prospectors.requestcaching.model.Answer
import ru.prospectors.requestcaching.repository.AnswerRepository

@Repository
class WebClientRepository(
    private val client: WebClient = WebClient.create("http://localhost:8070/answer/qiwi")
): AnswerRepository {
    override fun findById(id: String): Mono<Answer?> {
        return client
            .get()
            .uri("/$id")
            .retrieve()
            .bodyToMono(Answer::class.java)
    }

    override fun save(answer: Answer): Mono<Answer> {
        return client.post()
            .uri("")
            .body(Mono.just<Any>(answer), Answer::class.java)
            .retrieve()
            .bodyToMono(Answer::class.java)
    }
}