package com.github.jsjchai.crud.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


/**
 * @author chaicj
 */
@Data
@NoArgsConstructor
@ApiModel(description = "接口返回数据模型")
public class Result<T> {

    @ApiModelProperty(value = "接口返回结果")
    private Boolean success;

    @ApiModelProperty(value = "接口返回code")
    private String code;

    @ApiModelProperty(value = "接口返回描述信息")
    private String message;

    @ApiModelProperty(value = "接口返回数据")
    private T data;

    /**
     *  系统成功码
     */
    private static final String SYS_SUCCESS = "0000";

    public static <T> Result<T> successResult() {
        Result<T> result = new Result<T>();
        result.setCode(SYS_SUCCESS);
        result.setSuccess(true);
        return result;
    }

    public static <T> Result<T> successResult( T data ) {
        Result<T> result = new Result<T>();
        result.setCode(SYS_SUCCESS);
        result.setData(data);
        result.setSuccess(true);
        return result;
    }

    public static <T> Result<T> failResult( String code, String message ) {
        Result<T> result = new Result<T>();
        result.setCode(code);
        result.setMessage(message);
        result.setSuccess(false);
        return result;
    }

}
