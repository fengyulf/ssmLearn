package obserModel;

import java.util.Observable;
import java.util.Observer;

/**
 * 〈一句话功能简述〉<br>
 * 〈JD观察者〉
 *
 * @author fy
 * @create 2018/11/6
 */
public class JDObserver implements Observer {

    public void update(Observable o, Object arg) {
        String newProduct= (String) arg;
        System.out.println("发送新产品到【"+arg+"】京东");
    }
}
