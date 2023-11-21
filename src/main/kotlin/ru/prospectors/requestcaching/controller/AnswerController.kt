package ru.prospectors.requestcaching.controller

import org.springframework.web.bind.annotation.*
import ru.prospectors.requestcaching.model.Answer
import ru.prospectors.requestcaching.service.AnswerService

@RestController
@RequestMapping("answer")
class AnswerController(
    private val answerService: AnswerService
) {
    @GetMapping("{id}")
    fun findById(@PathVariable id: String) = answerService.findById(id)

    @PostMapping
    fun addAnswer(@RequestBody answer: Answer) = answerService.addAnswer(answer)
}