import java.util.ArrayList;
import java.util.List;

/**
 * 输入：root = [4,1,3,null,null,2], val = 5
 * 输出：[5,4,null,1,3,null,null,2]
 * 解释：a = [1,4,2,3], b = [1,4,2,3,5]
 */
public class $998最大二叉树二 {

    List<Integer> list = new ArrayList<>();
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        inOrder(root);
        list.add(val);
        return construct(list);
    }

    private void inOrder(TreeNode root) {
        if(root==null) {
            return ;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    private TreeNode construct(List<Integer> nums) {
        if (nums.size()==0) {
            return null;
        }
        int i = findMax(nums);
        TreeNode root = new TreeNode();
        root.val = nums.get(i);
        root.left = construct(nums.subList(0, i));
        root.right = construct(nums.subList(i+1, nums.size()));
        return root;
    }

    private int findMax(List<Integer> nums) {
        int max = -1, index = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (max < nums.get(i)) {
                max = nums.get(i);
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(1),
                                            new TreeNode(3,new TreeNode(2),null));
        TreeNode treeNode = new $998最大二叉树二().insertIntoMaxTree(root, 5);
        treeNode.print();
    }
}
