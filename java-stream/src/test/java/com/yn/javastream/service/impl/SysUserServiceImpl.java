package com.yn.javastream.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yn.javastream.domian.SysUser;
import com.yn.javastream.mapper.SysUserMapper;
import com.yn.javastream.service.SysUserService;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
}
