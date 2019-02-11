package com.fengwenyi.demojavalibresult.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * User Model
 * @author Wenyi Feng
 * @since 2019-02-05
 */
@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserModel implements Serializable {

    private static final long serialVersionUID = -835481508750383832L;

    /** UID */
    private String uid;

    /** Name */
    private String name;

    /** Age */
    private Integer age;

}
