package ru.prospectors.requestcaching.repository

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import ru.prospectors.requestcaching.model.dto.AnswerDto

interface AnswerPostgresRepository: ReactiveCrudRepository<AnswerDto, String> {
}