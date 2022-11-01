package com.example.doctorcenterapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.example.doctorcenterapp")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AspectConfig {
}
