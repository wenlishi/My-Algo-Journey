public class Solution_BitOperation{
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        
        while (i >= 0 || j >= 0 || carry > 0) {
            int bitA = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int bitB = (j >= 0) ? b.charAt(j--) - '0' : 0;
            
            // 这里模拟位运算的逻辑：
            // sumWithoutCarry = bitA ^ bitB ^ carry
            // newCarry = (bitA & bitB) | (bitA & carry) | (bitB & carry)
            
            int currentBit = bitA ^ bitB ^ carry;
            carry = (bitA & bitB) | (bitA & carry) | (bitB & carry);
            
            result.append(currentBit);
        }
        
        return result.reverse().toString();
    }
}