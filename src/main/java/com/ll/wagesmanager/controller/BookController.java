package com.ll.wagesmanager.controller;


import com.ll.wagesmanager.Exceptions;
import com.ll.wagesmanager.model.Book;
import com.ll.wagesmanager.service.BookManageService;
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

@RestController
public class BookController {
    @Autowired
    private BookManageService bookManageService;
    @GetMapping("/search:books")
    public Page<Book> searchAllBook(@FormModel MapWrapper<String, Object> mapWrapper, @ApiIgnore Pageable pageable){
        try {
            return bookManageService.searchAllBooks(mapWrapper.toMap(), pageable);
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
