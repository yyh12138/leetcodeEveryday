import java.util.Arrays;
import java.util.Collections;

/**
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 * 输入：piles = [30,11,23,4,20], h = 5
 * 输出：30
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 */
public class $875爱吃香蕉的珂珂 {

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        int k = high;
        while (low < high) {
            int speed = (high - low) / 2 + low;
            long time = getTimeByK(piles, speed);
            if (time <= h) {
                k = speed;
                high = speed;
            } else {
                low = speed + 1;
            }
        }
        return k;
    }
    // 以k根/小时的速度，返回所需时间
    private int getTimeByK(int[] piles, int k) {
        int h = 0;
        for (int i = 0; i < piles.length; i++) {
            int num = piles[i];
            if (num<=k) {
                h++;
            }else {
                h += num/k;
                if (num%k!=0) {
                    h++;
                }
            }
        }
        return h;
    }

    public static void main(String[] args) {
        System.out.println(new $875爱吃香蕉的珂珂().minEatingSpeed(new int[]{3,6,7,11}, 8));
    }
}
