package ua.kpi.dreamteam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ResourceLoader;
import ua.kpi.dreamteam.utils.StaticUtls;

import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
public class DigitizedSchool {

    private static ResourceLoader resourceLoader;

    static final Logger logger = LogManager.getLogger(DigitizedSchool.class.getName());

    @Autowired
    public DigitizedSchool(ResourceLoader resourceLoader) {
        DigitizedSchool.resourceLoader = resourceLoader;
    }

    public static void main(String[] args) throws IOException {
        logger.info("entered application");
        SpringApplication.run(DigitizedSchool.class, args);
        Properties gitProperties = new Properties();
        gitProperties.load(resourceLoader.getResource("classpath:git.gitProperties").getInputStream());
        logger.info("Git describe: " + StaticUtls.deleteSuffixOptional(gitProperties.getProperty("git.commit.id.describe"), "-dirty"));
    }
}
