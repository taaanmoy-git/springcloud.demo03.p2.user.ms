package springcloudms.demo03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class Demo3P2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo3P2Application.class, args);
	}
	
	// RestTemplate bean configuration
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
