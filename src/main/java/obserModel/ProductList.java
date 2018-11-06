package obserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * 〈被观察者〉
 *
 * @author fy
 * @create 2018/11/6
 */
public class ProductList extends Observable{

    private List<String> productLists;

    private static ProductList productList;

    private ProductList() {
    }

    public static ProductList getInstanct(){
        if(productList==null){
            productList=new ProductList();
            productList.productLists=new ArrayList<String>();
        }
        return productList;
    }

    /**
     *  添加观察者
     * @param observer
     */
    public void addProductListObsever(Observer observer){
        this.addObserver(observer);
    }

    /**
     *  新增产品
     * @param product
     */
    public void addProductList(String product){
        this.productLists.add(product);
        System.out.println("产品列表新增了产品:"+product);
        this.setChanged();
        this.notifyObservers(product);
    }
}
