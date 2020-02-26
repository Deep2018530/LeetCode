package com.deepz.test.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * created by zhangdingping on 2020/2/26
 */
public class CglibProxy implements MethodInterceptor {

    private Object target;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib动态代理,监听开始！");
        Object invoke = method.invoke(target, objects);
        System.out.println("Cglib动态代理，监听结束！");

        return invoke;
    }

    public Object getCglibProxy(Object objectTarget) {
        this.target = objectTarget;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(objectTarget.getClass());
        enhancer.setCallback(this);
        Object result = enhancer.create();
        return result;
    }

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        UserManager userManager = (UserManager) cglibProxy.getCglibProxy(new UserManagerImpl());
        userManager.delUser("admin");
    }

}
