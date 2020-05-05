package edu.csub.model

import javax.persistence.*

@Entity
data class Customer(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long = 0, @Embedded var name: Name = Name(),
                    @Embedded var address: Address = Address(), var email: String = "") {

    @OneToMany(mappedBy = "customer")
    val projects = mutableSetOf<Project>()
}