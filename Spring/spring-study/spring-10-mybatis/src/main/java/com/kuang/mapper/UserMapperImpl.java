package com.kuang.mapper;

import com.kuang.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper{

    //我们的所有操作都需要SQL session来执行，现在都是用SQL sessionTemplate；
    private SqlSessionTemplate sqlsession;

    public void setSqlsession(SqlSessionTemplate sqlsession) {
        this.sqlsession = sqlsession;
    }

    @Override
    public List<User> selectUser() {
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        return mapper.selectUser();
    }
}
