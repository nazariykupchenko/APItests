package com.api.models.reqres;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ListOfResourcesModel {

  @JsonProperty("page")
  private int page;
  @JsonProperty("per_page")
  private int per_page;
  @JsonProperty("total")
  private int total;
  @JsonProperty("total_pages")
  private int total_pages;
  @JsonProperty("id")
  private int id;
  @JsonProperty("year")
  private int year;
  @JsonProperty("name")
  private String name;
  @JsonProperty("color")
  private String color;
  @JsonProperty("pantone_value")
  private String pantone_value;
  @JsonProperty("url")
  private String url;
  @JsonProperty("text")
  private String text;


}
