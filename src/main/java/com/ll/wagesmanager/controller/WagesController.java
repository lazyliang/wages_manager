package com.ll.wagesmanager.controller;

import com.ll.wagesmanager.Exceptions;
import com.ll.wagesmanager.entity.Wages;
import com.ll.wagesmanager.service.WagesService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import me.cf81.commons.web.bind.annotation.FormModel;
import me.cf81.commons.web.bind.util.MapWrapper;
import me.cf81.commons.web.model.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Create by ll on 2018/3/30.
 */
@RestController
public class WagesController {
    @Autowired
    WagesService wagesService;
    @ApiOperation(value = "查询工资明细列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "x-access-token", value = "令牌", paramType = "header", required = true),
            @ApiImplicitParam(name = "page", value = "页码，从0开始", paramType = "query"),

    })
    @GetMapping("/wages:search")
    public Page<Wages> searchAll(@FormModel MapWrapper<String,Object>mapWrapper, @PageableDefault Pageable pageable){
        try{
            return wagesService.queryPageByMap(mapWrapper.toMap(),pageable);
        }catch (Exception e){
            e.printStackTrace();
            throw Exceptions.GET_DATA_ERROR.buildException();
        }
    }

    @ApiOperation(value = "新增工资信息")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "x-access-token", value = "令牌", paramType = "header", required = true),

    })
    @PostMapping("/wages/createOne")
    public RestResult createOne(@RequestBody Wages wages){
        try{
            wagesService.createOne(wages);
            return RestResult.success();
        }catch (Exception e){
            e.printStackTrace();
            throw Exceptions.INSERT_ERROR.buildException();
        }
    }

}
