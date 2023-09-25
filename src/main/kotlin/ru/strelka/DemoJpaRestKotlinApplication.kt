package ru.strelka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoJpaRestKotlinApplication

fun main(args: Array<String>) {
	runApplication<DemoJpaRestKotlinApplication>(*args)
}
