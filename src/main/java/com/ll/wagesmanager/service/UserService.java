package com.ll.wagesmanager.service;

import com.ll.wagesmanager.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Map;

/**
 * Create by ll on 2018/3/29.
 */
public interface UserService {
    /**
     * 查询用户列表
     *
     * @param pageable
     * @return
     */
    Page<User> queryPageByMap(Map map, Pageable pageable);

    /**
     * 新增用户
     *
     * @param user
     */
    void create(User user);

    /**
     * 修改用户
     *
     * @param user
     */
    void updateOne(User user);

    /**
     * 删除用户
     *
     * @param id
     */
    void deleteOne(String id);

    /**
     * 修改密码
     * @param id
     * @param password
     */
    void updatePassword(String id, String password);

    /**
     * 根据登录名查询当前用户信息
     * @param loginName
     * @return
     */
    User findByLoginName(String loginName);

}

