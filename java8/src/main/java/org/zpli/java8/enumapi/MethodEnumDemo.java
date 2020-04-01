package org.zpli.java8.enumapi;

/**
 * @Description: 与常规抽象类一样，enum类允许我们为其定义抽象方法，然后使每个枚举实例都实现该方法，
 *               以便产生不同的行为方式，注意abstract关键字对于枚举类来说并不是必须的
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/4/1 15:35
 */
public enum  MethodEnumDemo {

    FIRST{
        public void sayHello(){
            System.out.println("Hello FIRST");
        }
    },

    SECOND{
        public void sayHello(){
            System.out.println("Hello SECOND");
        }
    };

    public abstract void sayHello();

    public static void main(String[] args) {
        MethodEnumDemo.FIRST.sayHello();
        MethodEnumDemo.SECOND.sayHello();
    }
}
