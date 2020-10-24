package com.gn5r.gn5rapl.demo.resource;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@lombok.Data
@ApiModel(description = "パンくずリスト検索リソース")
public class TopicPathSerchResource implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "親ID", example = "")
    private String parentId;

    @ApiModelProperty(value = "子ID", example = "")
    private String childId;
}