package com.deepz.test;

/**
 * created by zhangdingping on 2020/2/25
 */
public class EnumSingleton {

    //枚举生来就是单例，枚举类的域（field）其实是相应的 enum 类型的一个实例对象，因为在 Java 中枚举是一种语法糖，所以在编译后，枚举类中的枚举域会被声明为 static 属性。
    private EnumSingleton() {
    }

    private enum Singleton {
        INSTANCE;
        private EnumSingleton instance = null;

        private Singleton() {
            instance = new EnumSingleton();
        }

        public EnumSingleton getSingleton() {
            return instance;
        }
    }

    public static EnumSingleton getInstance() {
        return Singleton.INSTANCE.getSingleton();
    }
}
