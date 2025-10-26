

public class Solution_Traversal {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
 
    public ListNode deleteDuplicates(ListNode head) {
        // 处理特殊情况
        if (head == null) {
            return head;
        }
        // 使用遍历的方法删除重复元素
        // 设定一个指针cur，初始时指向head
        ListNode cur = head;
        // 当cur的下一个结点不为空的时候，循环继续
        while (cur.next != null) {
            // 如果cur和cur的下一个结点的值相同，说明有重复的元素
            if (cur.val == cur.next.val) {
                // 删除下一个结点
                cur.next = cur.next.next;
            } else {
                // 否则，cur指针向后移动一位
                cur = cur.next;
            }
        }
        // 返回处理后的链表的头结点    
        return head;
    }
    
}
