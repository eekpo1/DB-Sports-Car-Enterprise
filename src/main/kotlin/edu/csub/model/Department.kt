package edu.csub.model

import javax.persistence.*

data class Department(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var departmentId: Long, var name: String,
                      var head: Employee, var amount: Int = 1) {

    @OneToMany(mappedBy = "department")
    @JoinColumn(name = "employee_id")
    var members: MutableSet<Employee> = mutableSetOf()

    init {
        members.add(head)
    }
}