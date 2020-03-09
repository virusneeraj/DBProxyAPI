package com.ysoft.accessingdatamysql.Service;

import com.ysoft.accessingdatamysql.common.APIResponse;
import com.ysoft.accessingdatamysql.common.APIResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MySqlService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    APIResponseUtil apiResponseUtil;

    public List<Map<String, Object>> selectQuery(String query) throws Exception{
        return jdbcTemplate.queryForList(query);
    }

    public Boolean executeQuery(String query){
        jdbcTemplate.execute(query);
        return true;
    }

    public Integer updateQuery(String query){
        int count = jdbcTemplate.update(query);
        return count;
    }

    public APIResponse selectQueryResponse(String query){
        logger.info("select query: ", query);
        try {
            List<Map<String, Object>> mapList = selectQuery(query);
            return apiResponseUtil.successResponse(mapList);
        }catch (Exception e){
            logger.error("select query error",e);
            return apiResponseUtil.errorResponse(query, e);
        }

    }

    public APIResponse executeQueryResponse(String query){
        logger.info("execute query: ", query);
        try {
            Boolean flag = executeQuery(query);
            return apiResponseUtil.successResponse(flag);
        }catch (Exception e){
            logger.error("execute query error",e);
            return apiResponseUtil.errorResponse(query, e);
        }
    }

    public APIResponse updateQueryResponse(String query){
        logger.info("update query: ", query);
        try {
            Integer count = updateQuery(query);
            return apiResponseUtil.successResponse(count);
        }catch (Exception e){
            logger.error("update query error",e);
            return apiResponseUtil.errorResponse(query, e);
        }
    }
}
