package com.ll.wagesmanager.controller;


import com.ll.wagesmanager.Exceptions;
import com.ll.wagesmanager.model.Book;
import com.ll.wagesmanager.service.BookManageService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import me.cf81.commons.web.bind.annotation.FormModel;
import me.cf81.commons.web.bind.util.MapWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

@RestController
public class BookController {
    @Autowired
    private BookManageService bookManageService;
    @ApiOperation(value = "查询用户列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "x-access-token", value = "令牌", paramType = "header", required = true),
            @ApiImplicitParam(name = "page", value = "页码，从0开始", paramType = "query"),
            @ApiImplicitParam(name="search.nameOrAuthor",value = "搜索",paramType = "query")

    })
    @GetMapping("/search:books")
    public Page<Book> searchAllBook(@RequestParam Map<String, String> map, @ApiIgnore Pageable pageable){
        try {
            return bookManageService.searchAllBooks(map, pageable);
        }catch (Exception e){
            e.printStackTrace();
            throw Exceptions.ERROR.buildException();
        }
    }

//    @GetMapping("/search:byName")
//    public Page<Book> searchByName(@FormModel MapWrapper<String, Object> mapWrapper , @ApiIgnore Pageable pageable){
//        try{
//            return bookManageService.searchAllBooks(mapWrapper.toMap(), pageable);
//        }catch (Exception e){
//            e.printStackTrace();
//            throw Exceptions.ERROR.buildException();
//        }
//
//
//    }
}
