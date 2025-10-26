import java.util.Arrays;

public class Solution_MyMethod {
    public int[] plusOne(int[] digits) {
        
        int len = digits.length;
        int[] res = new int[len + 1];
        int add = digits[len - 1] + 1;
        // 如果小于10，就不需要进位
        if (add < 10) {
            digits[len - 1] = add;
            return digits;
        }
        // 如果相加等于10，就需要进位
        int carry = 1;
        for (int i = len; i > 0; i--) {
            res[i] = (digits[i - 1] + carry) % 10 ;
            carry = (digits[i - 1] + carry) / 10;
        }
        if (carry != 0) {
            res[0] = 1;
        }
        if (res[0] != 0) {
            return res;
        }
        int[] newRes = Arrays.copyOfRange(res, 1, res.length);
        return newRes;
       //return res;
    }
}
