package edu.csub.repository

import edu.csub.model.Customer
import edu.csub.model.Name
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import java.awt.print.Pageable

interface CustomerRepository : JpaRepository<Customer, Long> {
        fun findByNameLastName(name: String): Page<Customer>
}