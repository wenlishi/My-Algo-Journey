import java.util.Deque;
import java.util.LinkedList;

public class Solution_Iteration {

        // 定义二叉树节点
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }
    public boolean isSymmetric(TreeNode root) {
        // 如果根结点是空的，就是对称的
        if (root == null) {
            return true;
        }
        // 使用队列来进行层序遍历，并成对比较
        Deque<TreeNode> queue = new LinkedList<>();
        // 初始时将根的左右结点入队
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            // 每次从队列中取出两个结点进行比较
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            // 如果两个结点都是为null，说明这一对是有效的对称，继续
            if (node1 == null && node2 == null) {
                continue;
            }
            // 如果只有一个为空，或者两个节点的值不相等，则不对称
            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }

            // 将结点的左右孩子入队
            // 关键：按镜像顺序将下一层的节点入队
            queue.offer(node1.left);
            queue.offer(node2.right);

            queue.offer(node1.right);
            queue.offer(node2.left);

        }
        // 如果循环正常结束，说明所有的对称位置的结点都是匹配的
        return true;
    }

}
