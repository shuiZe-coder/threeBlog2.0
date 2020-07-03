package org.shuize.blogadminconsumer.login.service;

import org.shuize.commonapi.RespUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.three.ourblog.login.pojo.TUser;

@FeignClient("ADMIN-LOGIN-SERVICE-PROVIDER")
public interface LoginRemoteService {

    @PostMapping("/admin/verify")
    RespUtil verify(@RequestBody TUser user);
}
