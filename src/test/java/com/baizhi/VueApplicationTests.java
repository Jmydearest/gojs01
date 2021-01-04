package com.baizhi;

import com.baizhi.dao.UserDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class VueApplicationTests {

    @Autowired
    private UserDAO userDAO;

    @Test
    void contextLoads() {

        userDAO.findAll().forEach(user -> System.out.println("user="+user));
    }

}
