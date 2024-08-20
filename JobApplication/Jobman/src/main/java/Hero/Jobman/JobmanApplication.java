package Hero.Jobman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class JobmanApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobmanApplication.class, args);
    }

}
