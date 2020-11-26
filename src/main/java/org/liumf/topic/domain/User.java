package org.liumf.topic.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author liumf
 * @date 0:21 2020/11/27
 * @className User
 * @description
 */
@Component
@ConfigurationProperties(prefix= "user")
@Data
public class User {
    private String userName;
    private String password;
    private String date;


}
