import java.util.*;

/**
 * 返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 * 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 *
 * 输入: root = [5,2,-3]
 * 输出: [2,-3,4]
 */
public class $508出现次数最多的子树元素和 {

    private int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[0];
        Map<Integer,Integer> map = new HashMap<>();
        helper(root,map);
        //然后求出map中value最大值对应的Key
        List<Integer> res = new LinkedList<>();
        for(Integer i : map.keySet()){
            if(map.get(i) == max) {
                res.add(i);
            }
        }
        int[] resArr = new int[res.size()];
        for(int i = 0;i < res.size();i++){
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    private int helper(TreeNode root, Map<Integer,Integer> map){
        if(root == null) {
            return 0;
        }
        //求出当前节点为根的元素和
        int left = helper(root.left,map);
        int right = helper(root.right,map);
        int val = left+right+root.val;
        map.put(val,map.getOrDefault(val,0)+1);
        max = Math.max(max,map.get(val));
        return val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(2,new TreeNode(-1), new TreeNode(10)),
                                    new TreeNode(-3, null, new TreeNode(-1)));
        System.out.println(Arrays.toString(new $508出现次数最多的子树元素和().findFrequentTreeSum(root)));
    }
}
