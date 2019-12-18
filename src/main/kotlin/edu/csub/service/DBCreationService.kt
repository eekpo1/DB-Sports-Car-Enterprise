package edu.csub.service

import edu.csub.model.*
import edu.csub.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.annotation.Bean
import org.springframework.context.event.EventListener
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Component
class DBCreationService {
    @Autowired
    lateinit var carRepository: CarRepository
    @Autowired
    lateinit var departmentRepository: DepartmentRepository
    @Autowired
    lateinit var customerRepository: CustomerRepository
    @Autowired
    lateinit var partRepository: PartRepository
    @Autowired
    lateinit var userRepository: UserRepository
    @Autowired
    lateinit var roleRepository: RoleRepository
    @Autowired
    lateinit var projectRepository: ProjectRepository
    @Autowired
    lateinit var encoder: PasswordEncoder
    @Autowired lateinit var employeeRepository: EmployeeRepository

    @Bean
    fun getPasswordEncoder() : PasswordEncoder {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder()
    }

//    @EventListener
    fun createIn(event: ApplicationReadyEvent) {
        createAll()
    }

    private fun createAll() {
        // Cars
        val eightSix = Car(year = "2018", make = "toyota", model = "86", price = BigDecimal("25760.99"))
        val evo = Car(year = "2017", make = "mitsubishi", model = "lancer", price = BigDecimal("24350.99"))
        val supra = Car(year = "2019", make = "toyota", model = "supra", price = BigDecimal("45643.75"))

        // Parts
        // Exterior
        val cpBumper = Part(name = "CP Bumper", price = BigDecimal(297.99), stock = 3, labor = BigDecimal(250.00),
                description = "CP Bumper With Custom Logo ", category = Category.EXTERIOR,
                image = "images/pr2images/exterior/cpbumper.jpg")

        val cpHeadlights = Part(name = "CP Headlights", price = BigDecimal(219.99), stock = 5, labor = BigDecimal(150.00),
                description = "Hybrid LED Halogen HeadLights", category = Category.EXTERIOR,
                image = "images/pr2images/exterior/cpheadlights.jpg")

        val cpHood = Part(name = "cp Hood", price = BigDecimal(819.99), stock = 5, labor = BigDecimal(200.00),
                description = "Customized Hood - All Cars Applicable", category = Category.EXTERIOR,
                image = "images/pr2images/exterior/cphood.jpg")

        val lamboDoor1 = Part(name = "Lamborghini Doors", price = BigDecimal(1780.99), stock = 2, labor = BigDecimal(700.00),
                description = "Luxury Lamborghini Doors", category = Category.EXTERIOR,
                image = "images/pr2images/exterior/lambodoor1.webp")
        val suicideDoor = Part(name = "Suicide Doors", price = BigDecimal(819.99), stock = 5, labor = BigDecimal(200.00),
                description = "Luxury Suicide Doors", category = Category.EXTERIOR,
                image = "images/pr2images/exterior/suicidedoor.jpg")



        // Interior
        val jlamplifier = Part(name = "JL Amplifier", price = BigDecimal(178.99), stock = 7, labor = BigDecimal(100.00),
                description = "JL Audio Amplifier 500 Watts RMS X 1 at 2 Ohms ", category = Category.INTERIOR,
                image = "")
        val jlBassPackage = Part(name = "JL Bass Package", price = BigDecimal(589.99), stock = 5, labor = BigDecimal(150.00),
                description = "JL Bass Package 500 Watts RMS X 1 at 2 Ohms ", category = Category.INTERIOR, image = "")
        val jl12Subwoofer = Part(name = "JL 12\" Subwoofer", price = BigDecimal(589.99), stock = 5, labor = BigDecimal(50.00),
                description = "JL Bass Package 500 Watts RMS X 1 at 2 Ohms ", category = Category.INTERIOR, image = "")
        val cpStereo = Part(name = "Dashboard Stereo", price = BigDecimal(250.99), stock = 5, labor = BigDecimal(150.00),
                description = "Digital Setero ", category = Category.INTERIOR,
                image = "images/pr2images/interior/cpstereo.jpg")
        val raceSeat1 = Part(name = "Black n Yellow Race Seats", price = BigDecimal(400.99), stock = 5, labor = BigDecimal(150.00),
        description = "Track Ready", category = Category.INTERIOR,
        image = "images/pr2images/interior/raceseat1.jpg")
        val raceSeat2 = Part(name = "White Race Seats", price = BigDecimal(400.99), stock = 5, labor = BigDecimal(150.00),
                description = "Track Ready", category = Category.INTERIOR,
                image = "images/pr2images/interior/raceseat2.jpg")

        // Performance
        val cpExhaust = Part(name = "CP Exhaust", price = BigDecimal(500.00), stock = 3, labor = BigDecimal(300.00),
                description = "Customized DB Enterprise Exhaust", category = Category.PERFORMANCE,
                image = "images/pr2images/performance/cpexhaust.jpg")
        val cpIntake = Part(name = "CP Intake", price = BigDecimal(500.00), stock = 3, labor = BigDecimal(300.00),
                description = "Customized DB Enterprise Intake", category = Category.PERFORMANCE,
                image = "images/pr2images/performance/cpintake.jpg")
        val stage1 = Part(name = "Stage 1 Turbo", price = BigDecimal(1900.00), stock = 3, labor = BigDecimal(700.00),
                description = "For Those With The Need For Speed..", category = Category.PERFORMANCE,
                image = "images/pr2images/performance/stage1.jpg")
        val stage2 = Part(name = "Stage 2 Turbo", price = BigDecimal(1900.00), stock = 3, labor = BigDecimal(700.00),
                description = "For Those With The Need For Speed.. and then some", category = Category.PERFORMANCE,
                image = "images/pr2images/performance/stage2.jpg")
        val twinTurbo = Part(name = "Twin Turbo", price = BigDecimal(3800.00), stock = 3, labor = BigDecimal(1400.00),
                description = "Barely Street Legal", category = Category.PERFORMANCE,
                image = "images/pr2images/performance/twinturbo.jpg")

        val carList = mutableListOf<Car>(eightSix, supra, evo)
        val partList = mutableListOf<Part>(cpBumper, cpHeadlights, jlamplifier, jl12Subwoofer, jlBassPackage, cpHood, lamboDoor1, suicideDoor,
                cpIntake, cpExhaust, stage1, stage2, twinTurbo, cpStereo, raceSeat1, raceSeat1)

        carRepository.saveAll(carList)
        partRepository.saveAll(partList)
        addDepartments()
        addEmployees()


    }

    private fun addEmployees() {
        val emp1 = Employee(name = Name("Derek", "Blue"),
                address = Address("123 Poway Lane", "San Diego", "CA", "91234"),
                email = "dgreen@gmal.com")
        emp1.department = departmentRepository.findDepartmentByNameIgnoreCase("service").first()
        employeeRepository.save(emp1)

        val emp2 = Employee(name = Name("Wendy", "Wollrabe"),
                address = Address("124 Poway Lane", "San Diego", "CA", "91234"),
                email = "wwollrabe@gmail.com")
        emp2.department = departmentRepository.findDepartmentByNameIgnoreCase("engineering").first()
        employeeRepository.save(emp2)
        userRepository.save(User(emp1.email, encoder.encode("password"), true))
        userRepository.saveAndFlush(User(emp2.email, encoder.encode("password"), true))
        roleRepository.save(Role(username = emp1.email, authority = "ROLE_EMPLOYEE"))
        roleRepository.saveAndFlush(Role(username = emp2.email, authority = "ROLE_EMPLOYEE"))

    }

    private fun addDepartments() {
        val service = Department(name = "service", head = "Derek Blue")
        val maintenance = Department(name = "engineering", head = "Wendy Wollrabe")
        departmentRepository.save(service)
        departmentRepository.saveAndFlush(maintenance)
    }

}