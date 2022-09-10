/**
 * 输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3
 * 输出：[3,2,null,1]
 *
 * 通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树不会改变保留在树中的元素的相对结构
 * (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。
 */
public class $669修剪二叉搜索树 {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        //下面两个if相当于删除不满足要求的节点
        if (root.val < L) {
            return trimBST(root.right, L, R);//返回修剪过的右子树。希望右子树能够满足要求，因为右子树的值大于当前根节点的值
        }
        if (root.val > R) {
            return trimBST(root.left, L, R);//返回修剪过的左子树，希望左子树能够满足要求，因为左子树的值小于当前根节点的值
        }
        //处理正常的节点
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(0, null, new TreeNode(2,new TreeNode(1),null)),
                                            new TreeNode(4));
        new $669修剪二叉搜索树().trimBST(root, 1, 3).print();
    }
}
