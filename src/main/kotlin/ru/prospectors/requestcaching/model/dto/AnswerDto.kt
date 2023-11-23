package ru.prospectors.requestcaching.model.dto

import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Schema(description = "Model answer")
@Table(name = "answer")
data class AnswerDto(
    @Id @Column("id") val id: Long?,
    @Column("url") var url: String,
    @Column("content") val content: String,
)
