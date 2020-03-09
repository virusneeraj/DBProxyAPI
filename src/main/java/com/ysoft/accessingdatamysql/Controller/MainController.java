package com.ysoft.accessingdatamysql.Controller;

import com.ysoft.accessingdatamysql.DTO.RequestDTO;
import com.ysoft.accessingdatamysql.DTO.ResponseDTO;
import com.ysoft.accessingdatamysql.Entity.User;
import com.ysoft.accessingdatamysql.Repository.UserRepository;
import com.ysoft.accessingdatamysql.Service.MySqlService;
import com.ysoft.accessingdatamysql.common.APIResponse;
import com.ysoft.accessingdatamysql.common.APIResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/mysql")
public class MainController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MySqlService mySqlService;

	@Autowired
	APIResponseUtil apiResponseUtil;

	@PostMapping("/select")
	public APIResponse doAction(@RequestBody RequestDTO requestDTO){
		logger.info("select request: "+requestDTO);
		APIResponse apiResponse = apiResponseUtil.badRequest(requestDTO);
		apiResponse = mySqlService.selectQueryResponse(requestDTO.getQuery());
		logger.info("select response: "+apiResponse);
		return  apiResponse;
	}

	@PostMapping("/execute")
	public APIResponse doExecute(@RequestBody RequestDTO requestDTO){
		logger.info("execute request: "+requestDTO);
		APIResponse apiResponse = apiResponseUtil.badRequest(requestDTO);
		apiResponse = mySqlService.executeQueryResponse(requestDTO.getQuery());
		logger.info("execute response: "+apiResponse);
		return  apiResponse;
	}

	@PostMapping("/update")
	public APIResponse doUpdate(@RequestBody RequestDTO requestDTO){
		logger.info("update request: "+requestDTO);
		APIResponse apiResponse = apiResponseUtil.badRequest(requestDTO);
		apiResponse = mySqlService.updateQueryResponse(requestDTO.getQuery());
		logger.info("update response: "+apiResponse);
		return  apiResponse;
	}
}
