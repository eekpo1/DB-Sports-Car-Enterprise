package edu.csub.repository

import edu.csub.model.Part
import org.springframework.data.jpa.repository.JpaRepository

interface PartRepository : JpaRepository<Part, Long> {
}