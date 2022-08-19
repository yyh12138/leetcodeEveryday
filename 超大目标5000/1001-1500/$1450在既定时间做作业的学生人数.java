/**
 * 输入：startTime = [1,2,3], endTime = [3,2,7], queryTime = 4   输出：1
 * 解释：一共有 3 名学生。
 * 第一名学生在时间 1 开始写作业，并于时间 3 完成作业，在时间 4 没有处于做作业的状态。
 * 第二名学生在时间 2 开始写作业，并于时间 2 完成作业，在时间 4 没有处于做作业的状态。
 * 第三名学生在时间 3 开始写作业，预计于时间 7 完成作业，这是是唯一一名在时间 4 时正在做作业的学生。
 *
 * 返回能够使 queryTime 处于区间 [startTime[i], endTime[i]]（含）的学生人数。
 */
public class $1450在既定时间做作业的学生人数 {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for (int i = 0; i < endTime.length; i++) {
            if (startTime[i]<=queryTime && queryTime<=endTime[i]) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new $1450在既定时间做作业的学生人数().busyStudent(new int[]{1,2,3}, new int[]{3,2,7},4));
    }
}
