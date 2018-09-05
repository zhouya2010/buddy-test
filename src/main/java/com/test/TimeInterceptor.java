package com.test;

import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public class TimeInterceptor {
    @RuntimeType
    public static Object intercept(@Origin Method method,
                                   @SuperCall Callable<?> callable) throws Exception {
        long start = System.currentTimeMillis();
        System.out.println(method.getName());
        for (int i =0 ; i < method.getParameterCount(); i++) {
            System.out.println("var " + i + " ==>  " + method.getParameters()[i].toString());
            System.out.println("var " + i + " ==>  " + method.getParameters()[i].getName());
            System.out.println("var " + i + " ==>  " + method.getParameters()[i].getParameterizedType().getTypeName());
        }
        try {
            // 原有函数执行
            return callable.call();
        } finally {
            System.out.println(method + ": took " + (System.currentTimeMillis() - start) + "ms");
        }
    }
}
