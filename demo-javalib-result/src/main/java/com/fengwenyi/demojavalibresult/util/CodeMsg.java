package com.fengwenyi.demojavalibresult.util;

import com.fengwenyi.javalib.result.BaseCodeMsg;

/**
 * 自定义返回码以及描述信息
 * @author Wenyi Feng
 * @since 2019-02-05
 */
public class CodeMsg {

    /*
    user error
    ------------------------------------------------------------------------------------------------------------*/
    /** 用户不存在 */
    public static final BaseCodeMsg ERROR_USER_NOT_EXIST = BaseCodeMsg.app(10001, "User Not Exist");
    /** UID不能为空 */
    public static final BaseCodeMsg ERROR_USER_UID_NOT_NULL = BaseCodeMsg.app(10002, "User UID Must Not null");

}
