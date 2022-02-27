package com.ozanaydogan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
        (exclude =
                {
                        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
                        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
                }
        )
public class OzanAydoganSpringBootcampBitirmeProjesiApplication {

    public static void main(String[] args) {
        SpringApplication.run(OzanAydoganSpringBootcampBitirmeProjesiApplication.class, args);
    }

}
