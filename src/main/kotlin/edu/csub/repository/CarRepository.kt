package edu.csub.repository

import edu.csub.model.Car
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.stereotype.Repository

@Repository
@RepositoryRestResource
interface CarRepository : JpaRepository<Car, Long>{
    fun findAllByMake(make: String): List<Car>

    fun findByModelIgnoreCase(model: String): List<Car>
}