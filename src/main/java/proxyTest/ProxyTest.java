package proxyTest;

import DesignPatterns.ReflectInfo;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试代理〉
 *
 * @author fy
 * @create 2018/10/30
 */
public class ProxyTest {

    public static void main(String[] args) {
//        jdkProxyTest();
        cglibTest(); //未实现接口

    }

    private static void cglibTest() {
        CglibProxy cglibProxy=new CglibProxy();
        ReflectInfo info= (ReflectInfo) cglibProxy.getProxy(ReflectInfo.class);
        info.sayHello("飞");
    }

    private static void jdkProxyTest() {
        JdkProxy jdkProxy=new JdkProxy();
        IHelloWorld iHelloWorld = (IHelloWorld) jdkProxy.bind(new HelloWorldImpl());
        iHelloWorld.sayHello();
    }
}
