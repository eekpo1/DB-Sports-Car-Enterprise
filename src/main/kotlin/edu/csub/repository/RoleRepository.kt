package edu.csub.repository

import edu.csub.model.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository


@Repository
@RepositoryRestResource
interface RoleRepository : JpaRepository<Role, Long> {

}