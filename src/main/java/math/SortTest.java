package math;

/**
 * 〈一句话功能简述〉<br>
 * 〈排序〉
 *
 * @author fy
 * @create 2018/11/20
 */
public class SortTest {
    private static int[] a = {5, 3, 4, 6, 8, 7, 2};

    public static void main(String[] args) {
//        bubblesTest(a);
//        fastTest(0, a.length - 1);
//        printString();
    }


    /**
     * 快速
     *
     * @param i 开始
     * @param j 结束
     */
    private static void fastTest(int i, int j) {
        if (i > j) return;
        int left=i;
        int right=j;
        int temp = a[left];
        //数组交换位置中间量
        int change;
        while (i!=j) {
            while (temp <= a[j] && i < j)
                j--;
            while (temp >= a[i] && i < j)
                i++;
            if(i<j){
                change=a[i];
                a[i]=a[j];
                a[j]=change;
            }
        }
        a[left]=a[i];
        a[i]=temp;
        fastTest(left, i - 1);
        fastTest(j + 1, right);
    }


    /**
     * 冒泡
     *
     * @param a
     */
    private static void bubblesTest(int[] a) {
        int change;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] < a[j + 1]) {
                    change = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = change;
                }
            }
        }
        printString();
    }

    private static void printString() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < a.length; i++) {
            buffer.append(a[i]).append("  ");
        }
        System.out.println(buffer.toString());
    }

}
