

public class Solution_Recursion {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 如果两个结点都为空，说明相同
        if (p == null && q == null) {
            return true;
        }
        // 如果只有一个结点为空，说明不相同
        if (p == null || q == null) {
            return false;
        }
        // 如果两个结点的值不等，说明不相同
        if (p.val != q.val) {
            return false;
        }
        // 递归比较左子树和右子树
        return isSameTree(p.left, q.left) &&  isSameTree(p.right, q.right); 
    }
}
