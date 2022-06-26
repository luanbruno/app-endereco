package br.edu.infnet.appendereco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppEnderecoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppEnderecoApplication.class, args);
	}

}
