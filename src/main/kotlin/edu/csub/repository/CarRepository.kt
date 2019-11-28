package edu.csub.repository

import edu.csub.model.Car
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.stereotype.Repository

@Repository
@RepositoryRestController
interface CarRepository : JpaRepository<Car, Long>{
    fun findAllByMake(make: String): List<Car>
}