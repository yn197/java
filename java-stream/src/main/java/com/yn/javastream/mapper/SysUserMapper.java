package com.yn.javastream.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yn.javastream.domian.SysUser;

import java.util.List;

public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysUser> findAll(SysUser sysUser);
}
