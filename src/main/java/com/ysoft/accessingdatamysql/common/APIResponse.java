package com.ysoft.accessingdatamysql.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class APIResponse implements Serializable {
    private Integer status;
    private String message;
    private Object data;
}
