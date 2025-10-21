
public class Solution_Xor {
    // 使用异或操作
    // 利用异或操作的性质
    // a ^ a = 0; 0 ^ a = a
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
    
}
