package com.api.models.reqres;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SingleResourceModel {

  @JsonProperty("id")
  private int id;
  @JsonProperty("name")
  private String name;
  @JsonProperty("year")
  private int year;
  @JsonProperty("color")
  private String color;
  @JsonProperty("pantone_value")
  private String pantone_value;
}
