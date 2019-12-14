package edu.csub.repository

import edu.csub.model.Department
import edu.csub.model.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository
import java.awt.print.Pageable

@RepositoryRestResource
@Repository
interface DepartmentRepository : JpaRepository<Department, Long> {
//    fun findDepartmentByHead(employee: Employee, page: Pageable): Department
}