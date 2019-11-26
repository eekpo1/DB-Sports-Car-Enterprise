package edu.csub.model

import javax.persistence.Embeddable

@Embeddable
data class Address(var streetAddress: String, var city: String, var state: String, var zip: String)
