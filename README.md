# topic
# Springboot学习笔记



## 1.yaml配置文件值的获取

### 创建实体类bean

#### 方式一

```java
/**
 * 1.使用注解ConfigurationProperties来指定yml配置文件中的前缀，2.User实体必须是Spring容器中的组件，才能获取到值，所以加上组件注解@Component
 * 3.也可以使用@Value("${user.userName}")标注在属性上进行获取
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

```

#### 方式二

```java
/**
 * 1.User实体必须是Spring容器中的组件，才能获取到值，所以加上组件注解@Component
 * 2.也可以使用@Value("${user.userName}")标注在属性上进行获取
 * 3.若以上两种方式同时使用，则注入的值为配置文件中的值，如下面的password属性分别在配置文件中和使用@Value注入值，则实际注入值为123
 * @author liumf
 * @date 0:21 2020/11/27
 * @className User
 * @description
 */

@Component
@ConfigurationProperties(prefix= "user")
@Data
public class User {
    @Value("${user.userName}")
    private String userName;
    @Value("1111111111")
    private String password;
    private String date;
}

```





### 定义配置文件

```yaml
#配置服务器端口
server:
  port: 8081


user:
  user-name: liumf
  password: 123
  date: 2020-11-27
```

### 配置文件处理器的使用

使用@ConfigurationProperties注解的时候idea会提示让配置文件注解处理器，此时点击提示会跳转到官方文档配置注解处理器的文档位置，复制文档中的pom.xml依赖，导入到项目中。我们定义好bean中的属性，首先**运行一次项目**，这时候在yaml中书写对应的属性**才会生效有提示功能**，所以最好先创建实体类，然后再定义yaml中要注入的属性值。

**注解处理器的作用：**方便我们书写配置文件中的属性值，编译器自带的提示功能可以快速帮我们完成配置文件中属性值的写入。

```xml
        <!--配置注解器-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>
```



### properties文件获取值

properties文件值的获取同yaml中获取是一样的，区别只是yaml和properties文件的书写格式不同，还需要注意的一点是properties中的属性值输出后可能存在中文乱码的情况，这时候需要设置idea的配置文件 为UTF-8。设置路径在setting---editor---File Encoding中 。


