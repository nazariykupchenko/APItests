package com.api.models.reqres;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResourceData {

  @JsonProperty("id")
  private int id;
  @JsonProperty("name")
  private String name;
  @JsonProperty("year")
  private int year;
  @JsonProperty("color")
  private String color;
  @JsonProperty("pantone_value")
  private String pantoneValue;
}
