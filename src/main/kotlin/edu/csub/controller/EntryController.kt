package edu.csub.controller

import edu.csub.repository.CarRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
class EntryController {

    @Autowired lateinit var cars: CarRepository

    @RequestMapping("/login")
    fun login(): String {
        return "login"
    }

    @GetMapping("/home", "/")
    fun home(model: Model): String {
        model.addAttribute("lancer", cars.findByModelIgnoreCase("lancer"))
        model.addAttribute("supra", cars.findByModelIgnoreCase("supra"))
        model.addAttribute("86", cars.findByModelIgnoreCase("86"))
        return "home"
    }

    @RequestMapping
    fun logout(request: HttpServletRequest, response: HttpServletResponse): String {
        val session = request.session
        val auth = SecurityContextHolder.getContext().authentication
        if (auth == null) {
            session.invalidate()
            for (x in request.cookies) x.maxAge = 0
            SecurityContextLogoutHandler().logout(request, response, auth)
        }
        return "redirect:/home"
    }
}