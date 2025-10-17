public class Solution_Iteration {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode (){}
        ListNode (int val) {this.val = val;}
        ListNode (int val , ListNode next) {this.val = val; this.next = next;}

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        // 1.先统计链表的结点个数
        int count = 0;
        while (current.next != null) {
            count++;
            current = current.next;
        }
        // 统计组数
        int groups = count / k;
        ListNode prevGroupEnd = dummy; // 上一组的末尾节点
        for (int i = 0; i < groups; i++) {
            ListNode groupStart = prevGroupEnd.next;
            ListNode groupEnd = groupStart;
            // 找到当前组的结束结点
            for (int j = 1; j < k; j++) {
                groupEnd = groupEnd.next;
            }
            // 记录下一组的开始位置
            ListNode nextGroupStart = groupEnd.next; 
            // 断开当前组和下一组的连接，方便单独进行反转
            groupEnd.next = null;
            ListNode currGroupHead = reverseList(groupStart);
            // 上一组的末尾指向反转后的头结点
            prevGroupEnd.next = currGroupHead;
            // 翻转后的新尾（原groupStart）指向下一组
            groupStart.next = nextGroupStart; 
            // 更新prevGroupEnd为当前组翻转后的尾节点（即翻转前的groupStart）
            prevGroupEnd = groupStart;
        }
        return dummy.next;
    }

     // 辅助函数：翻转一个链表，返回翻转后的头节点
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;

        }
        return prev;
    }
    
}
