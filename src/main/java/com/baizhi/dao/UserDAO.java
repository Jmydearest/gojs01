package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDAO {
    //查询所有
    List<User> findAll();

    void save(User user);

    void delete(String id);
    //根据id查询用户
    User findUser(String id);
    //更新用户
    void update(User user);
    //模糊检索
    List<User> findName(@Param("name") String name,@Param("code") String phoneCode);
}
