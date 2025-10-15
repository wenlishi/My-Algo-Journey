public class Solution_Iteration  {
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {this.val = val; this.next = next;}

    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // 创建虚拟头结点
        ListNode dummy =new ListNode(-1);
        ListNode current = dummy;

        // 循环比较，构建新的链表
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // 连接剩余部分
        current.next = list1 != null ? list1 : list2;
        return dummy.next;
    }
    
}
