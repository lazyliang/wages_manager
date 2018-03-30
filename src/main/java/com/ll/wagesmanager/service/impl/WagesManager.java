package com.ll.wagesmanager.service.impl;

import com.ll.wagesmanager.entity.Wages;
import com.ll.wagesmanager.mapper.WagesMapper;
import com.ll.wagesmanager.service.WagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Create by ll on 2018/3/30.
 */
@Transactional(readOnly = true)
@Service
public class WagesManager implements WagesService{
    @Autowired
    WagesMapper wagesMapper;
    @Override
    public Page<Wages> queryPageByMap(Map map, Pageable pageable) {
        Long count = wagesMapper.queryPageByMapCount(map);
        if (count != 0) {
            List<Wages> wagesList = wagesMapper.queryPageByMap(map, pageable);
            return new PageImpl<>(wagesList, pageable, count);
        }
        return new PageImpl<>(new ArrayList<>());
    }

    @Transactional
    @Override
    public void createOne(Wages wages) {
        wagesMapper.createOne(wages);
    }
}
