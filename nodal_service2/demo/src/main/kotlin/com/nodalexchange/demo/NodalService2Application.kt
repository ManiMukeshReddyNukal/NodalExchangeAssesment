package com.nodalexchange.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync


@SpringBootApplication
@EnableAsync
class NodalService2Application

fun main(args: Array<String>) {
	runApplication<NodalService2Application>(*args)
}
