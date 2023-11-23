package ru.prospectors.requestcaching.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*
import ru.prospectors.requestcaching.model.Answer
import ru.prospectors.requestcaching.service.AnswerService

@RestController
@RequestMapping("/answer")
@Tag(name = "Answer Controller", description = "Methods for working with data")
class AnswerController(
    private val answerService: AnswerService,
) {
    @GetMapping("{id}")
    @Operation(summary = "Find answer")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request format")
    @ApiResponse(responseCode = "500", description = "Server error")
    fun findById(@PathVariable id: String) = answerService.findById(id)

    @PostMapping
    @Operation(summary = "Save answer")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request format")
    @ApiResponse(responseCode = "500", description = "Server error")
    fun addAnswer(@RequestBody answer: Answer) = answerService.addAnswer(answer)
}