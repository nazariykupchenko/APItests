package com.api.models.reqres;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;

@Getter
public class ResourceList {

  @JsonProperty("page")
  private int page;
  @JsonProperty("per_page")
  private int per_page;
  @JsonProperty("total")
  private int total;
  @JsonProperty("total_pages")
  private int total_pages;
  @JsonProperty("data")
  private List<ResourceData> resourceData;
  @JsonProperty("support")
  private Support support;
}
