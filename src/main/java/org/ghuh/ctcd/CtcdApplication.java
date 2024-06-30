package org.ghuh.ctcd;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;

@SpringBootApplication
public class CtcdApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		/*System.setProperty("CITY_API_PORT", dotenv.get("CITY_API_PORT"));
		System.setProperty("CITY_API_DB_URL", dotenv.get("CITY_API_DB_URL"));
		System.setProperty("CITY_API_DB_USER", dotenv.get("CITY_API_DB_USER"));
		System.setProperty("CITY_API_DB_PWD", dotenv.get("CITY_API_DB_PWD"));
		System.setProperty("CITY_API_ADDR", dotenv.get("CITY_API_ADDR"));*/
		SpringApplication.run(CtcdApplication.class, args);
	}

}
