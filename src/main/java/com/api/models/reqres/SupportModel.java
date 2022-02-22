package com.api.models.reqres;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SupportModel {

  @JsonProperty("url")
  private String url;
  @JsonProperty("text")
  private String text;
}
