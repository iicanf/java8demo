package com.iicanf;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String append = ";";

    @Test
    public void listForEachTest() {
        Arrays.asList("a", "b", "c").forEach((String s) -> {
            logger.info("current alphabet in list is {}", s);
        });
    }

    @Test
    public void listForEachTest1() {
        Arrays.asList("a", "b", "c").forEach(s ->
                logger.info("current alphabet in list is {}", s)
        );
    }

    @Test
    public void listForEachTest2() {
        Arrays.asList("a", "b", "c").forEach((String s) -> {
            s += append;
            logger.info("current alphabet in list is {}", s);
        });
    }

    @Test
    public void listForEachTest3() {
        List<Integer> rst = Arrays.asList(5, 1, 3, 4);
        rst.sort((e1, e2) -> {
            int result = e1.compareTo(e2);
            return -result;
        });
        logger.info("the result is {}", rst);
    }

}
