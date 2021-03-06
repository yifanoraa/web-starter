package com.yifanoraa.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.yifanoraa.core.model.TestContent;
import com.yifanoraa.core.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@Api(tags = "Test api")
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    TestService testService;


    @ResponseBody
    @ApiOperation("Insert test content")
    @PostMapping("/add")
    public JSONObject addTestContent(@RequestBody JSONObject jsonObject){
        // Construct response
        JSONObject response = new JSONObject();
        if (testService.addContent(jsonObject) == 1){
            response.put("code", 0);
            response.put("message", "The request has been processed successfully.");
        }else{
            response.put("code", 1003);
            response.put("message", "The request has failed.");
        }
        return response;
    }

    @ResponseBody
    @ApiOperation("Fetch test data by page")
    @GetMapping("/fetch")
    public JSONObject findFeedbackPage(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize){

        PageInfo<TestContent> result = testService.findAllRecords(pageNum,pageSize);
        JSONObject response = new JSONObject();
        if (result != null){
            response.put("code", 0);
            response.put("message", "The request has been processed successfully.");
            response.put("data", result);
        }else{
            response.put("code", 1003);
            response.put("message", "The request has failed.");
        }
        return response;
    }
}
