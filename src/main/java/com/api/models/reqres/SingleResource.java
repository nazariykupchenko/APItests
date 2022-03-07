package com.api.models.reqres;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class SingleResource {

  @JsonProperty("data")
  private ResourceData resourceData;
  @JsonProperty("support")
  private Support support;
}
