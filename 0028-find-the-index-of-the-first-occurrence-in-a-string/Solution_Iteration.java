public class Solution_Iteration {
    public int strStr(String haystack, String needle) {
        char[] hay = haystack.toCharArray();
        char[] nee = needle.toCharArray();
        int len = hay.length;
        int k = nee.length;
        
        // 主串从i开始匹配。优化：i只需遍历到len-k，因为后面长度不足
        for (int i = 0; i < len; i++) {
            // index为nee的索引
            // 每次循环都将index置0，因为每次循环都从needle起始位置逐个比较
            int index = 0;
            // 从当前第i个元素逐个和needle比较，比较hay[i,i+k]和nee是否一致
            if (hay[i] == nee[index]) {
                for (int j = i; j < len; j++) {
                    if (hay[j] == nee[index]) {
                        // 每次相等将index递增
                        index ++;
                    } else {
                        // 如果出现不相等的情况，立即退出循环
                        // 跳转到外层循环，开始从第i+1的元素和nee逐个比较
                        break;
                    }
                    // 当index == k，代表hay[i,i+k]和nee相等，比较完成，返回起始位置i
                    if (index == k) {
                        return i;
                    }
                }
            }
        }
        return -1; 
    }
}
