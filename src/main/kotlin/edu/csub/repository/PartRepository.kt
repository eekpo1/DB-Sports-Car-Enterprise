package edu.csub.repository

import edu.csub.model.Part
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface PartRepository : JpaRepository<Part, Long> {

    @Modifying
    @Query("UPDATE Part p SET p.stock = p.stock - 1 WHERE p.id = :id")
    fun decrementPart(id: Long)
}