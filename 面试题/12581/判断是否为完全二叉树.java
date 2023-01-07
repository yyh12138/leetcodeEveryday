public class 判断是否为完全二叉树 {

    boolean isSTree(TreeNode root) {


        return true;
    }

    public int maxOfNums(int[] nums, int i) {
        if (i<nums.length) {
            return Math.max(nums[i], maxOfNums(nums, ++i));
        }else {
            return Integer.MIN_VALUE;
        }
    }

    public void count(TreeNode root) {
        if (root==null) {
            return;
        }
        int l = high(root.left);
        int r = high(root.right);
        int count = l-r;
        System.out.println(root.val + ": " + count);
        count(root.left);
        count(root.right);
    }
    int high(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int l = high(root.left);
        int r = high(root.right);
        if (l>r) {
            return l+1;
        }else {
            return r+1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2,new TreeNode(4),new TreeNode(5)),
                                            new TreeNode(3,new TreeNode(6),null));
        new 判断是否为完全二叉树().count(root);
//        System.out.println(new 判断是否为完全二叉树().maxOfNums(new int[]{1,9,2,7,4}, 0));
    }
}
