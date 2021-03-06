package it.unibo.parkmanagerservice.gui

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping

@Controller
class BaseController {
    @Value("\${spring.application.name}")
    var appName: String? = null
    @GetMapping("/")
    fun homePage(model: Model): String {
        println("------------------- BaseController homePage $model")
        model.addAttribute("arg", appName)
        return "welcome"
    }

    @GetMapping("/ClientGUIParkIn")
    fun ClientGUIParkIn(model: Model): String {
        println("------------------- BaseController homePage $model")
        model.addAttribute("arg", appName)
        return "ClientGUIParkIn"
    }

    @ExceptionHandler
    fun handle(ex: Exception): ResponseEntity<*> {
        val responseHeaders = HttpHeaders()
        return ResponseEntity(
            "BaseController ERROR ${ex.message}",
            responseHeaders, HttpStatus.CREATED
        )
    }
}