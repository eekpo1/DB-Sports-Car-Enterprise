package edu.csub.model

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
data class Project(@Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long = 0,
                   @Enumerated var progress: Progress = Progress.IN_PROGRESS) {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var customer = Customer()

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var car = Car()


}