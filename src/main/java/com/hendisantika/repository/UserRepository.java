package com.hendisantika.repository;

import com.hendisantika.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-recaptcha-demo1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 03/10/21
 * Time: 08.45
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
