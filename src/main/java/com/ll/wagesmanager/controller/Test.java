package com.ll.wagesmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Create by ll on 2018/3/28.
 */
@RestController
public class Test {

    @GetMapping(value = "/new/web")
    @ResponseBody
    public int test(){
        return 123;
    }


}
