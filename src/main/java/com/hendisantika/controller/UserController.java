package com.hendisantika.controller;

import cn.apiclub.captcha.Captcha;
import com.hendisantika.model.User;
import com.hendisantika.service.UserService;
import com.hendisantika.util.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerUser(Model model) {
        User user = new User();
        getCaptcha(user);
        model.addAttribute("user", user);
        return "registerUser";
    }

    @PostMapping("/save")
    public String saveUser(
            @ModelAttribute User user,
            Model model
    ) {
        if (user.getCaptcha().equals(user.getHiddenCaptcha())) {
            userService.createUser(user);
            model.addAttribute("message", "User Registered successfully!");
            return "redirect:allUsers";
        } else {
            model.addAttribute("message", "Invalid Captcha");
            getCaptcha(user);
            model.addAttribute("user", user);
        }
        return "registerUser";
    }

    @GetMapping
    public String getAllUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);
        return "listUsers";
    }

    private void getCaptcha(User user) {
        Captcha captcha = CaptchaUtil.createCaptcha(240, 70);
        user.setHiddenCaptcha(captcha.getAnswer());
        user.setCaptcha(""); // value entered by the User
        user.setRealCaptcha(CaptchaUtil.encodeCaptcha(captcha));
    }
}
