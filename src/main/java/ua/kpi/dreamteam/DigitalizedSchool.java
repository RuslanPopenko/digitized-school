package ua.kpi.dreamteam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DigitalizedSchool {

    static final Logger logger = LogManager.getLogger(DigitalizedSchool.class.getName());

    public static void main(String[] args) {
        logger.info("entered application");
        SpringApplication.run(DigitalizedSchool.class, args);
    }
}
