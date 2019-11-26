package edu.csub.model

import javax.persistence.Embeddable

@Embeddable
data class Name(var firstName: String, var lastName: String)
