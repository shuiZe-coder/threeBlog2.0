package org.three.ourblog.login.controller;


import org.shuize.commonapi.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.three.ourblog.login.pojo.TUser;
import org.three.ourblog.login.service.TUserService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shuize
 * @since 2020-07-03
 */
@RestController
@RequestMapping("/admin")
public class TUserController {

    @Autowired
    private TUserService userService;

    @PostMapping("/verify")
    public RespUtil verify(@RequestBody TUser user){
        if (userService.verify(user)){
            return RespUtil.ok().data("data", "登录成功");
        }else{
            return RespUtil.error().data("data", "登录失败");
        }
    }

}

