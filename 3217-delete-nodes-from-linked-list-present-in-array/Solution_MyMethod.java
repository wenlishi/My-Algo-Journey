import java.util.HashSet;
import java.util.Set;

public class Solution_MyMethod {
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
 
    public ListNode modifiedList(int[] nums, ListNode head) {
        // 使用 HashSet 存储数组中的值，方便快速查找
        Set<Integer> hashSet = new HashSet<Integer>();
        for (int num : nums) {
            hashSet.add(num);
        }
        // 创建一个虚拟头结点，方便处理边界情况
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            // 如果当前结点在 hashSet 中，执行删除操作
            if (hashSet.contains(cur.val)) {
                pre.next = cur.next;
                cur.next = null;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
