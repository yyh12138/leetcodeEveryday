import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * quality[i]表示第i名工人的工作质量，其最低期望工资为wage[i]。现在我们想雇佣k名工人
 *      1,对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。
 *      2,工资组中的每名工人至少应当得到他们的最低期望工资
 * 返回组成满足上述条件的付费群体所需的最小金额 。
 *
 * 输入： quality = [3,1,10,10,1], wage = [4,8,2,2,7], k = 3
 * 输出： 30.66667
 * 解释： 我们向 0 号工人支付 4，向 2 号和 3 号分别支付 13.33333。
 */
public class $857雇佣k名工人的最低成本 {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        // 用一个数组保存每名工人的情况，记录性价比。
        double[][] workers = new double[n][2];
        for (int i = 0; i < n; i++) {
            workers[i] = new double[] {(double) wage[i] / quality[i], (double) quality[i]};
        }
        // 保存的是预期工资和工作质量的比，越小性价比越高，
        // 按照第一个关键字升序排序。
        Arrays.sort(workers, (x, y) -> Double.compare(x[0], y[0]));
        double res = Double.MAX_VALUE;
        double sum = 0.0F;
        // 大顶堆保存当前选中的k个人的工作质量情况。性价比由低到高
        PriorityQueue<Double> heap = new PriorityQueue<>((x, y) -> Double.compare(y, x));
        for (double[] worker : workers) {
            // 如何计算 k 个人需要的最小工资？
            // 工人 x1, x2, x3...，他们的质量是 q(x1),q(x2),q(x3)...，期望是 e(x1), e(x2), e(x3)...，
            // 实际分配的为 f(x1), f(x2), f(x3)..，有 q(x1)/f(x1)=q(x2)/f(x2) = q(x3)/f(x3) = ... = c，
            // 则对于所有的 xk，有 q(x)/c = f(x) >= e(x)，...，即
            // q(x)/e(x) >= c，则要满足所有这样的，则要优先满足q(x)/e(x)最小，即满足性价比最低的，也就是当前的 worker[0]
            // 那么 worker[0] * sum 就可以满足所有的工人的最低需求了。
            if (heap.size() == k) {// 如果当前已经安排了k个人，先去掉质量最大来尽可能降低总质量
                sum -= heap.poll();
            }
            // 先将当前性价比最低的工人加入。
            sum += worker[1];
            heap.offer(worker[1]);
            if (heap.size() == k) {
                res = Math.min(res, sum * worker[0]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new $857雇佣k名工人的最低成本().mincostToHireWorkers(
                new int[] {3,1,10,10,1}, new int[] {4,8,2,2,7}, 3));
    }
}
