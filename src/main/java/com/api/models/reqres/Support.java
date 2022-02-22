package com.api.models.reqres;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Support {

  @JsonProperty("url")
  private String url;
  @JsonProperty("text")
  private String text;
}
