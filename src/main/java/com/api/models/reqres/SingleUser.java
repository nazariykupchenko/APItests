package com.api.models.reqres;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SingleUser {

  @JsonProperty("data")
  private UserData userData;
  @JsonProperty("support")
  private Support support;
}
