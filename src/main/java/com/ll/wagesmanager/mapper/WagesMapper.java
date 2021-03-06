package com.ll.wagesmanager.mapper;

import com.ll.wagesmanager.entity.Wages;
import com.ll.wagesmanager.entity.WagesDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Map;

/**
 * Create by ll on 2018/3/30.
 */
@Mapper
public interface WagesMapper {
    List<WagesDto> queryPageByMap(@Param("map") Map map, @Param("pageable")Pageable pageable);

    Long queryPageByMapCount (Map map);

    void createOne(Wages wages);

    void updateOne(Wages wages);

    WagesDto findOne(WagesDto wagesDto);

    void deleteOne(String id);

}
