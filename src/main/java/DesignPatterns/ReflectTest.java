package DesignPatterns;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br>
 * 〈反射〉
 *
 * @author fy
 * @create 2018/10/30
 */
public class ReflectTest {

    public static void main(String[] args) {
//        ReflectInfo reflectInfo=reflectClassNoCont();
        ReflectInfo reflectInfo1=reflectClassCont("冯","女");

//        testReflectMethod(reflectInfo1);

//        Target target= (Target) reflectInfo1;
//        testReflectMethod(target);

    }

//    private static void testReflectMethod(Target target) {
//        try {
//            Method method=target.getClass().getMethod("sayHi");
//            try {
//                method.invoke(target);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 方法反射
     * @param reflectInfo1
     */
    private static void testReflectMethod(ReflectInfo reflectInfo1) {
//        Target target=
        try {
            Method method=reflectInfo1.getClass().getMethod("sayHello", String.class);
            try {
                method.invoke(reflectInfo1,"飞");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     *  有参构造函数
     * @param name
     * @param sex
     * @return
     */
    private static ReflectInfo reflectClassCont(String name, String sex) {
        ReflectInfo reflectInfo=null;

        try {
            reflectInfo= (ReflectInfo) Class.forName("DesignPatterns.ReflectInfo").getConstructor(String.class,String.class).newInstance(name,sex);
            Method method=reflectInfo.getClass().getMethod("sayHello", String.class);
            method.invoke(reflectInfo,"飞哥");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return  reflectInfo;
    }

    /**
     * 反射类(无参)
     */
    private static ReflectInfo reflectClassNoCont() {
        ReflectInfo reflectInfo = null;
        try {
            reflectInfo= (ReflectInfo) Class.forName("DesignPatterns.ReflectInfo").newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return reflectInfo;
    }
}
