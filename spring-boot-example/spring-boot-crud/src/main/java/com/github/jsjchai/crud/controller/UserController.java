package com.github.jsjchai.crud.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.jsjchai.crud.domain.Result;
import com.github.jsjchai.crud.domain.UserDO;
import com.github.jsjchai.crud.domain.vo.UserVO;
import com.github.jsjchai.crud.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * @author chaicj
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {

    private final UserService userService;

    public UserController( UserService userService ) {
        this.userService = userService;
    }


    @GetMapping("/listByPage")
    public Page<UserVO> listByPage( @RequestParam Integer pageNo, @RequestParam Integer pageSize ) {

        return userService.listByPage(pageNo, pageSize);
    }

    @PutMapping("/update")
    public Result<Void> update( UserDO user){
        return userService.update(user);
    }

    @DeleteMapping("/delete")
    public Result<Void> delete(@RequestParam Integer id){
        return userService.delete(id);
    }

    @PostMapping("/save")
    public Result<Integer> save(UserDO user){
        return userService.save(user);
    }
}
