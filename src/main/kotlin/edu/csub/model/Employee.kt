package edu.csub.model

import javax.persistence.*

@Entity
data class Employee(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long = 0,
                    @Embedded var name: Name, @Embedded var address: Address, var email: String)
