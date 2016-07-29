package pt.jmfgameiro.restservices;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan( basePackages = "pt.jmfgameiro.restservices" )
public class RestServicesSpringConfig {}
