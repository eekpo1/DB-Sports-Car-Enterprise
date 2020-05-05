package edu.csub.controller

import edu.csub.repository.CarRepository
import edu.csub.service.ShopService
import edu.csub.service.ShopServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.servlet.ModelAndView

@Controller
class PartController {

    @Autowired lateinit var shopService: ShopServiceImpl
    @Autowired lateinit var carRepository: CarRepository

    @GetMapping("/orders/car/{id}")
    fun purchaseCar(@PathVariable id: Long): ModelAndView {
        carRepository.findById(id).ifPresent(shopService::addCar)
        return orders()
    }

    @GetMapping("/orders")
    fun orders(): ModelAndView {
        var modelAndView = ModelAndView("/orders")
        modelAndView.addObject("items", shopService.itemList)
        modelAndView.addObject("total", shopService.getTotal())
        return modelAndView
    }

    @GetMapping("/orders/checkout")
    fun checkout(): String {

        return "invoice"
    }


}