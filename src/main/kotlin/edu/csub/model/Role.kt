package edu.csub.model

import java.io.Serializable
import javax.persistence.*


@Entity
@Table(name = "authorities")
data class Role(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long = 0,
                @Column(insertable = true, updatable = true) var username: String, var authority: String = "") : Serializable {

}