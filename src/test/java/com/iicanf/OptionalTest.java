package com.iicanf;

import com.iicanf.Model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private User user;
    private Optional<User> optionalUser;

    @Before
    public void pre() {
        User user = new User();
//        User user = null;
        this.user = user;
        this.optionalUser = Optional.ofNullable(this.user);
    }

    @Test
    public void initOptional() {
        Assert.assertNotNull(optionalUser.get());
    }


    @Test
    public void getInOptional() {
        User temp = null;

        temp = this.optionalUser.orElse(new User());
        logger.info("the result is {}", temp);

        temp = this.optionalUser.orElseGet(User::new);
        logger.info("the result is {}", temp);

        temp = this.optionalUser.orElseGet(() -> User.create());
        logger.info("the result is {}", temp);

        temp = this.optionalUser.orElseGet(User::create);
        logger.info("the result is {}", temp);
    }

    @Test
    public void checkOptional() {

        this.optionalUser.ifPresent((user) -> {
            logger.info("{}", user);
        });

        boolean present = this.optionalUser.isPresent();
        logger.info("the result is {}", present);
    }

    @Test
    public void mapTest() {
        User user = new User();
        user.setAge(0);
        user.setName("0");
        user.setAddress("0");

        User user1 = new User();
        user1.setAge(1);
        user1.setName("1");
        user1.setAddress("1");

        User user2 = new User();
        user2.setAge(2);
        user2.setName("2");
        user2.setAddress("2");


        User user3 = new User();

        List<User> list = Arrays.asList(user, user1, user2, user3);
        list.forEach(temp -> {
            this.optionalUser = Optional.ofNullable(temp);
            int result = this.optionalUser.map((u) -> u.getAge()).map(age -> age + 10).orElse(-1);
            logger.info("user age is {}", result);
            String resultString = this.optionalUser.map((u) -> u.getName()).map(name -> name + ";").orElse("");
            logger.info("user name is {}", resultString);
        });


    }


}
