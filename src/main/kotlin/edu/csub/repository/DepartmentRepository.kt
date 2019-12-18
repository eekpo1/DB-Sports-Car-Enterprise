package edu.csub.repository

import edu.csub.model.Department
import edu.csub.model.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository
import java.awt.print.Pageable

@RepositoryRestResource
@Repository
interface DepartmentRepository : JpaRepository<Department, Long> {
    //    fun findDepartmentByHead(employee: Employee, page: Pageable): Department
//    fun findByName(name: String): Department
    fun findDepartmentByNameIgnoreCase(name: String): List<Department>

    @Modifying
    @Query("UPDATE Department d SET d.amount = d.amount + 1 WHERE d.name = :name")
    fun incrementAmount(name: String)

    @Modifying
    @Query("Update Department d SET d.amount = d.amount - 1 WHERE d.name = :name")
    fun decrementAmount(name: String)


}