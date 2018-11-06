package responModel;

import proxyTest.HelloWorldImpl;
import proxyTest.IHelloWorld;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author fy
 * @create 2018/11/6
 */
public class IntercepTest {

    public static void main(String[] args) {
        IHelloWorld helloWorld1 = (IHelloWorld) IntercepJDKProxy.bind(new HelloWorldImpl(), "responModel.MyInterceptor1");
        IHelloWorld helloWorld2 = (IHelloWorld) IntercepJDKProxy.bind(helloWorld1,"responModel.MyInterceptor2");
        IHelloWorld helloWorld3 = (IHelloWorld) IntercepJDKProxy.bind(helloWorld2,"responModel.MyInterceptor3");
        helloWorld3.sayHello();
    }
}
