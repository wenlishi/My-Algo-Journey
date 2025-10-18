public class Solution_Recursion {
     // 1. 将 ListNode 声明为 static 内部类，方便在 main 方法中直接使用
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {this.val = val; this.next = next;}


    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 递归法
        //终止条件：其中一个链表为空时，返回另一个
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        // 递归逻辑
        if (list1.val < list2.val) {
            // list1的头节点更小，将其作为新头节点
            // 它的next指针指向“list1的剩余部分”和“list2”的合并结果
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
        
    }
    
    // 打印链表的辅助函数
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println("null");

    }

    // 编写main方法进行测试
    public static void main(String[] args) {
        // 创建类示例
        Solution_Recursion solution = new Solution_Recursion();
        // -------测试用例1---------
        // 创建第一个链表1->2->4
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        // 创建第二个链表1->3->4
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        System.out.println("输入 List 1: ");
        printList(list1);
        System.out.println("输入 List 2: ");
        printList(list2);

        // 调用合并方法
        ListNode mergedList = solution.mergeTwoLists(list1, list2);
        // 打印合并后的结果
        System.out.print("合并结果:   ");
        printList(mergedList);
        System.out.println(); // 换行

        // --- 测试用例 2 (包含空链表) ---
        System.out.println("--- 测试用例 2 ---");
        ListNode list3 = new ListNode(5, new ListNode(6));
        ListNode list4 = null;

        System.out.print("输入 List 3: ");
        printList(list3);
        System.out.print("输入 List 4: ");
        printList(list4);

        ListNode mergedList2 = solution.mergeTwoLists(list3, list4);
        System.out.print("合并结果:   ");
        printList(mergedList2);
    }


    
}
