package responModel;

import java.lang.reflect.Method;

/**
 * 〈拦截器1〉<br>
 * 〈〉
 *
 * @author fy
 * @create 2018/11/6
 */
public class MyInterceptor1 implements Interceptor {

    public MyInterceptor1() {
        System.out.println("这是【拦截器1】的构造器");
    }

    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("这是【拦截器1】的before方法");
        return true;
    }

    public void around(Object proxy, Object target, Method method, Object[] args) {

    }

    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("这是【拦截器1】的after方法");
    }
}
