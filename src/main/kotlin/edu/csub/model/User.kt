package edu.csub.model

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "users")
data class User(@Id @Column(nullable = false, length = 64) var username: String, var password: String,
                var enabled: Boolean): Serializable {

}