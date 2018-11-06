package responModel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author fy
 * @create 2018/11/6
 */
public class IntercepJDKProxy implements InvocationHandler{

    //真实对象
    private Object target;

    private String intercepterClass;

    public IntercepJDKProxy(Object target, String intercepterClass) {
        this.target = target;
        this.intercepterClass = intercepterClass;
    }

    public static Object bind(Object target, String intercepterClass) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new IntercepJDKProxy(target, intercepterClass));
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(intercepterClass==null)
            return method.invoke(target,args);

        Object result=null;
        //拦截器
        Interceptor interceptor= (Interceptor) getClass().forName(intercepterClass).newInstance();
        if( interceptor.before(proxy,target,method,args) ){
            result=method.invoke(target,args);
        }else{
            interceptor.around(proxy,target,method,args);
        }
        interceptor.after(proxy,target,method,args);
        return result;
    }
}
