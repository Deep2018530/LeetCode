package com.deepz.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * created by zhangdingping on 2020/2/26
 */
public class JdkProxy implements InvocationHandler {

    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理，监听开始！");
        Object result = method.invoke(target, args);
        System.out.println("JDK动态代理，监听结束！");

        return result;
    }

    private Object getJDKProxy(Object targetObject) {
        this.target = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {
        JdkProxy jdkProxy = new JdkProxy();
        UserManager userManager = (UserManager) jdkProxy.getJDKProxy(new UserManagerImpl());
        userManager.addUser("admin", "123123");
    }
}
