package com.api.models.reqres;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserData {

  @JsonProperty("id")
  private int id;
  @JsonProperty("email")
  private String email;
  @JsonProperty("first_name")
  private String firstName;
  @JsonProperty("last_name")
  private String lastName;
  @JsonProperty("avatar")
  private String avatar;
}
