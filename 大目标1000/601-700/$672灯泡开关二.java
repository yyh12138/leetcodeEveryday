import java.util.ArrayList;
import java.util.List;

/**
 * 房间中有 n 只已经打开的灯泡，编号从 1 到 n 。墙上挂着 4 个开关 。
 * 这 4 个开关各自都具有不同的功能，其中：
 *     开关 1 ：反转当前所有灯的状态（即开变为关，关变为开）
 *     开关 2 ：反转编号为偶数的灯的状态（即 2, 4, ...）
 *     开关 3 ：反转编号为奇数的灯的状态（即 1, 3, ...）
 *     开关 4 ：反转编号为 j = 3k + 1 的灯的状态，其中 k = 0, 1, 2, ...（即 1, 4, 7, 10, ...）
 * 你必须 恰好 按压开关 presses 次。每次按压，你都需要从 4 个开关中选出一个来执行按压操作。
 * 给你两个整数 n 和 presses ，执行完所有按压之后，返回 不同可能状态 的数量。
 *
 * 输入：n = 2, presses = 1    输出：3
 * 解释：状态可以是：
 * - 按压开关 1 ，[关, 关]
 * - 按压开关 2 ，[开, 关]
 * - 按压开关 3 ，[关, 开]
 */
public class $672灯泡开关二 {
    /**
     * 所有的操作进行偶数次是会抵消的，那么所有操作只存在0,1两种，即无效果和有效果
     * 且各一次操作2,3等效为一次操作1
     * 画一个真值表，可以推出n>=3且p>=3时,结果只会是8；
     * 接下来考虑个别情况即可。
     */
    public int flipLights(int n, int presses) {
        if(presses==0) {
            return 1;
        }
        if(n==1) {
            return 2;
        }
        if(n==2) {
            return (presses==1)?3:4;
        }
        return (presses>2)?8:(presses==1)?4:7;
    }

    public static void main(String[] args) {
        System.out.println(new $672灯泡开关二().flipLights(2, 1));
    }
}
