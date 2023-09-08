package pe.edu.tecsup.duenioapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DuenioApiRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DuenioApiRestApplication.class, args);
    }

}
