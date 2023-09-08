package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRegistrationRequest {
	private String name;
	private String email;
	private String clientId;
	private String password;
	private String connection;
	@JsonProperty("user_metadata")
	private UserMetaData userMetaData;
}
