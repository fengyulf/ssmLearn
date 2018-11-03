package proxyTest;

import org.logicalcobwebs.cglib.proxy.Enhancer;
import org.logicalcobwebs.cglib.proxy.MethodInterceptor;
import org.logicalcobwebs.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br>
 * 〈CGLIB 代理〉
 *
 * @author fy
 * @create 2018/10/30
 */
public class CglibProxy implements MethodInterceptor{


    /**
     *  生成代理对象
     * @param cls
     * @return
     */
    public Object getProxy(Class cls){
        //增强类
        Enhancer enhancer=new Enhancer();
        //设置增强类型
        enhancer.setSuperclass(cls);
        //
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /**
     * 代理逻辑方法
     * @param proxy 代理对象
     * @param method 方法
     * @param args 参数
     * @param methodProxy 方法代理
     * @return 代理逻辑返回
     * @throws Throwable
     */
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("进入代理逻辑方法");
        System.out.println("在调度真实代理之前的服务");
        Object aSuper = methodProxy.invokeSuper(proxy, args);
        System.out.println("在调度真实代理之后的服务");
        return aSuper;
    }
}
