package com.jingli.inter.controller;

import com.jingli.inter.constant.Constance;
import com.jingli.inter.domain.ApiResult;
import com.jingli.inter.domain.ResultStatus;
import com.jingli.inter.entity.TUser;
import com.jingli.inter.service.TUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/outer/me")
public class MeController {

    @Autowired
    private TUserService userService;


    @GetMapping("/accountInfo")
    public ApiResult<TUser> accountInfo(@RequestParam("search_openId") String search_openId) {
        TUser user = userService.findByOpenId(search_openId);
        return ApiResult.success(user);
    }

    @GetMapping("/appletBindMobile")
    public ApiResult<String> appletBindMobile(@RequestParam("search_openId") String search_openId, @RequestParam("code") String code) {
        String result = userService.appletBindMobile(search_openId, code);
        return StringUtils.equals(Constance.TEXT_SUCCESS, result) ? ApiResult.success(Constance.TEXT_SUCCESS) : ApiResult.failure(ResultStatus.INTERNAL_SERVER_ERROR);
    }



}
