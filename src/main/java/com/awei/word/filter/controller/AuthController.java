package com.awei.word.filter.controller;

import com.awei.word.filter.domain.QueryModel;
import com.awei.word.filter.domain.WordVo;
import com.awei.word.filter.service.IAuthService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 认证接口，包括用户注册，用户登录请求
 *
 * @author lisd
 * @date Created in 2021-05-07 17:23
 */
@Api(tags = "敏感词验证")
@RequestMapping("/auth")
@RestController
public class AuthController {
    @Autowired
    private IAuthService authService;

    @ApiOperation(value = "敏感词验证接口", notes = "")
    @ApiOperationSupport(order = 6)
    @PostMapping("/word/filter")
    public WordVo forbidWord(@RequestBody QueryModel model) {
        return authService.forbidWord(model);
    }
}