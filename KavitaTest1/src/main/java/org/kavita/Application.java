package org.kavita;
import org.kavita.controller.WheatherReportController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.retry.annotation.EnableRetry;

@ComponentScan({
		"org.kavita.controller"})
@EnableRetry
@EnableAutoConfiguration
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	ApplicationContext applicationContext;

	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	WheatherReportController controller =	applicationContext.getBean(WheatherReportController.class);
	controller.getwheatherreport("t");

	}
}