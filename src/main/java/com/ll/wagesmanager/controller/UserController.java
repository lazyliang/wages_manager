package com.ll.wagesmanager.controller;

import com.ll.wagesmanager.Exceptions;
import com.ll.wagesmanager.entity.User;
import com.ll.wagesmanager.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import me.cf81.commons.web.bind.annotation.FormModel;
import me.cf81.commons.web.bind.util.MapWrapper;
import me.cf81.commons.web.model.RestResult;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


/**
 * Create by ll on 2018/3/29.
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "查询用户列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "x-access-token", value = "令牌", paramType = "header", required = true),
            @ApiImplicitParam(name = "page", value = "页码，从0开始", paramType = "query"),

    })
    @GetMapping("/users:search")
    public Page<User> selectAll(@FormModel MapWrapper<String,Object>mapWrapper,@PageableDefault Pageable pageable){
        try{
            return userService.queryPageByMap(mapWrapper.toMap(),pageable);
        }catch (Exception e){
            e.printStackTrace();
           throw Exceptions.ERROR.buildException();
        }
    }

    @ApiOperation(value = "新增用户")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "x-access-token", value = "令牌", paramType = "header", required = true),

    })
    @PostMapping("/uesr/insert")
    public RestResult create(@RequestBody User user){
        try{
            userService.create(user);
            return RestResult.success();
        }catch (Exception e){
            e.printStackTrace();
            throw Exceptions.INSERT_ERROR.buildException();
        }
    }

    @ApiOperation(value = "修改用户")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "x-access-token", value = "令牌", paramType = "header", required = true),

    })
    @PutMapping("/user/updateOne")
    public RestResult updateOne(@RequestBody User user){
        try{
            userService.updateOne(user);
            return RestResult.success();
        }catch (Exception e){
            e.printStackTrace();
            throw Exceptions.ERROR.buildException();
        }
    }
}
