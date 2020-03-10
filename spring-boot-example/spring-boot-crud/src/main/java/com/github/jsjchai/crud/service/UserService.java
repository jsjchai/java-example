package com.github.jsjchai.crud.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.jsjchai.crud.domain.Result;
import com.github.jsjchai.crud.domain.UserDO;
import com.github.jsjchai.crud.domain.vo.UserVO;

/**
 * @author jsjchai
 */
public interface UserService {

    /**
     *  分页查询
     * @param pageNo 当前页
     * @param pageSize 分页数量
     * @return UserVO
     */
    Page<UserVO> listByPage( Integer pageNo, Integer pageSize);

    /**
     *  更新
     * @param user 用户
     * @return Void
     */
    Result<Void> update( UserDO user );

    /**
     * 删除
     * @param id 用户id
     * @return Void
     */
    Result<Void> delete( Integer id );

    /**
     * 保存
     * @param user user
     * @return id
     */
    Result<Integer> save( UserDO user );
}
