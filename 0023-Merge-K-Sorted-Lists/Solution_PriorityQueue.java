import java.util.PriorityQueue;



public class Solution_PriorityQueue {

    public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        // 1. 创建优先队列（最小堆），并定义比较规则：根据节点的val值升序排列
        // 比较器 (a, b) -> a.val - b.val 表示值更小的节点优先级更高
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // 2. 初始化：将所有链表的非空头节点加入优先队列
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        // 3. 创建一个哑节点（Dummy Node），用于简化结果链表的构建过程
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy; // current指针用于构建新链表
        
        // 4. 核心循环：当优先队列不为空时，持续处理
        while (!minHeap.isEmpty()) {

            // 从堆顶取出当前最小的节点
            ListNode minNode = minHeap.poll();

            current.next = minNode;
            current = current.next;

            // 关键步骤：如果刚才被取出的节点后面还有节点，则将其后继节点加入优先队列
            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }

        }
        // 返回哑节点的下一个节点，即合并后新链表的真实头节点
        return dummy.next;
    }
}
