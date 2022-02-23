package com.api.models.reqres;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SingleResource {

  @JsonProperty("data")
  private ResourceData resourceData;
  @JsonProperty("support")
  private Support support;
}
