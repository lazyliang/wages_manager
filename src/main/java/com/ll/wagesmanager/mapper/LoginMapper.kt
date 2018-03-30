package com.ll.wagesmanager.mapper

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

/**
 *  Create by ll on 2018/3/30.
 */
@Mapper
interface LoginMapper {
    fun verifyUser(@Param("loginName")loginName:String,@Param("password")password:String):Int

}