package click.thisisjhoel.faulttolerancepattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class FaultTolerancePatternApplication {

    public static void main(String[] args) {
        SpringApplication.run(FaultTolerancePatternApplication.class, args);
    }

}
