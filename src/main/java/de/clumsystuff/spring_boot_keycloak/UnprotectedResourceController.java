package de.clumsystuff.spring_boot_keycloak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/unprotected")
public class UnprotectedResourceController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping
	public String getResource() {

		return "This is not protected.";
	}

	@GetMapping(params = { "secure" })
	public String getResource(@RequestParam Boolean secure) {
		
		return this.restTemplate.exchange("http://localhost:8081/protected", HttpMethod.GET, null, String.class).getBody();
	}
}
