package edu.csub.controller

import edu.csub.model.Address
import edu.csub.model.Customer
import edu.csub.model.Employee
import edu.csub.model.Name
import edu.csub.repository.CarRepository
import edu.csub.service.CustomerCreationService
import edu.csub.service.EmployeeCreationService
import edu.csub.service.UserCreationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.validation.Valid

@Controller
class EntryController {

    @Autowired @Qualifier("customer") lateinit var customerCreationService: UserCreationService
    @Autowired @Qualifier("employee") lateinit var employeeCreationService: UserCreationService
    @Autowired lateinit var cars: CarRepository

    @RequestMapping("/login")
    fun login(): String {
        return "login"
    }

    @GetMapping("/home", "/")
    fun home(@Valid model: Model): String {
        model.addAttribute("lancer", cars.findByModelIgnoreCase("lancer"))
        model.addAttribute("supra", cars.findByModelIgnoreCase("supra"))
        model.addAttribute("eightsix", cars.findByModelIgnoreCase("86"))
        return "home"
    }

    @GetMapping("/register")
    fun register(): String {
        return "register"
    }


    @PostMapping("/register")
    fun registrationComplete(@Valid name: Name, @Valid address: Address, @Valid password: String, @Valid email: String): String {
        val emp = Employee(0, name, address, email)
        employeeCreationService.create(emp, password)
        return "login"
    }

    @PostMapping("/registerEmployee")
    fun regEMp(@Valid name: Name, @Valid address: Address, @Valid password: String, @Valid email: String): String {
        customerCreationService.create(Customer(0, name, address, email), password)
        return "login"
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