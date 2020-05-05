package edu.csub.service

import edu.csub.model.Employee
import edu.csub.model.Role
import edu.csub.model.User
import edu.csub.repository.DepartmentRepository
import edu.csub.repository.EmployeeRepository
import edu.csub.repository.RoleRepository
import edu.csub.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service(value = "employee")
@Transactional
class EmployeeCreationService : UserCreationService {

    @Autowired
    lateinit var userRepository: UserRepository
    @Autowired
    lateinit var roleRepository: RoleRepository
    @Autowired
    lateinit var employeeRepository: EmployeeRepository
    var passwordEncoder: PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
    @Autowired lateinit var departmentRepository: DepartmentRepository


    override fun create(user: Any, password: String) {
        val employee = user as Employee
        employeeRepository.save(employee)
        userRepository.save(User(username = employee.email, password = passwordEncoder.encode(password), enabled = true))
        roleRepository.save(Role(username = employee.email, authority = "ROLE_EMPLOYEE"))
    }
}