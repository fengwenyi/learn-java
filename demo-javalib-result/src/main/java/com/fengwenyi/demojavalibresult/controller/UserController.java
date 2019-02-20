package com.fengwenyi.demojavalibresult.controller;

import com.fengwenyi.demojavalibresult.model.UserModel;
import com.fengwenyi.demojavalibresult.util.CodeMsg;
import com.fengwenyi.javalib.result.Result;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * User Controller : 用户操作
 * @author Wenyi Feng
 * @since 2019-02-05
 */
@RestController
@RequestMapping(value = "/user",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    /** 临时存放用户信息 */
    private List<UserModel> userModelList = new ArrayList<>();

    /**
     * 初始化用户
     */
    @PostConstruct
    public void init() {
        for (int i = 0; i < 10; i++)
            userModelList.add(new UserModel().setUid(UUID.randomUUID().toString()).setName("u" + i).setAge(10 + i));
    }

    /**
     * 查询用户列表
     * @return {@link Result}
     */
    @GetMapping("/list")
    public Result list() {
        return Result.success(userModelList);
    }

    /**
     * 添加用户
     * @param userModel 这里传JSON字符串
     * @return {@link Result}
     */
    @PostMapping("/add")
    public Result add(@RequestBody UserModel userModel) {
        if (userModel != null) {
            userModelList.add(userModel.setUid(UUID.randomUUID().toString()));
            return Result.success();
        }
        return Result.error();
    }

    /**
     * 根据UID获取用户
     * @param uid UID
     * @return {@link Result}
     */
    @GetMapping("/get/{uid}")
    public Result getByUid(@PathVariable("uid") String uid) {
        if (StringUtils.isEmpty(uid))
            return Result.error(CodeMsg.ERROR_USER_UID_NOT_NULL);
        for (UserModel userModel : userModelList)
            if (userModel.getUid().equals(uid))
                return Result.success(userModel);
        return Result.error(CodeMsg.ERROR_USER_NOT_EXIST);
    }

    /**
     * 测试参数错误
     * @return {@link Result}
     */
    @GetMapping("/test-param-error")
    public Result testParamError() {
        return Result.error(CodeMsg.ERROR_PARAM_ILLEGAL.fillArgs("account"));
    }

}
