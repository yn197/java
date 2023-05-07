package com.yn.javastream;

import com.yn.javastream.domian.SysUser;

public class ThreadLocalUtils {
    private static final ThreadLocal<SysUser> SYS_USER_THREAD_LOCAL = new ThreadLocal<SysUser>();

    public static void add(SysUser sysUser) {
        SYS_USER_THREAD_LOCAL.set(sysUser);
    }

    public static void remove() {
        SYS_USER_THREAD_LOCAL.remove();
    }

    public static SysUser get() {
        return SYS_USER_THREAD_LOCAL.get();
    }


    public static void main(String[] args) {
        System.out.println(SYS_USER_THREAD_LOCAL);
        SysUser sysUser = new SysUser();
        sysUser.setUserName("张三");
        sysUser.setUserId(1L);
        ThreadLocalUtils.add(sysUser);
        SysUser user = ThreadLocalUtils.get();
        System.out.println(user);
        ThreadLocalUtils.remove();
        SysUser user2 = ThreadLocalUtils.get();
        System.out.println(user2);
        System.out.println(SYS_USER_THREAD_LOCAL);
    }
}
