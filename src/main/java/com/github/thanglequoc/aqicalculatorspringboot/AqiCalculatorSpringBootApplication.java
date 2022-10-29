package com.github.thanglequoc.aqicalculatorspringboot;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AqiCalculatorSpringBootApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(AqiCalculatorSpringBootApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(AqiCalculatorSpringBootApplication.class, args);
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("----------------------------------------------------------------\n");
		sb.append(" ^ ^                                        \n" +
				"(O,O)                                       \n" +
				"(   ) The AQI Calculator App is running!    \n" +
				"-\"-\"------------------------------------------------------------\n");
		sb.append("| Less air pollution is the answer to a healthy life solution. |\n" +
				"'--------------------------------------------------------------'");
		sb.append("\n\n");
		sb.append("Author: Thang Le Quoc\n");
		sb.append("Email: thanglequoc.it@gmail.com\n");
		sb.append("App Version: 1.0.0\n");
		sb.append("aqi-calculator dependency version: 1.3.1\n");
		sb.append("Project Homepage: https://github.com/ThangLeQuoc/aqi-calculator-spring\n");
		sb.append("GitHub AQI Calculator Homepage: https://github.com/ThangLeQuoc/aqi-calculator\n");
		LOGGER.info(sb.toString());
	}

	@GetMapping
	public String entryHealthCheck() {
		StringBuilder sb = new StringBuilder();
		sb.append("----------------------------------------------------------------\n");
		sb.append(" ^ ^                                        \n" +
				"(O,O)                                       \n" +
				"(   ) The AQI Calculator App is running!    \n" +
				"-\"-\"------------------------------------------------------------\n");
		sb.append("| Less air pollution is the answer to a healthy life solution. |\n" +
				"'--------------------------------------------------------------'");
		sb.append("\n\n");
		sb.append("Author: Thang Le Quoc\n");
		sb.append("Email: thanglequoc.it@gmail.com\n");
		sb.append("App Version: 1.0.0\n");
		sb.append("aqi-calculator dependency version: 1.3.1\n");
		sb.append("Project Homepage: https://github.com/ThangLeQuoc/aqi-calculator-spring\n");
		sb.append("GitHub AQI Calculator Homepage: https://github.com/ThangLeQuoc/aqi-calculator\n");
		sb.append("\n\n");

		sb.append("*** Calculate regular AQI ***\n");
		sb.append("curl --location --request POST 'http://localhost:8080/aqi-calculator/aqi' \\\n" +
				"--header 'Content-Type: application/json' \\\n" +
				"--data-raw '{\n" +
				"    \"pollutant\": \"PM10\",\n" +
				"    \"concentration\": 155\n" +
				"}'");
		sb.append("\n\n");
		sb.append("*** Calculate Nowcast AQI ***\n");
		sb.append("curl --location --request POST 'http://localhost:8080/aqi-calculator/nowcast-aqi' \\\n" +
				"--header 'Content-Type: application/json' \\\n" +
				"--data-raw '{\n" +
				"    \"pollutant\": \"PM25\",\n" +
				"    \"concentrationsLast12Hours\": [\n" +
				"        64, 63, 72, 77, 65, 61, 70, 71, 64, 57, 58, 64\n" +
				"    ]\n" +
				"}'");
		sb.append("\n\n");
		sb.append("*** Get all available pollutants for calculation ***\n");
		sb.append("curl --location --request GET 'http://localhost:8080/pollutant'");
		return sb.toString();

	}

}
