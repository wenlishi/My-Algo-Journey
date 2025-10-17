# My Algo Journey

此代码库记录了我的 LeetCode 算法与数据结构学习之旅。它不仅是我的个人解题日志，更是日后参考的知识宝库，旨在不断磨练逻辑思维，精进编程技艺。

## Progress

| # | Title | Solution | Difficulty | Notes |
|---|---|---|---|---|
| 0020 | [Valid Parentheses](https://leetcode.cn/problems/Valid-Parentheses/) | [Java(Stackandmap)](0020-Valid-Parentheses/Solution_StackAndMap.java), [Java(Stackonly)](0020-Valid-Parentheses/Solution_StackOnly.java) | Easy | 使用栈（Stack）是解决此问题的经典方法。遍历字符串，遇到左括号入栈，遇到右括号则与栈顶元素匹配出栈。 |
| 0021 | [Merge Two Sorted Lists](https://leetcode.cn/problems/Merge-Two-Sorted-Lists/) | [Java(Iteration)](0021-Merge-Two-Sorted-Lists/Solution_Iteration.java), [Java(Recursion)](0021-Merge-Two-Sorted-Lists/Solution_Recursion.java) | Easy | 迭代法使用虚拟头节点（dummy node）简化链表操作；递归法则代码更简洁。 |
| 0022 | [Generate Parentheses](https://leetcode.cn/problems/Generate-Parentheses/) | [Java(Pruningbacktrack)](0022-Generate-Parentheses/Solution_PruningBacktrack.java), [Java(Recursion)](0022-Generate-Parentheses/Solution_Recursion.java) | Medium | 回溯法是解决此问题的标准解法。通过剪枝优化：当左括号数量未满n时可添加 '('；当右括号数量小于左括号时可添加 ')'，从而确保所有组合都有效。 |
| 0023 | [Merge K Sorted Lists](https://leetcode.cn/problems/Merge-K-Sorted-Lists/) | [Java(Bruteforce)](0023-Merge-K-Sorted-Lists/Solution_BruteForce.java), [Java(Divideandconquer)](0023-Merge-K-Sorted-Lists/Solution_DivideAndConquer.java), [Java(Priorityqueue)](0023-Merge-K-Sorted-Lists/Solution_PriorityQueue.java), [Java(Sequentialmerge)](0023-Merge-K-Sorted-Lists/Solution_SequentialMerge.java) | Hard | 暴力法​​直接收集排序，简单但低效；​​顺序合并法​​通过两两合并简化问题，易于理解；​​分治法​​应用归并思想，达到O(N log k)最优时间复杂度，稳定可靠；​​优先队列法​​利用最小堆动态获取最小值，代码简洁，面试首选。 |
| 0024 | [Swap Nodes In Pairs](https://leetcode.cn/problems/Swap-Nodes-In-Pairs/) | [Java(Iteration)](0024-Swap-Nodes-In-Pairs/Solution_Iteration.java), [Java(Recursion)](0024-Swap-Nodes-In-Pairs/Solution_Recursion.java) | Medium | 迭代法可借助虚拟头节点，通过指针操作两两交换节点。递归法则将问题分解为“交换当前两个节点”和“处理剩余链表”的子问题，逻辑更清晰。 |
| 0025 | [Reverse Nodes In K Group](https://leetcode.cn/problems/Reverse-Nodes-In-K-Group/) | [Java(Iteration)](0025-Reverse-Nodes-In-K-Group/Solution_Iteration.java) | Hard | “反转链表”的升级版。核心思路是分组处理，然后将其与前后部分连接起来。需要精细控制多个指针。 |
| 0026 | [Remove Duplicates From Sorted Array](https://leetcode.cn/problems/Remove-Duplicates-From-Sorted-Array/) | [Java(Fastslowpointer)](0026-Remove-Duplicates-From-Sorted-Array/Solution_FastSlowPointer.java) | Easy | 使用双指针解法--快慢指针。 |