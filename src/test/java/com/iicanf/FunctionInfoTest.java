package com.iicanf;

import com.iicanf.MethodRef.UserOp;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

public class FunctionInfoTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void supplierTest() {
        String javahome = UserOp.systemProp(() -> System.getenv("JAVA_HOME"));
        logger.info(javahome);
    }


    @Test
    public void predicateTest() {
        String[] value = {"java_home", "classpath", "path"};
//        String env = System.getenv("JAVA_HOME");
        UserOp.checkSystemProp(value, (String env) -> {
            return env.equals("path");
        });
    }

    @Test
    public void consumerTest() {
        UserOp.tenTimes(10, (integer) -> {
            logger.info("{}", integer * 10);
        });
        UserOp.tenTimes(1, (integer) -> {
            logger.info("{}", integer * 100);
        });
    }

    @Test
    public void functionTest() {
        int result = UserOp.tenTimes(10, (integer) -> {
            return integer * 10;
        });
        logger.info("{}", result);
        result = UserOp.tenTimes(1, (integer) -> {
            return integer * 100;
        });
        logger.info("{}", result);
    }
}
