package it.unibo.parkmanagerservice.gui

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GuiApplication

fun main(args: Array<String>) {
	runApplication<GuiApplication>(*args)
}
