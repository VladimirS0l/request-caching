package ru.prospectors.requestcaching

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RequestCachingApplication

fun main(args: Array<String>) {
    runApplication<RequestCachingApplication>(*args)
}
