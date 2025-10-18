public class Solution_Recursion {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    // 辅助方法：将数组转换为链表
    public static ListNode arrayToList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    // 辅助方法：将链表转换为字符串用于打印
    public static String listToString(ListNode head) {
        if (head == null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append("->");
            head = head.next;
        }
        sb.append("]");
        return sb.toString();
    }

    // 正确的 main 方法
    public static void main(String[] args) {
        Solution_Recursion solution = new Solution_Recursion();
        
        // 测试用例1：正常链表 [1,2,3,4]
        System.out.println("测试用例 1:");
        ListNode list1 = arrayToList(new int[]{1, 2, 3, 4});
        System.out.println("原始链表: " + listToString(list1));
        ListNode result1 = solution.swapPairs(list1);
        System.out.println("交换后: " + listToString(result1));
        System.out.println("预期: [2->1->4->3]");
        System.out.println();
        
        // 测试用例2：空链表
        System.out.println("测试用例 2:");
        ListNode list2 = null;
        System.out.println("原始链表: " + listToString(list2));
        ListNode result2 = solution.swapPairs(list2);
        System.out.println("交换后: " + listToString(result2));
        System.out.println("预期: []");
        System.out.println();
        
        // 测试用例3：单节点链表 [1]
        System.out.println("测试用例 3:");
        ListNode list3 = arrayToList(new int[]{1});
        System.out.println("原始链表: " + listToString(list3));
        ListNode result3 = solution.swapPairs(list3);
        System.out.println("交换后: " + listToString(result3));
        System.out.println("预期: [1]");
        System.out.println();
        
        // 测试用例4：奇数个节点 [1,2,3]
        System.out.println("测试用例 4:");
        ListNode list4 = arrayToList(new int[]{1, 2, 3});
        System.out.println("原始链表: " + listToString(list4));
        ListNode result4 = solution.swapPairs(list4);
        System.out.println("交换后: " + listToString(result4));
        System.out.println("预期: [2->1->3]");
        System.out.println();
        
        // 测试用例5：两个节点 [1,2]
        System.out.println("测试用例 5:");
        ListNode list5 = arrayToList(new int[]{1, 2});
        System.out.println("原始链表: " + listToString(list5));
        ListNode result5 = solution.swapPairs(list5);
        System.out.println("交换后: " + listToString(result5));
        System.out.println("预期: [2->1]");
        System.out.println();
        
        // 测试用例6：五个节点 [1,2,3,4,5]
        System.out.println("测试用例 6:");
        ListNode list6 = arrayToList(new int[]{1, 2, 3, 4, 5});
        System.out.println("原始链表: " + listToString(list6));
        ListNode result6 = solution.swapPairs(list6);
        System.out.println("交换后: " + listToString(result6));
        System.out.println("预期: [2->1->4->3->5]");
    }
}