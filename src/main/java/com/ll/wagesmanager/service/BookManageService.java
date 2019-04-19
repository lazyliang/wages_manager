package com.ll.wagesmanager.service;

import com.ll.wagesmanager.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface BookManageService {
    Page<Book> searchAllBooks(Map map, Pageable pageable);

    //Page<Book> searchByName( Map map, Pageable pageable);
}
