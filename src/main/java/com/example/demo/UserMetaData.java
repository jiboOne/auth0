package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserMetaData {
	@JsonProperty("registering_from_backend")
	private String registeringFromBackend;
}
