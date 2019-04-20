package com.ll.wagesmanager.service.impl;

import com.ll.wagesmanager.mapper.BookManageDao;
import com.ll.wagesmanager.model.Book;
import com.ll.wagesmanager.service.BookManageService;
//import me.cf81.commons.web.model.data.PageableResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BookManageServiceImp implements BookManageService {
    @Autowired
    private BookManageDao bookManageDao;

    /**
     * 查询所有的书籍
     *
     * @return
     */
    @Override
    public Page<Book> searchAllBooks(Map map, Pageable pageable) {
        int count = bookManageDao.count();
        if (count != 0) {
            List<Book> books = bookManageDao.queryAllBook(map, pageable);
            return new PageImpl<>(books, pageable, count);
        }
        return new PageImpl<>(new ArrayList<>());
    }


    /**
     * 通过名字查询书籍
     * @param map pageable
     * @return Page<Book>
     */
//    @Override
//    public Page<Book> searchByName(Map map,Pageable pageable) {
//        int count = bookManageDao.count();
//        if (count != 0) {
//            List<Book> books = bookManageDao.searchBookByName(map, pageable);
//            return new PageableResponse<>(books, pageable, count);
//        }
//        return new PageableResponse<>(new ArrayList<>());
//    }
//}
}