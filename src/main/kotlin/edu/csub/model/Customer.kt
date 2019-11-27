package edu.csub.model

import javax.persistence.Embedded
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

data class Customer(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long = 0, @Embedded var name: Name,
                    @Embedded var address: Address) {
}