package com.github.jsjchai.crud.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.jsjchai.crud.dao.UserMapper;
import com.github.jsjchai.crud.domain.Result;
import com.github.jsjchai.crud.domain.UserDO;
import com.github.jsjchai.crud.domain.vo.UserVO;
import com.github.jsjchai.crud.service.UserService;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jsjchai
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl( UserMapper userMapper ) {
        this.userMapper = userMapper;
    }

    @Override
    public Page<UserVO> listByPage( Integer pageNo, Integer pageSize ) {
        Page<UserDO> page = new Page<>(pageNo, pageSize);
        IPage<UserDO> data = userMapper.selectPage(page, null);
        List<UserDO> list = data.getRecords();

        List<UserVO> records = new ArrayList<>(pageSize);
        for (UserDO user : list) {
            UserVO u = new UserVO();
            u.setId(user.getId());
            u.setAge(user.getAge());
            u.setCreateTime(user.getCreateTime().toString());
            u.setName(user.getName());
            records.add(u);
        }

        Page<UserVO> p = new Page<>(page.getCurrent(), page.getSize(), data.getTotal());
        p.setRecords(records);
        return p;
    }

    @Override
    public Result<Void> update( UserDO user ) {
        Preconditions.checkNotNull(user);
        userMapper.updateById(user);
        return Result.successResult();
    }

    @Override
    public Result<Void> delete( Integer id ) {
        Preconditions.checkNotNull(id);
        userMapper.deleteById(id);
        return Result.successResult();
    }

    @Override
    public Result<Integer> save( UserDO user ) {
        Preconditions.checkNotNull(user);
        userMapper.insert(user);
        return Result.successResult(user.getId());
    }
}
