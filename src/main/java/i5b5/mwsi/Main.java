package i5b5.mwsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by daniel on 05.11.17.
 */
@SpringBootApplication
@ComponentScan("i5b5.mwsi.controllers")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}
