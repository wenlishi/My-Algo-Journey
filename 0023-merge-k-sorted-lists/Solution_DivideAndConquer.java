public class Solution_DivideAndConquer {
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
        return merge(lists, 0, lists.length - 1);
    }

    // 分治递归方法：将问题分解为更小的子问题
    public ListNode merge(ListNode[] lists, int left, int right) {
        // 计算当前区间的中间位置（防止整数溢出的安全写法）
        int mid = left + (right - left) / 2;
        // 递归终止条件：当左右索引相同时，说明只有一个链表，直接返回
        if (left == right) return lists[left];
        // 递归分解：将问题分成左右两部分
        ListNode list1 = merge(lists, left, mid);
        ListNode list2 = merge(lists, mid + 1, right);
        // 合并结果：将解决后的两个子问题合并成最终结果
        return mergeTwoLists(list1, list2);
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
