package org.liumf.topic.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserTest {

    @Autowired
    private User user;

    @Test
    public void userTest() throws Exception {
        System.out.println(user.toString());
    }

}