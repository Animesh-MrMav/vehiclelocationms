package com.trainingapps.emergencyvehicleapp.vehiclelocationms;

import com.trainingapps.emergencyvehicleapp.vehiclelocationms.frontend.FrontEnd;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Configuration
 * @ComponentScan
 * @EnableAutoConfiguration
 * the First File to be run or the main file of the project for gradlew bootRun command.
 *
 */
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(DemoApplication.class, args);
		FrontEnd frontEnd=context.getBean(FrontEnd.class);
		frontEnd.runUI();

	}


}
