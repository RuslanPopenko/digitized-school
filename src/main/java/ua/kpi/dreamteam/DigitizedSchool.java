package ua.kpi.dreamteam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DigitizedSchool {

    static final Logger logger = LogManager.getLogger(DigitizedSchool.class.getName());

    public static void main(String[] args) {
        logger.info("entered application");
        SpringApplication.run(DigitizedSchool.class, args);
    }
}
