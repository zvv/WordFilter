package com.awei.word.filter.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;


/**
 * 参数配置表
 *
 * @author lisd
 * @date 2021-06-09 14:54:56
 */
@ApiModel(value = "QueryModel", description = "查询")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WordVo implements Serializable {
    private static final long serialVersionUID = 958654353751373898L;

    @ApiModelProperty(value = "原词")
    private String word;

    @ApiModelProperty(value = "敏感词")
    private List<String> forbidWord;

    @ApiModelProperty(value = "状态：false:有敏感词，true:无敏感词")
    private Boolean checkStatus;

    @ApiModelProperty(value = "提示")
    private String message;

}
