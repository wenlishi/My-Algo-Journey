public class Solution_BitwiseDivision {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        // 为true，表示两个数是异号的
        // 2. 判断结果的符号
        boolean isNegative = (dividend > 0) ^ (divisor > 0);
        // 如果被除数为正数，则通过位运算取反加一转换为负数
        // 3. 将被除数和除数都转换为负数，避免溢出
        //  使用一元负号操作，代码更清晰
        dividend = (dividend > 0) ? -dividend : dividend;
        divisor = (divisor > 0) ? -divisor : divisor;


        int result = 0;
        while (dividend <= divisor) {
            int temp = divisor;
            int count = 1;
            while (temp >= (Integer.MIN_VALUE >> 1) && temp << 1 >= dividend) {
                temp <<= 1;
                count <<= 1;
            }
            dividend = dividend - temp;
            result += count;
            
        }
        return isNegative ? -result : result;
    }
}