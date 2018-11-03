package proxyTest;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author fy
 * @create 2018/10/30
 */
public class JdkProxy implements InvocationHandler{

    public Object target;

    /**
     *  生成代理对象
     * @param target 真实对象
     * @return
     */
    public Object bind(Object target){
        this.target=target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }


    /**
     * 代理逻辑处理（调用真实对象的方法）
     * @param proxy bind生成的代理类
     * @param method  方法名
     * @param args  参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑方法");
        System.out.println("在调度真实代理之前的服务");
        Object obj = method.invoke(target, args);  //真实对象反射调用方法
        System.out.println("在调度真实代理之后的服务");
        return obj;
    }
}
