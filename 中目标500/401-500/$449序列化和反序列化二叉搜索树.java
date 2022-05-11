import java.util.*;
import java.util.stream.Collectors;

/**
 * 只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 *
 * 输入：root = [2,1,3]
 * 输出：[2,1,3]
 */

public class $449序列化和反序列化二叉搜索树 {

    public static void main(String[] args) {
        Codec ser = new Codec();
        Codec deser = new Codec();
        TreeNode root = new TreeNode(9,
                new TreeNode(3,null,null),
                new TreeNode(20,
                        new TreeNode(15,null,null),
                        new TreeNode(30,null,null)));
        String tree = ser.serialize(root);
        System.out.println(tree);
        TreeNode ans = deser.deserialize(tree);
        System.out.println(ans);
    }
}

class Codec {
    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        String str = list.toString();
        return str.substring(1, str.length() - 1);
    }
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] arr = data.split(", ");
        Deque<Integer> stack = new ArrayDeque<>();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            stack.push(Integer.parseInt(arr[i]));
        }
        return construct(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
    }

    private void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

    private TreeNode construct(int lower, int upper, Deque<Integer> stack) {
        if (stack.isEmpty() || stack.peek() < lower || stack.peek() > upper) {
            return null;
        }
        int val = stack.pop();
        TreeNode root = new TreeNode(val);
        root.right = construct(val, upper, stack);
        root.left = construct(lower, val, stack);
        return root;
    }
}