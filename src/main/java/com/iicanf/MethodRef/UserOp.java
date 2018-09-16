package com.iicanf.MethodRef;

import com.iicanf.Model.User;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class UserOp {

    public static String systemProp(Supplier<String> supplier) {
        return supplier.get();
    }

    public static void checkSystemProp(String[] value, Predicate<String> predicate) {
        Arrays.asList(value).forEach((String s) -> {
            if (!predicate.test(s)) {
                System.out.print(s);
            }
        });
    }

    public static void tenTimes(Integer i, Consumer<Integer> consumer) {
        consumer.accept(i);
    }

    public static int tenTimes(Integer i, Function<Integer, Integer> function) {
        return function.apply(i);
    }


}
