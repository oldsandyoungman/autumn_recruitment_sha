package com.shasha.s20220721;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ShaLuwei
 * @create 2022-07-21 15:05
 */


public class Test_dynamic_proxy {

    public static void main(String[] args) {

        Superman s = new Superman();
        Human proxy = (Human) ProxyFactory.getInstance(s);
        String belief = proxy.getBelief();
        System.out.println(belief);
        proxy.eat("rua");

    }


}


interface Human{
    public String getBelief();
    public void eat(String food);
}

class Superman implements Human{

    @Override
    public String getBelief() {
        return "I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("I love eat " + food);
    }

}

class ProxyFactory{

    public static Object getInstance(Object o){
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(o);
        return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), handler);

    }

}

class MyInvocationHandler implements InvocationHandler{

    Object obj;

    public void bind(Object o){
        obj = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("额外处理点事儿");
        Object res = method.invoke(obj, args);
        return res;
    }
}













//public class Test_dynamic_proxy {
//
//    public static void main(String[] args) throws Exception {
//        Superman s = new Superman();
//        Human proxy = (Human) ProxyFactory.getInstance(s);
//        String belief = proxy.getBelief();
//        System.out.println(belief);
//        proxy.eat("123");
//
//    }
//
//}
//
//interface Human{
//
//    public String getBelief();
//
//    public void eat(String food);
//
//}
//
//class Superman implements Human{
//
//    @Override
//    public String getBelief() {
//        return "I believe I can fly";
//    }
//
//    @Override
//    public void eat(String food) {
//        System.out.println("I love eat " + food);
//    }
//}
//
//class ProxyFactory{
//
//    public static Object getInstance(Object o) throws Exception {
//        MyInvocationHandler mih = new MyInvocationHandler();
//        mih.bind(o);
//        return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), mih);
//
//    }
//
//}
//
//class MyInvocationHandler implements InvocationHandler{
//
//    Object obj;
//
//    public void bind(Object o){
//        obj = o;
//    }
//
//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//
//        Object res = method.invoke(obj, args);
//        return res;
//    }
//}
//
