package edu.csub.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Car(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long = 0, var year: String,
               var make: String, var model: String) {
}