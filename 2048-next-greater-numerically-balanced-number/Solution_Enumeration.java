public class Solution_Enumeration {
    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; ; i++) {
            if (isNumericallyBalanced(i)) {
                return i;
            }
        }
    }

    // 判断一个数字是否是数值平衡的
    private boolean isNumericallyBalanced(int num) {
        // 这里不使用哈希表，而是使用数组，因为数字范围是固定的0-9，所以数组的元素的index对应数字，value对应数字出现的次数
        int[] count = new int[10];
        while (num > 0) {
            count[num % 10]++;
            num /= 10;
        }
        for (int i = 1; i <= 9; i++) {
            if (count[i] != 0 && count[i] != i) {
                return false;
            }
        }
        return true;
    }
}