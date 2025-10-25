public class Solution_CycleFormationAndBreakApproach {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode current = head;
        // 记录链表长度
        int len = 1;
        while (current.next != null) {
            len++;
            current = current.next;
        }
        // 处理偏移为0的情况
        if (k % len == 0) {
            return head;
        }
        // 这一步将链表的末节点和链表的头节点相连成环
        current.next = head;
        // 计算偏移量
        int offset = len - k % len;
        current = head;
        for (int i = 0; i < offset - 1; i++) {
            current = current.next;
        }
        head = current.next;
        // 解开链表环
        current.next = null;
        return head;
    }
}