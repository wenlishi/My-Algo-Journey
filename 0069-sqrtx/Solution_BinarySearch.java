

public class Solution_BinarySearch {
    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        int ans = 0;
        while (left <= right) {
             // 等同于 (left + right)/2，但防止了left+right可能的大数溢出
            int mid = left + (right - left) / 2;
            // 使用除法而非乘法，防止 mid*mid 溢出
            if (mid <= x / mid) {
                ans = mid;  // 条件满足：mid可能是平方根，记录当前值
                left = mid + 1;// 尝试在右半区间[mid+1, right]寻找更大的平方根

            } else {
                // 条件不满足：mid² > x，说明平方根在左半区间
                // 调整右边界继续查找[left, mid-1]
                right = mid - 1;
            }
        }
        // 循环结束时，ans保存的是满足 n² <= x 的最大整数n
        return ans;
        
    }
}
