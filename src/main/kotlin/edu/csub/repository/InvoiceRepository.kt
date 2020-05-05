package edu.csub.repository

import edu.csub.model.Customer
import edu.csub.model.Invoice
import org.springframework.data.jpa.repository.JpaRepository

interface InvoiceRepository : JpaRepository<Invoice, Long> {
    fun findInvoicesByCustomerId(customer: Long): List<Invoice>
//    fun findByCustomerNameFirstName(firstName: String): List<Customer>
}