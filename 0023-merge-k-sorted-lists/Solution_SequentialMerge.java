public class Solution_SequentialMerge {
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // 顺序合并：循环将链表两两合并
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
        
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
                current = current.next;
            } else {
                current.next = list2;
                list2 = list2.next;
                current = current.next;
            }
        };
        // 处理剩余的链表
        current.next = list1 != null ? list1 : list2;
        return dummy.next;
    }
    
}
