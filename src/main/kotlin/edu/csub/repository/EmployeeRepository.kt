package edu.csub.repository

import edu.csub.model.Employee
import edu.csub.model.Name
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository

@Repository
@RepositoryRestResource
interface EmployeeRepository : JpaRepository<Employee, Long> {

    // Query DSL
    /*
     * SELECT employee.id FROM Employee WHERE firstName = ? AND lastName = ?
     */
    fun findByNameEquals(name: Name): Long

    fun findAllByDepartmentName(deptName: String): List<Employee>
}