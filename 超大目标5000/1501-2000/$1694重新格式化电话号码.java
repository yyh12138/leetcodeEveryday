/**
 * number 由数字、空格 ' '、和破折号 '-' 组成。
 *     首先，删除 所有的空格和破折号。
 *     其次，将数组从左到右 每 3 个一组 分块，直到 剩下 4 个或更少数字。剩下的数字将按下述规定再分块：
 *         2 个数字：单个含 2 个数字的块。
 *         3 个数字：单个含 3 个数字的块。
 *         4 个数字：两个分别含 2 个数字的块。
 * 最后用破折号将这些块连接起来。注意，重新格式化过程中 不应该 生成仅含 1 个数字的块，并且 最多 生成两个含 2 个数字的块。
 *
 * 输入：number = "1-23-45 6"   输出："123-456"
 * 解释：数字是 "123456"
 * 步骤 1：共有超过 4 个数字，所以先取 3 个数字分为一组。第 1 个块是 "123" 。
 * 步骤 2：剩下 3 个数字，将它们放入单个含 3 个数字的块。第 2 个块是 "456" 。
 * 连接这些块后得到 "123-456"
 */
public class $1694重新格式化电话号码 {

    public String reformatNumber(String number) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (c==' ' || c=='-') {
                continue;
            }
            str.append(c);
        }
        int len = str.length();
        for (int i = 1; i <= Math.ceil((double)(len-4)/3); i++) {
            str.insert(3*i+i-1, '-');
        }
        int remain = str.length() - str.lastIndexOf("-") - 1;
        if (remain==4) {
            str.insert(str.length()-2, '-');
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new $1694重新格式化电话号码().reformatNumber("1-23-45 67"));
    }
}
