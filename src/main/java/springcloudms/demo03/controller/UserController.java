package springcloudms.demo03.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import jakarta.websocket.ClientEndpoint;

@RestController
public class UserController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient client;
	
	@GetMapping(value="/user/ok")
	public String testUser() {
		return "User OK";
	}
	
	@GetMapping(value="/user")
	public String invokeGreetingService() {
	    System.out.println("All services from Consul: " + client.getServices());

	    URI serviceUri = client.getInstances("greetingServiceMS")
	            .stream()
	            .map(si -> si.getUri())
	            .findFirst()
	            .map(s -> s.resolve("/greeting"))
	            .orElseThrow(() -> new RuntimeException("greetingServiceMS not found in Consul"));
	    System.out.println("Servcie URL:"+serviceUri);
//	    return restTemplate.getForObject("http://localhost:8181/greeting", String.class);
	    return restTemplate.getForObject(serviceUri, String.class);
	}
	
}
