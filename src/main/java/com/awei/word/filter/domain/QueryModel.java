package com.awei.word.filter.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;


/**
 * 参数配置表
 *
 * @date 2021-06-09 14:54:56
 */
@ApiModel(value = "QueryModel", description = "查询参数")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QueryModel  implements Serializable {
    private static final long serialVersionUID = 958654353751373898L;

    @ApiModelProperty(value = "原词")
    private String word;


}
