package edu.csub.service

import edu.csub.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DBCreationService {
    @Autowired lateinit var carRepository: CarRepository
    @Autowired lateinit var departmentRepository: DepartmentRepository
    @Autowired lateinit var customerRepository: CustomerRepository
    @Autowired lateinit var partRepository: PartRepository
    @Autowired lateinit var userRepository: PartRepository
    @Autowired lateinit var roleRepository: RoleRepository
    @Autowired lateinit var projectRepository: ProjectRepository


}