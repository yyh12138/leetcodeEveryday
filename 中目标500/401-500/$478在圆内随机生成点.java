import java.util.Arrays;

/**
 * 输入:
 * ["Solution","randPoint","randPoint","randPoint"]
 * [[1.0, 0.0, 0.0], [], [], []]
 * 输出: [null, [-0.02493, -0.38077], [0.82314, 0.38945], [0.36572, 0.17248]]
 * 解释:
 * Solution solution = new Solution(1.0, 0.0, 0.0);
 * solution.randPoint ();//返回[-0.02493，-0.38077]
 * solution.randPoint ();//返回[0.82314,0.38945]
 * solution.randPoint ();//返回[0.36572,0.17248]
 *
 */
public class $478在圆内随机生成点 {

    double r, x, y;

    public $478在圆内随机生成点(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
    }

    public double[] randPoint() {
        double random_r = Math.sqrt(Math.random() * Math.pow(r, 2)); // 要求产生随机均匀点
        double random_θ = Math.random() * 2 * Math.PI;
        double random_x = x + random_r*Math.cos(random_θ);
        double random_y = y + random_r*Math.sin(random_θ);
        return new double[]{random_x, random_y};
    }

    public static void main(String[] args) {
        $478在圆内随机生成点 a = new $478在圆内随机生成点(1.0, 0.0, 0.0);
        System.out.println(Arrays.toString(a.randPoint()));
        System.out.println(Arrays.toString(a.randPoint()));
        System.out.println(Arrays.toString(a.randPoint()));
    }
}
