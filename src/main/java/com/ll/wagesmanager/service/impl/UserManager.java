package com.ll.wagesmanager.service.impl;

import com.ll.wagesmanager.entity.User;
import com.ll.wagesmanager.mapper.UserMapper;
import com.ll.wagesmanager.service.UserService;
import com.ll.wagesmanager.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Create by ll on 2018/3/29.
 */
@EnableScheduling
@Transactional(readOnly = true)
@Service
public class UserManager implements UserService {
    @Autowired
    private UserMapper userMapper;

    public static final String originUrl = "F:\\user\\excel.xls";

    @Override
    public Page<User> queryPageByMap(Map map, Pageable pageable) {
        Long count = userMapper.queryPageByMapCount(map);
        if (count != 0) {
            List<User> users = userMapper.queryPageByMap(map, pageable);
            return new PageImpl<>(users, pageable, count);
        }
        return new PageImpl<>(new ArrayList<>());
    }

    @Transactional
    @Override
    public void create(User user) {
        userMapper.create(user);
    }

    @Transactional
    @Override
    public void updateOne(User user) {
        if (user.getIsDelete() == 0) {
            userMapper.updateOne(user);
        }
    }

    @Transactional
    @Override
    public void deleteOne(String id) {
        userMapper.deleteOne(id);
    }

    @Transactional
    @Override
    public void updatePassword(String id,String password){
        userMapper.updatePassword(id,password);
    }

    @Override
    public User findByLoginName(String loginName) {
        return userMapper.findByLoginName(loginName);
    }

    @Override
    @Transactional
    public void importExcel(String filePath) throws IOException {
        String  name = filePath.substring(filePath.lastIndexOf("."));
        List userList = ExcelUtil.readXls(filePath);
        userMapper.createMany(userList);

    }

    @Override
    public User findOne(String id) {
       return userMapper.findOne(id);
    }


}
