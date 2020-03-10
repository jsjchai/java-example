package com.github.jsjchai.crud.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.jsjchai.crud.CrudApplication;
import com.github.jsjchai.crud.domain.vo.UserVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = {CrudApplication.class})
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @DisplayName("test paging query")
    void listByPage(){
       Page<UserVO> data = userService.listByPage(1,10);
       assertNotNull(data);
    }

}