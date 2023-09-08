package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class Auth0Service {

	@Value("${auth0.domain}")
	private String domain;

	@Value("${auth0.clientId}")
	private String clientId;

	@Autowired
	private RestTemplate restTemplate;

	public void registerUser(String email, String password) {
		UserRegistrationRequest userRegistrationRequest = getUserRegistrationRequest(email, password);

		String url = domain + "/dbconnections/signup";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<UserRegistrationRequest> requestEntity = new HttpEntity<>(userRegistrationRequest, headers);

		try {
			ResponseEntity<Object> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Object.class);
			Object response = responseEntity.getBody();
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private UserRegistrationRequest getUserRegistrationRequest(String email, String password) {
		return UserRegistrationRequest.builder()
				.name("Davit Jibuti")
				.clientId(clientId)
				.email(email)
				.password(password)
				.userMetaData(new UserMetaData("true"))
				.connection("Username-Password-Authentication")
				.build();
	}

}
