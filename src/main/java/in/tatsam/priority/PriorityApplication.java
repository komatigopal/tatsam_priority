package in.tatsam.priority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.tatsam.priority.initializer.Initializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class PriorityApplication implements CommandLineRunner {
	@Autowired
	private Initializer initializer;

	public static void main(String[] args) {
		SpringApplication.run(PriorityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		initializer.init();
	}
}
