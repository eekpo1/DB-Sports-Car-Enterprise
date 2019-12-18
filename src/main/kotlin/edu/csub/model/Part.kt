package edu.csub.model

import org.hibernate.validator.constraints.Currency
import java.math.BigDecimal
import javax.persistence.*

@Entity
data class Part(@Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long = 0, var name: String = "", var supplier: String = "",
                @Currency var price: BigDecimal = BigDecimal.ONE, var stock: Int = 0,
                @Currency var labor: BigDecimal = BigDecimal.ONE, var description: String = "", var image: String = "",
                @Enumerated var category: Category = Category.NEITHER) {

}