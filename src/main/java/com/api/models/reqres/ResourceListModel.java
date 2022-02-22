package com.api.models.reqres;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ResourceListModel {

  @JsonProperty("page")
  private int page;
  @JsonProperty("per_page")
  private int per_page;
  @JsonProperty("total")
  private int total;
  @JsonProperty("total_pages")
  private int total_pages;
  @JsonProperty("data")
  DataModel[] dataList;
  @JsonProperty("support")
  SupportModel support;
}
