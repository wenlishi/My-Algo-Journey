import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Soulution_Bfs {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            List<Integer> levelNodes = new ArrayList<>();
            // 记录当前层的结点个数
            int currentLevelSize = queue.size();
            // 循环处理一层的结点
            for (int i = 0; i < currentLevelSize; i++){
                TreeNode node = queue.poll();
                levelNodes.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 将一层结点加入结果
            res.add(levelNodes);         
        }
        return res;
    }
}
