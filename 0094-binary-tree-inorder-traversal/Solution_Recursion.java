import java.util.ArrayList;
import java.util.List;

public class Solution_Recursion {

    // TreeNode.java (可以定义在一个单独的文件或作为内部类)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }
    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        // 递归遍历左子树
        inorder(root.left, res);
        res.add(root.val);
        // 递归遍历右子树
        inorder(root.right, res);
    }
}