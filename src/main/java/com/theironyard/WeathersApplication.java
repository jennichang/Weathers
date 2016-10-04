package com.theironyard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableScheduling
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class WeathersApplication {


	public static void main(String[] args) {
		SpringApplication.run(WeathersApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}
}


//	public static void main(String[] args) {
//		RestTemplate restTemplate = new RestTemplate();
//		Map<String, String> vars = new HashMap<String, String>();
//
//		vars.put("address", "1600 Amphitheatre Parkway, Mountain View, CA");
//		vars.put("sensor", "false");
//		String result = restTemplate
//				.getForObject(
//						"https://maps.googleapis.com/maps/api/directions/json?origin=Toronto&destination=Montreal&key=AIzaSyASODlUfJtSvv-LqhnprK2jcaJ_rbThy9E",
//
//						String.class, vars);
//
//		System.out.println(result);
//	}
//
//}

