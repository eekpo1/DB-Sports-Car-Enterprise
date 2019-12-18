package edu.csub.service

import edu.csub.model.Car
import edu.csub.model.Part
import edu.csub.repository.CarRepository
import edu.csub.repository.PartRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal
import kotlin.streams.asSequence
import kotlin.streams.toList

@Service
class ShopServiceImpl : ShopService {

    @Autowired lateinit var cars: CarRepository
    @Autowired lateinit var parts: PartRepository

    private val itemList = mutableListOf<Any>()

    override fun addCar(car: Car) {
        itemList.add(car)
    }

    override fun removeCar(car: Car) {
        for (i in itemList) {
            if (i is Part && i.id == car.id)
                itemList.remove(i)
        }
    }

    override fun addPart(part: Part) {
        itemList.add(part)
    }

    override fun removePart(part: Part) {
        for (i in itemList) {
            if (i is Part && i.id == part.id)
                itemList.remove(i)
        }
    }

    override fun checkout() {
       itemList.stream().filter { it is Part }
                .map { it as Part }.map(Part::id).forEach(parts::decrementPart)
    }

    override fun getTotal(): BigDecimal {
        val big = BigDecimal.ZERO
        for (i in itemList) {
            if (i is Car)
                big.add(i.price)

            if (i is Part)
                big.add(i.labor).add(i.price)
        }
        return big
    }
}