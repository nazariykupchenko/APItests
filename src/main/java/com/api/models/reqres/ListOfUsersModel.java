package com.api.models.reqres;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ListOfUsersModel {
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
  @JsonProperty("email")
  private String email;
  @JsonProperty("first_name")
  private String first_name;
  @JsonProperty("last_name")
  private String last_name;
  @JsonProperty("avatar")
  private String avatar;
  @JsonProperty("url")
  private String url;
  @JsonProperty("text")
  private String text;
}
