package edu.csub.model

import org.hibernate.validator.constraints.Currency
import java.math.BigDecimal
import java.util.stream.Collectors
import javax.persistence.*
import kotlin.streams.asSequence

@Entity
data class Invoice(@Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long = 0, @Currency var total: BigDecimal = BigDecimal.ONE) {

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = true)
    val customer = Customer()

    @OneToMany
    val parts = mutableListOf<Part>()

    @OneToOne
    var project = Project()

    @PrePersist
    fun setTotal() {
        total = parts.stream().asSequence().map { it -> it.price + it.labor }.fold(BigDecimal.ZERO, BigDecimal::add)
    }

}