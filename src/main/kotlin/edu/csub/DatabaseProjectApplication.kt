package edu.csub

import edu.csub.service.DBCreationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class DatabaseProjectApplication

fun main(args: Array<String>) {
    runApplication<DatabaseProjectApplication>(*args)

}


