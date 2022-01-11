package com.kuang.dao;

public class UserDaoMysqlImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("mysql获取用户数据");
    }
}
