package com.github.jsjchai.crud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.jsjchai.crud.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chaicj
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}
