package com.ll.wagesmanager.controller;

import com.ll.wagesmanager.Exceptions;
import com.ll.wagesmanager.entity.User;
import com.ll.wagesmanager.service.UserService;
import com.ll.wagesmanager.utils.Upload;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * Create by ll on 2018/3/29.
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    public static final String path = "F:\\user\\";

    @ApiOperation(value = "查询用户列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "x-access-token", value = "令牌", paramType = "header", required = true),
            @ApiImplicitParam(name = "page", value = "页码，从0开始", paramType = "query"),

    })
    @GetMapping("/users:search")
    public Page<User> selectAll(@FormModel MapWrapper<String, Object> mapWrapper, @PageableDefault Pageable pageable) {
        try {
            return userService.queryPageByMap(mapWrapper.toMap(), pageable);
        } catch (Exception e) {
            e.printStackTrace();
            throw Exceptions.ERROR.buildException();
        }
    }

    @ApiOperation(value = "新增用户")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "x-access-token", value = "令牌", paramType = "header", required = true),

    })
    @PostMapping("/user/insert")
    public RestResult create(@RequestBody User user) {
        try {
            userService.create(user);
            return RestResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            throw Exceptions.INSERT_ERROR.buildException();
        }
    }

    @ApiOperation(value = "修改用户")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "x-access-token", value = "令牌", paramType = "header", required = true),

    })
    @PutMapping("/user/updateOne")
    public RestResult updateOne(@RequestBody User user) {
        try {
            userService.updateOne(user);
            return RestResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            throw Exceptions.ERROR.buildException();
        }
    }

    @ApiOperation(value = "删除用户")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "x-access-token", value = "令牌", paramType = "header", required = true),

    })
    @DeleteMapping("/user/deleteOne")
    public RestResult deleteOne(@RequestParam String id) {
        try {
            userService.deleteOne(id);
            return RestResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            throw Exceptions.EXSIT_CHILDREN_ERROR.buildException();
        }
    }

    @ApiOperation(value = "修改密码")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "x-access-token", value = "令牌", paramType = "header", required = true),

    })
    @PutMapping("/user:password")
    public RestResult updatePwd(String id, String password) {
        try {
            userService.updatePassword(id,password);
            return RestResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            throw Exceptions.UPDATE_ERROR.buildException();
        }
    }

    @ApiOperation(value = "用户导入")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "x-access-token", value = "令牌", paramType = "header", required = true),

    })
    @PostMapping("/user/import")
    public RestResult importExcel(@RequestParam("file")MultipartFile file){
        try{
            String filePath = path+ Upload.upLoadFile(file,path);
            userService.importExcel(filePath);
            return RestResult.success();
        }catch (Exception e){
            e.printStackTrace();
            throw Exceptions.IMPORT_ERROR.buildException();
        }
    }
    @ApiOperation(value = "查询单个用户详情")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "x-access-token", value = "令牌", paramType = "header", required = true),

    })
    @GetMapping("/user/findOne")
    public User findOne(String id ){
        try{
            return userService.findOne(id);
        }catch (Exception e){
            e.printStackTrace();
            throw Exceptions.GET_DATA_ERROR.buildException();
        }
    }

}
