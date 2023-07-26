package com.hendisantika.springbootthymeleafpostgres;

import com.hendisantika.springbootthymeleafpostgres.controller.StudentController;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.logging.Logger;

@SpringBootApplication
public class SpringbootThymeleafPostgresApplication implements ServletContextListener {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootThymeleafPostgresApplication.class, args);
    }

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(StudentController.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOGGER.info("Application started");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOGGER.info("Application stopped");
    }

}
