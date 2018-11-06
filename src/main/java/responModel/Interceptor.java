package responModel;

import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br>
 * 〈拦截器〉
 *
 * @author fy
 * @create 2018/11/6
 */
public interface Interceptor {
    public boolean before(Object proxy, Object target, Method method, Object[]
            args);

    public void around(Object proxy, Object target, Method method, Object[]
            args);

    public void after(Object proxy, Object target, Method method, Object[]
            args);
}
