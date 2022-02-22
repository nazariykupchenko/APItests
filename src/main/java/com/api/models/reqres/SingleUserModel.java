package com.api.models.reqres;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SingleUserModel {

  @JsonProperty("id")
  private int id;
  @JsonProperty("email")
  private String email;
  @JsonProperty("first_name")
  private String first_name;
  @JsonProperty("last_name")
  private String last_name;
  @JsonProperty("avatar")
  private String avatar;
}
