package com.api.models.appsloveworld;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginUserRequest {

  @JsonProperty("email")
  private String email;
  @JsonProperty("password")
  private int password;

}