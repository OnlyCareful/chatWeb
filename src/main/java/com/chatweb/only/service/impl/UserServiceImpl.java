package com.chatweb.only.service.impl;

import com.chatweb.only.tableEntity.User;
import com.chatweb.only.mapper.UserMapper;
import com.chatweb.only.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  User服务实现类
 * </p>
 *
 * @author InnerConce
 * @since 2019-01-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
