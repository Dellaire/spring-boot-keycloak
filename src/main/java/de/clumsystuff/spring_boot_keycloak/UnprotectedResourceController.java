package de.clumsystuff.spring_boot_keycloak;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unprotected")
public class UnprotectedResourceController {
	
	@GetMapping
	public String getResource() {
		
		return "This is not protected.";
	}
}
