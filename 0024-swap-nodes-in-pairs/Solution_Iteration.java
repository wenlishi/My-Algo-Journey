public class Solution_Iteration {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode (){}
        ListNode (int val) {this.val = val;}
        ListNode (int val , ListNode next) {this.val = val; this.next = next;}

    }
    public ListNode swapParis(ListNode head){

        // 创建一个虚拟头节点，其next指向原链表头节点
        // 这样可以统一处理头节点交换的情况，避免特殊处理
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;

        //
        // 循环条件：确保后面至少有两个节点可以交换
        // temp.next != null 检查第一个节点是否存在
        // temp.next.next != null 检查第二个节点是否存在
        while (temp.next != null && temp.next.next != null) {
            // 标记要交换的两个节点
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;

            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            // 这步很关键，是将temp结点向后移动两个结点的位置
            // 就是将temp指针移动到交换后的第一个节点(即原来的node1)
            // 因为此时node1和node2已经交换位置，node1现在在第二的位置
            // 这样temp就指向了下一对要交换节点的前一个节点
            temp = node1;

        }

        return dummy.next;
    }
    
}
