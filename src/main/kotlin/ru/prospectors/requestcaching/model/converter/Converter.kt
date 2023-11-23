package ru.prospectors.requestcaching.model.converter

import org.springframework.stereotype.Component
import ru.prospectors.requestcaching.model.Answer
import ru.prospectors.requestcaching.model.dto.AnswerDto

@Component
class Converter {
    fun toDto(answer: Answer): AnswerDto {
        return AnswerDto(null, answer.id, answer.content)
    }

    fun toEntity(answerDto: AnswerDto): Answer {
        return Answer(answerDto.url, answerDto.content)
    }
}