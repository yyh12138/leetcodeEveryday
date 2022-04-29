import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 */
public class $119杨辉三角 {

    List<Integer> res = new ArrayList<>();
    public List<Integer> getRow(int rowIndex) {
        res.add(1);
        if (rowIndex==0) {
            return res;
        }
        res.add(1);
        dfs(rowIndex, 1);
        return res;
    }

    private void dfs(int rowIndex, int now) {
        if (now==rowIndex) {
            return;
        }else {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for (int i = 0; i < now; i++) {
                tmp.add(res.get(i) + res.get(i+1));
            }
            tmp.add(1);
            res = tmp;
            dfs(rowIndex, ++now);
        }
    }

    public static void main(String[] args) {
        System.out.println(new $119杨辉三角().getRow(3));
    }
}
