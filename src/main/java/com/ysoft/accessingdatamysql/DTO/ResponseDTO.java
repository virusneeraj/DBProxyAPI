package com.ysoft.accessingdatamysql.DTO;

import lombok.Data;

@Data
public class ResponseDTO {
    private Integer count;
    private Object result;
    private String error;
}
