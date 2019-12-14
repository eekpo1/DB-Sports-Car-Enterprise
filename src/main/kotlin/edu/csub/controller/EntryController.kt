package edu.csub.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class EntryController {

    @RequestMapping("/login")
    fun login(): String {
        return "login"
    }

    @GetMapping("/home", "/")
    fun home(): String = "home"
}