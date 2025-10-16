# My Algo Journey

此代码库记录了我的 LeetCode 算法与数据结构学习之旅。它不仅是我的个人解题日志，更是日后参考的知识宝库，旨在不断磨练逻辑思维，精进编程技艺。

## Progress

| # | Title | Solution | Difficulty | Notes |
|---|---|---|---|---|
| 0020 | [Valid Parentheses](https://leetcode.com/problems/Valid-Parentheses/) | [Java(Stackandmap)](0020-Valid-Parentheses/Solution_StackAndMap.java), [Java(Stackonly)](0020-Valid-Parentheses/Solution_StackOnly.java) | Easy | 使用栈（Stack）是解决此问题的经典方法。遍历字符串，遇到左括号入栈，遇到右括号则与栈顶元素匹配出栈。 |
| 0021 | [Merge Two Sorted Lists](https://leetcode.com/problems/Merge-Two-Sorted-Lists/) | [Java(Iteration)](0021-Merge-Two-Sorted-Lists/Solution_Iteration.java), [Java(Recursion)](0021-Merge-Two-Sorted-Lists/Solution_Recursion.java) | Easy | 迭代法使用虚拟头节点（dummy node）简化链表操作；递归法则代码更简洁。 |
| 0022 | [Generate Parentheses](https://leetcode.com/problems/Generate-Parentheses/) | [Java(Pruningbacktrack)](0022-Generate-Parentheses/Solution_PruningBacktrack.java), [Java(Recursion)](0022-Generate-Parentheses/Solution_Recursion.java) | Medium | 回溯法是解决此问题的标准解法。通过剪枝优化：当左括号数量未满n时可添加 '('；当右括号数量小于左括号时可添加 ')'，从而确保所有组合都有效。 |
| 0023 | [Merge K Sorted Lists](https://leetcode.com/problems/Merge-K-Sorted-Lists/) | [Java(Sequentialmerge)](0023-Merge-K-Sorted-Lists/Solution_SequentialMerge.java) | Hard |  |