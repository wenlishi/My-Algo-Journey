import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_BruteForce {
    public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 暴力解法：收集所有节点值，排序后重新构建链表
    public ListNode mergeKLists(ListNode[] lists) {

        // 错误的顺序 - 如果lists为null，会先执行lists.length导致空指针异常
        // if (lists.length == 0 || lists == null) {
        //     return null;
        // }

        // 正确的写法 - 先检查null，再检查长度
        if (lists == null || lists.length == 0) {
            return null;
        }
        List<Integer> allValues = new ArrayList<>();
        // 1.收集所有节点的值
        for (ListNode list : lists) {
            ListNode current = list;
            while (current != null) {
                allValues.add(current.val);
                current = current.next;
            }
         
        }

        if (allValues.isEmpty()) return null;

        // 2.对值进行排序
        Collections.sort(allValues);

        // 3.根据排序后的值构建新链表
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        for (int value : allValues) {
            current.next = new ListNode(value);
            current = current.next;
        }
        // 返回真实头结点
        return dummy.next;
    }




    public static void main(String[] args) {
        Solution_BruteForce solution = new Solution_BruteForce();
        
        // 测试用例1: 正常情况
        System.out.println("=== 测试用例1: 正常链表数组 ===");
        ListNode[] lists1 = createTestLists();
        ListNode result1 = solution.mergeKLists(lists1);
        printList("合并结果", result1);
        
        // 测试用例2: 空数组
        System.out.println("\n=== 测试用例2: 空数组 ===");
        ListNode[] lists2 = new ListNode[0];
        ListNode result2 = solution.mergeKLists(lists2);
        System.out.println("空数组结果: " + result2);
        
        // 测试用例3: 包含空链表的数组
        System.out.println("\n=== 测试用例3: 包含空链表 ===");
        ListNode[] lists3 = new ListNode[]{null, createList(new int[]{1, 3, 5}), null};
        ListNode result3 = solution.mergeKLists(lists3);
        printList("包含空链表的结果", result3);
        
        // 测试用例4: 所有链表都为空
        System.out.println("\n=== 测试用例4: 所有链表为空 ===");
        ListNode[] lists4 = new ListNode[]{null, null, null};
        ListNode result4 = solution.mergeKLists(lists4);
        System.out.println("全空数组结果: " + result4);
        
        // 测试用例5: 单个链表
        System.out.println("\n=== 测试用例5: 单个链表 ===");
        ListNode[] lists5 = new ListNode[]{createList(new int[]{2, 4, 6})};
        ListNode result5 = solution.mergeKLists(lists5);
        printList("单个链表结果", result5);
    }
    
    // 创建测试链表数组
    private static ListNode[] createTestLists() {
        ListNode list1 = createList(new int[]{1, 4, 5});
        ListNode list2 = createList(new int[]{1, 3, 4});
        ListNode list3 = createList(new int[]{2, 6});
        return new ListNode[]{list1, list2, list3};
    }
    
    // 根据数组创建链表
    private static ListNode createList(int[] values) {
        if (values == null || values.length == 0) return null;
        
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        
        return dummy.next;
    }
    
    // 打印链表
    private static void printList(String message, ListNode head) {
        System.out.print(message + ": ");
        if (head == null) {
            System.out.println("null");
            return;
        }
        
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
    
}
