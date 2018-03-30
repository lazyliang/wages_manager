package com.ll.wagesmanager.service



/**
 *  Create by ll on 2018/3/30.
 */
interface LoginService {
    fun login(loginName:String,password:String):Int
}