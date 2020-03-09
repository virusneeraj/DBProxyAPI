package com.ysoft.accessingdatamysql.common;

import org.springframework.stereotype.Component;

@Component
public class APIResponseUtil {
    public APIResponse successResponse(Object data){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatus(Constant.SUCCESS_STATUS);
        apiResponse.setMessage(Constant.SUCCESS_MESSAGE);
        apiResponse.setData(data);
        return apiResponse;
    }

    public APIResponse errorResponse(Object data, Exception e){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatus(Constant.ERROR_STATUS);
        apiResponse.setMessage(e.getMessage());
        apiResponse.setData(data);
        return apiResponse;
    }

    public APIResponse alreadyExist(Object data){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatus(Constant.ALREADY_EXIST_STATUS);
        apiResponse.setMessage(Constant.ALREADY_EXIST_MESSAGE);
        apiResponse.setData(data);
        return apiResponse;
    }

    public APIResponse badRequest(Object data){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatus(Constant.BAD_REQUEST_STATUS);
        apiResponse.setMessage(Constant.BAD_REQUEST_MESSAGE);
        apiResponse.setData(data);
        return apiResponse;
    }

}
