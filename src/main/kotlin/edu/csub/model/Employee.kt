package edu.csub.model

import java.io.Serializable
import javax.persistence.*

@Entity
data class Employee(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long = 0,
                    @Embedded var name: Name = Name(), @Embedded var address: Address = Address(), var email: String = "") : Serializable {


    @ManyToOne
    @JoinColumn(name = "department", nullable = false)
    var department: Department = Department()




}
