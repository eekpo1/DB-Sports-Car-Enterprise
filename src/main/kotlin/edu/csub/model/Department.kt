package edu.csub.model

import java.io.Serializable
import javax.persistence.*

@Entity
data class Department(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var departmentId: Long = 0, var name: String = "",
                      var head: String = "", var amount: Int = 1) : Serializable {

    @OneToMany(mappedBy = "department")
    var members: MutableSet<Employee> = mutableSetOf()


}