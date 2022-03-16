package com.api.models.reqres;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CreateUserResponse {

  @JsonProperty("id")
  private int id;
  @JsonProperty("name")
  private String name;
  @JsonProperty("job")
  private String job;
  @JsonProperty("createAt")
  private String createAt;
}
