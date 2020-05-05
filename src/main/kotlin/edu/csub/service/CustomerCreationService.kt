package edu.csub.service

import edu.csub.model.Customer
import edu.csub.model.Role
import edu.csub.model.User
import edu.csub.repository.CustomerRepository
import edu.csub.repository.RoleRepository
import edu.csub.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service(value = "customer")
@Transactional
class CustomerCreationService: UserCreationService {

    @Autowired lateinit var customerRepository: CustomerRepository
    @Autowired lateinit var roleRepository: RoleRepository
    @Autowired lateinit var userRepository: UserRepository
    var passwordEncoder: PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()

    override fun create(user: Any, password: String) {
        val customer = user as Customer
        customerRepository.save(customer)
        userRepository.save(User(username = customer.email, password = passwordEncoder.encode(password), enabled = true))
        roleRepository.save(Role(username = customer.email, authority = "ROLE_CUSTOMER"))

    }
}