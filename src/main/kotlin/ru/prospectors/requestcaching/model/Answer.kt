package ru.prospectors.requestcaching.model

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Model answer")
data class Answer(
    val id: String,
    val content: String,
)
