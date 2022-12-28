package ru.ukrainskiy.rnd.chatter3.chatter3.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "ru.ukrainskiy.rnd.chatter3.chatter3" })
@EntityScan(basePackages = { "ru.ukrainskiy.rnd.chatter3.chatter3.model" })
@ComponentScan(basePackages = {"ru.ukrainskiy.rnd.chatter3.chatter3"})
public class JpaConfiguration {
    
}
