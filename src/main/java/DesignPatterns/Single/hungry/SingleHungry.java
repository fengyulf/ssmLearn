package DesignPatterns.Single.hungry;

/**
 * 〈一句话功能简述〉<br>
 * 〈懒汉〉
 *
 * @author fy
 * @create 2018/12/19
 */
public class SingleHungry {


    public static final SingleHungry singleHungry= new SingleHungry();

    public static SingleHungry getInstance(){
        System.out.println(System.currentTimeMillis()+":"+singleHungry);
        return singleHungry;
    }


}
