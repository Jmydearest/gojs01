package com.baizhi.controller;


import com.alibaba.druid.util.StringUtils;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    //模糊检索
    @GetMapping("findLike")
    public List<User> findName(String name,String code){
        return userService.findName(name, code);
    }

    //查询所有
    @GetMapping("findAll")
    public List<User> findAll(){
        List<User> users= userService.findAll();
        return users;
    }
    //添加用户
    @PostMapping("save")
    public Map<String,Object> save(@RequestBody User user){
        Map<String, Object> map = new HashMap<>();
        try {
            if(StringUtils.isEmpty(user.getId())){
                userService.save(user);
            }else{
                userService.update(user);
            }

            map.put("success", true);

        }catch (Exception e){
            map.put("success", false);
            map.put("message", "用户保存或更新失败");
        }
        return map;

    }

    //删除用户
    @GetMapping("delete")
    public Map<String,Object> delete(String id){
        Map<String, Object> map = new HashMap<>();
        try {
            userService.delete(id);
            map.put("success", true);

        }catch (Exception e){
            map.put("success", false);
            map.put("message", "用户删除失败");
        }
        return map;
    }

    //查询一个用户
    @GetMapping("findUser")
    public User findUser(String id){
        return userService.findUser(id);
    }


}
