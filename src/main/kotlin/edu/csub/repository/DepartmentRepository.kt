package edu.csub.repository

import edu.csub.model.Department
import edu.csub.model.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface DepartmentRepository : JpaRepository<Department, Long> {
    fun findDepartmentByHead(employee: Employee): Department
}