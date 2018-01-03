package i5b5.mwsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by daniel on 05.11.17.
 */
@SpringBootApplication
@ComponentScan("i5b5.mwsi")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}
