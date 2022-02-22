package com.api.models.reqres;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class UpdateUserRequest {

  @JsonProperty("name")
  private String name;
  @JsonProperty("job")
  private String job;
}