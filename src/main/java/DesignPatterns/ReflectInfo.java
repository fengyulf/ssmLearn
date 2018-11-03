package DesignPatterns;

/**
 * 〈一句话功能简述〉<br>
 * 〈需反射的类〉
 *
 * @author fy
 * @create 2018/10/30
 */
public class ReflectInfo {

    public String name;
    public String sex;

    public ReflectInfo(){

    }

    public ReflectInfo(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public void sayHello(String nm){
        System.out.println(nm+"向"+name+"sayHello");
    }

    public void sayHi(){
        System.out.println("向"+name+"sayHi");
    }
}
