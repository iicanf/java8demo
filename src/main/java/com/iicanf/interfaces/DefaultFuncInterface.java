package com.iicanf.interfaces;

import com.iicanf.Model.User;

@FunctionalInterface
public interface DefaultFuncInterface {
    public void dosomething();

    default int caculdateAge(User user) {
        return user.getAge();
    }

    static String outPutName(User user) {
        return user.getName();
    }
}
