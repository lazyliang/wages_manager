package com.ll.wagesmanager.mapper;

import com.ll.wagesmanager.entity.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Map;

/**
 * Create by ll on 2018/3/29.
 */
@Mapper
public interface UserMapper {
    Long queryPageByMapCount(Map map);

    List<User> queryPageByMap(@Param("map") Map map, @Param("pageable") Pageable pageable);

    void create(User user);

    void updateOne(User user);

    void deleteOne(String id);

    void updatePassword(@Param("id") String id,@Param("password")String password);

    User findByLoginName(String loginName);

}
