package obserModel;

/**
 * 〈观察者模式测试〉<br>
 * 〈〉
 *
 * @author fy
 * @create 2018/11/6
 */
public class ObserverTest {

    public static void main(String[] args) {
        ProductList productList=ProductList.getInstanct();
        productList.addProductList("123");
        productList.addObserver(new JDObserver());
        productList.addObserver(new TBObserver());
        productList.addProductList("456");
        productList.addProductList("789");
    }
}
