package com.example.springcoredojo.Entidades;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;

@Configuration
@ComponentScan(basePackageClasses = Usuario.class)
public class Config {

    @Bean
    public Alumno getAlumno()
    {
        return  new Alumno( "Leslie", "Aguilera", 22);
    }
}
