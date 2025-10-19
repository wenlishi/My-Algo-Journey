import java.util.ArrayList;
import java.util.List;

public class Solution_Morris {

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

    /**
     * 使用 Morris 算法对二叉树进行中序遍历。
     * 核心优势：空间复杂度为 O(1)，时间复杂度为 O(n)。
     *
     * @param root 二叉树的根节点
     * @return 一个包含中序遍历结果的整数列表
     */

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // predecessor 变量用于寻找当前节点的前驱节点
        TreeNode predecessor = null;
        // 主循环，只要当前节点不为空就继续遍历
        while (root != null) {
            // --- 情况一：当前节点有左子树 ---
            if (root.left != null) {
                // 步骤 1: 寻找当前节点(root)的前驱节点。
                // 前驱节点是 root 左子树中“最右边”的节点。
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;

                }
                // 步骤 2: 根据前驱节点的 right 指针进行判断
                // 2.1 如果前驱节点的 right 指针为空，说明是第一次访问到这里
                if (predecessor.right == null) {
                    // 建立一个临时的“线索”或“桥梁”，将前驱节点的 right 指向当前节点。
                    // 这样在遍历完左子树后，就可以通过这个线索回来。
                    predecessor.right = root;
                    // 移动到左子节点，继续向左遍历
                    root = root.left;
                }
                // 2.2 如果前驱节点的 right 指针已经指向了当前节点
                // 说明左子树已经访问完了，我们需要断开链接
                else {
                    // 访问根节点 (按“左-根-右”的顺序，现在是访问“根”的时机)
                    res.add(root.val);
                    // 断开线索，恢复树的原始结构，避免死循环
                    predecessor.right = null;
                    // 左子树和根节点都已处理完毕，现在转向右子树
                    root = root.right;
                }
            }
     
            // 如果没有左子结点
            else {
                // 如果没有左子树，说明按“左-根-右”的顺序，可以直接访问“根”
                res.add(root.val);
                // 然后直接转向右子树
                root = root.right;
            }
           
        }
        // 返回最终的中序遍历结果
        return res;
    }
}