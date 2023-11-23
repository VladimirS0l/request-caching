package ru.prospectors.requestcaching.model.dto

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table(name = "answer")
data class AnswerDto(
    @Id @Column("id") val id: Long?,
    @Column("url") var url: String,
    @Column("content") val content: String,
)
