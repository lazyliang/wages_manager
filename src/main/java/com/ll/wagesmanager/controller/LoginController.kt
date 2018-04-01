package com.ll.wagesmanager.controller

import com.ll.wagesmanager.Exceptions
import com.ll.wagesmanager.entity.User
import com.ll.wagesmanager.service.LoginService
import com.ll.wagesmanager.service.UserService
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiOperation
import me.cf81.commons.web.model.RestException
import me.cf81.commons.web.model.RestResult
import me.cf81.commons.web.sso.WebSessionUser
import me.cf81.sso.SSOConstants
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse

/**
 *  Create by ll on 2018/3/30.
 */
@RestController
class LoginController( val loginService: LoginService,val userServcie :UserService) {
    var logger: Logger = LoggerFactory.getLogger(LoginController::class.java)


    @ApiOperation(value = "验证用户", notes = "用户登陆验证")
    @ApiImplicitParams(value = [
        ApiImplicitParam(name = "x-access-token", value = "令牌", paramType = "header", required = true)
    ])
    @PostMapping("/login")
    fun login( loginName: String,  password: String): RestResult = try {
        var validate:Int = 0
        if (loginService.login(loginName, password)==200)validate=200 else validate=500
        RestResult.success(validate)
    } catch (e: RestException) {
        e.resultMessage.buildRestResult();
    } catch (e: Exception) {
        logger.error("登录错误:{}", e.message)
        if (logger.isDebugEnabled) {
            e.printStackTrace()
        }
        Exceptions.LOGIN_ERROR.buildRestResult();
    }

    @ApiOperation(value = "查询当前用户", notes = "根据当前用户名查询")
    @ApiImplicitParams(value = [
        ApiImplicitParam(name = "x-access-token", value = "令牌", paramType = "header", required = true)
    ])
    @GetMapping("/findOne")
    fun findByLoginName(loginName: String):User = try{
        userServcie.findByLoginName(loginName)
    }catch (e:Exception){
        e.printStackTrace()
        throw Exceptions.GET_DATA_ERROR.buildException()
    }



}