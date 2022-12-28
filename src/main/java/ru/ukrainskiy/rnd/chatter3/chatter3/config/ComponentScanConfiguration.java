package ru.ukrainskiy.rnd.chatter3.chatter3.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ru.ukrainskiy.rnd.chatter3.chatter3.Chatter3Application;

@Configuration
@ComponentScan(basePackageClasses = {Chatter3Application.class, WebConfiguration.class})
public class ComponentScanConfiguration {
    
}
