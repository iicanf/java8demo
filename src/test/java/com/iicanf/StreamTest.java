package com.iicanf;

import com.iicanf.Model.User;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private Stream<String> stream;
    private Stream<User> userStream;

    @Before
    public void init() {
        this.stream = Stream.of("hi", "hello", "ni hao", "ni hao");
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
        this.userStream = Stream.of(user, user1, user2, user3, user1);
    }


    @Test
    public void mapTest() {
        this.stream.map(String::toUpperCase).forEach((s) -> {
            consoleOut(s);
        });

//        this.stream.map((s) -> {
//            return s.toUpperCase();
//        }).forEach((s) -> {
//            logger.info("the upcase of steam is {}", s);
//        });
    }

    @Test
    public void flatMapTest() {
        this.userStream.flatMap(user -> {
            return Arrays.asList(user.getName(), user.getAddress(), user.getAddress()).stream();
        }).forEach(s -> {
            consoleOut(s);
        });
    }

    @Test
    public void filterTest() {
        this.stream.filter(s -> {
            return s.startsWith("h");
        }).forEach(s -> {
            consoleOut(s);
        });

        this.userStream.filter(user -> {
            return user.getAge() < 1;
        }).forEach(user -> {
            consoleOut(user);
        });
    }

    @Test
    public void distinctTest() {
        this.stream.distinct().forEach(s -> {
            consoleOut(s);
        });

        this.userStream.distinct().forEach(user -> {
            consoleOut(user);
        });
    }

    @Test
    public void sortTest() {
//        this.stream.sorted().forEach(s -> logger.info("the result is {}", s));

        this.stream.sorted((String s1, String s2) -> {
            return s2.compareTo(s1);
        }).forEach(s -> consoleOut(s));
    }

    @Test
    public void peekTest() {
//        this.stream.peek(s -> logger.info("the result is {}", s));
        this.stream.peek(s -> consoleOut(s)).map(s -> {
            return s.toUpperCase();
        }).forEach(s -> consoleOut(s));
    }


    @Test
    public void limitAndSkipTest() {
        this.userStream.sorted((User user1, User user2) -> {
            return user2.getAge() - user1.getAge();
        }).skip(1).limit(1).forEach(s -> consoleOut(s));

    }

    private void consoleOut(Object t) {
        logger.info("the result is {}", t);
    }

}
