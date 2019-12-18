package edu.csub.service

import edu.csub.model.Car
import edu.csub.model.Part
import java.math.BigDecimal

interface ShopService {

    fun addCar(car: Car)

    fun removeCar(car: Car)

    fun addPart(part: Part)

    fun removePart(part: Part)

    fun checkout()

    fun getTotal(): BigDecimal
}