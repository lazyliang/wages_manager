package com.ll.wagesmanager.service;

import com.ll.wagesmanager.entity.Wages;
import com.ll.wagesmanager.entity.WagesDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * Create by ll on 2018/3/30.
 */
public interface WagesService {
    /**
     * 分页查询列表
     *
     * @param map
     * @param pageable
     * @return
     */
    Page<WagesDto> queryPageByMap(Map map, Pageable pageable);

    /**
     * 新增工资信息
     *
     * @param wages
     */
    void createOne(Wages wages);

    /**
     * 修改单个工资信息
     * @param wagesDto
     */
    void updateOne(Wages wages);;

    /**
     * 根据ID删除
     * @param id
     */
   void deleteOne(String id);
}
