package ru.prospectors.requestcaching.redis

import org.redisson.api.RMapCacheReactive
import org.redisson.api.RedissonReactiveClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import ru.prospectors.requestcaching.model.Answer
import ru.prospectors.requestcaching.repository.AnswerRepository
import ru.prospectors.requestcaching.webclient.WebClientRepository
import java.util.concurrent.TimeUnit

@Repository
class AnswerRedisRepository(
    private val client: RedissonReactiveClient,
    private val webClient: WebClientRepository
): AnswerRepository {
    private val answers: RMapCacheReactive<String, Answer> = client.getMapCache("answers")
    @Value("\${app.ttl}")
    private var ttl: Long = 10

    override fun findById(id: String): Mono<Answer?> {
        return answers.get(id)
            .switchIfEmpty(webClient.findById(id).flatMap { answer ->
                if (answer != null) {
                    save(answer)
                } else {
                    Mono.empty()
                }
            })
    }


    override fun save(answer: Answer): Mono<Answer> {
        return answers.fastPut(answer.id, answer, ttl, TimeUnit.MINUTES)
            .thenReturn(answer)
    }

}
