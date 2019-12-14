package edu.csub.repository

import edu.csub.model.Customer
import edu.csub.model.Name
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository
import java.awt.print.Pageable

@Repository
@RepositoryRestResource
interface CustomerRepository : JpaRepository<Customer, Long> {
//        fun findByNameLastName(name: String, page: Pageable): Page<Customer>
}