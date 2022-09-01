import java.util.Arrays;

/**
 * 输入：prices = [8,4,6,2,3]   输出：[4,2,4,2,3]
 * 解释：
 * 商品 0 的价格为 price[0]=8 ，你将得到 prices[1]=4 的折扣，所以最终价格为 8 - 4 = 4 。
 * 商品 1 的价格为 price[1]=4 ，你将得到 prices[3]=2 的折扣，所以最终价格为 4 - 2 = 2 。
 * 商品 2 的价格为 price[2]=6 ，你将得到 prices[3]=2 的折扣，所以最终价格为 6 - 2 = 4 。
 * 商品 3 和 4 都没有折扣。
 */
public class $1475商品折扣后的最终价格 {

    public int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            int discount = 0;
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j]<=prices[i]) {
                    discount = prices[j];
                    break;
                }
            }
            res[i] += price - discount;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new $1475商品折扣后的最终价格().finalPrices(new int[]{10,1,1,6})));
    }
}
