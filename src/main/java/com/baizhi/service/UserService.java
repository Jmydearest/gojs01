package com.baizhi.service;


import com.baizhi.entity.User;

import java.util.List;

public interface UserService {

    //查询所有用户
    List<User> findAll();

    void save(User user);

    void delete(String id);

    User findUser(String id);
    void update(User user);
    List<User> findName(String name,String code);
}
