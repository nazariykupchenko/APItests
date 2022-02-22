package com.api.models.reqres;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Data {

  @JsonProperty("id")
  private int id;
  @JsonProperty("year")
  private int year;
  @JsonProperty("name")
  private String name;
  @JsonProperty("color")
  private String color;
  @JsonProperty("pantone_value")
  private String pantoneValue;
}
