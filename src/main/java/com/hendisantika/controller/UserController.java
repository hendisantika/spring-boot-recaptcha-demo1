package com.hendisantika.controller;

import com.hendisantika.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-recaptcha-demo1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 03/10/21
 * Time: 08.49
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
}
