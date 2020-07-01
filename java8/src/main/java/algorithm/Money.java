package algorithm;

/**
 * @Description: TODO
 * @author: zpli
 * @Date: 2020/5/29 17:04
 */
public class Money {

    public static void main(String[] args) {
        money(14);
    }

    public static void money(int total) {
        int[] moneys = new int[]{200, 100, 50, 20, 10, 5, 1};
        int result = 0;
        for (int i = 0; i < moneys.length; i++) {
            int use = total / moneys[i];
            result += use;
            total = total - use * moneys[i];
            System.out.println(String.format("需要面额为%d的%d张", moneys[i], use));
            System.out.println(String.format("还需支付%d金额", total));
        }
        System.out.println(String.format("总共需要支付%d张", result));
    }
}
