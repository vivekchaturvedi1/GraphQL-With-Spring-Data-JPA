//package com.example.demo;
//
//import graphql.scalars.ExtendedScalars;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.graphql.execution.RuntimeWiringConfigurer;
//
//@Configuration
//class GraphQlConfig {
//
//    @Bean
//    public RuntimeWiringConfigurer runtimeWiringConfigurer()  {
//        // add alias `AnotherScalar` for `Long`
//        return wiringBuilder -> wiringBuilder.scalar(ExtendedScalars.GraphQLLong);
//    }
//}
//
