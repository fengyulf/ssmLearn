package responModel;

import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br>
 * 〈拦截器3〉
 *
 * @author fy
 * @create 2018/11/6
 */
public class MyInterceptor3 implements Interceptor {
    public MyInterceptor3() {
        System.out.println("这是【拦截器3】的构造器");
    }

    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("这是【拦截器3】的before方法");
        return true;
    }

    public void around(Object proxy, Object target, Method method, Object[] args) {

    }

    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("这是【拦截器3】的after方法");
    }
}
