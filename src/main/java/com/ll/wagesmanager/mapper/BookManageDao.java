package com.ll.wagesmanager.mapper;

import com.ll.wagesmanager.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
@Mapper
public interface BookManageDao {
    int count();
    List<Book> queryAllBook(@Param("map") Map map, @Param("pageable") Pageable pageable);

    //List<Book> searchBookByName(@Param("map") Map map, @Param("pageable") Pageable pageable);


}
