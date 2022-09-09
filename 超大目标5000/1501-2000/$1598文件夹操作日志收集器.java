/**
 * 输入：logs = ["d1/","d2/","../","d21/","./"]    输出：2
 * 解释：执行 "../" 操作变更文件夹 2 次，即可回到主文件夹
 *
 * 下面给出对变更操作的说明：
 *     "../" ：移动到当前文件夹的父文件夹。如果已经在主文件夹下，则 继续停留在当前文件夹 。
 *     "./" ：继续停留在当前文件夹。
 *     "x/" ：移动到名为 x 的子文件夹中。题目数据 保证总是存在文件夹 x 。
 * 给你一个字符串列表 logs ，其中 logs[i] 是用户在 ith 步执行的操作。
 * 文件系统启动时位于主文件夹，然后执行 logs 中的操作。
 * 执行完所有变更文件夹操作后，请你找出 返回主文件夹所需的最小步数 。
 */
public class $1598文件夹操作日志收集器 {

    public int minOperations(String[] logs) {
        int n = 0;
        for(String log : logs){
            if("./".equals(log)) {
                continue;
            }
            if("../".equals(log)) {
                n = n == 0 ? n : n-1;
            } else {
                n++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(new $1598文件夹操作日志收集器().minOperations(new String[] {
                "d1/","d2/","../","d21/","./"
        }));
    }
}
