package com.ll.wagesmanager.service.impl

import com.ll.wagesmanager.Exceptions
import com.ll.wagesmanager.entity.User
import com.ll.wagesmanager.mapper.LoginMapper
import com.ll.wagesmanager.service.LoginService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


/**
 *  Create by ll on 2018/3/30.
 */
@Transactional(readOnly = true)
@Service
 open class LoginManager(val loginMapper: LoginMapper) : LoginService {

    val logger: Logger = LoggerFactory.getLogger(LoginManager::class.java)

    override fun login(loginName: String, password: String): Int = try {
        val user = User();
        user.loginName = loginName
        user.password = password
        val verify = loginMapper.verifyUser(loginName, password)
        if (verify > 0) {
            200
        } else {
            500
        }
    } catch (e: Exception) {
        e.printStackTrace()
        throw Exceptions.LOGIN_ERROR.buildException()
    }

}