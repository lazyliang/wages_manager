package com.ll.wagesmanager.controller;

import com.ll.wagesmanager.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.ll.wagesmanager.controller.Test.test1;


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
    private static <T> T newTclass(Class<T> clazz) throws InstantiationException, IllegalAccessException{
        T a=clazz.newInstance();
        return a;

    }

    public static <T>T test1(Class<T>clazz) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
      T obj = clazz.newInstance();
      return obj;
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        test1(User.class).setName("sd");
    }


}
