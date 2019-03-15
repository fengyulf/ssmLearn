package math;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈队列〉
 * 6 4 3 8 1 2 7 9 5
 * @author fy
 * @create 2018/11/21
 */
public class QueueTest {

    private static String delqq="631758924";

    public static void main(String[] args) {
//        System.out.println(Long.parseLong(new Date().getTime())+"");
        getQQ();
    }

    private static void getQQ() {
//  6 3 1 7 5 8 9
//        6  4 3  8  1  2 7  9  5
        long start = System.currentTimeMillis();
        List<String> list=getList();
        for(int i=0;list.size()>i;i++){
//            list.
        }


        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }

    private static List<String> getList() {
        List<String> list=new ArrayList<String>();
        list.add("6");
        list.add("4");
        list.add("3");
        list.add("8");
        list.add("1");
        list.add("2");
        list.add("7");
        list.add("9");
        list.add("5");
        return list;
    }
}
