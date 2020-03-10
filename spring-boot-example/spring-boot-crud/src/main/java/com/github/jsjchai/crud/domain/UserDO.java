package com.github.jsjchai.crud.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author jsjchai
 */
@Getter
@Setter
@TableName("user")
public class UserDO {

    private Integer id;

    private String name;

    private Integer age;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
