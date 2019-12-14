package edu.csub.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import javax.sql.DataSource

@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    val encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()

    @Autowired
    lateinit var dataSource: DataSource


    @Autowired
    fun configureGlobal(authenticationManagerBuilder: AuthenticationManagerBuilder) {
        val test: UserDetails = User.builder()
                .username("admin")
//                .password(encoder.encode("password"))
                .password("password")
                .roles("ADMIN", "SALES", "CUSTOMER")
                .build()

        authenticationManagerBuilder.jdbcAuthentication().dataSource(dataSource).passwordEncoder(encoder)
                .withUser(test)
    }

    override fun configure(http: HttpSecurity?) {

        http!!.csrf().disable()
        http.authorizeRequests().mvcMatchers("/home", "/", "/login").permitAll()
                .and().authorizeRequests().mvcMatchers().authenticated()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/home")
    }

    override fun configure(web: WebSecurity?) {
        web!!.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**")
    }
}