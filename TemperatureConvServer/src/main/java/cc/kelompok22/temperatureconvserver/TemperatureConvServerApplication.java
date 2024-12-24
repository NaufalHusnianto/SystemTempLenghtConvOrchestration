package cc.kelompok22.temperatureconvserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TemperatureConvServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemperatureConvServerApplication.class, args);
	}

}
