
public class Solution_SimulationMethod {
    public String addBinary(String a, String b) {
        int lena = a.length();
        int lenb = b.length();
        // 选择两个字符串中较长的一个的字符数作为循环的次数
        int lenl = Math.max(lena, lenb);
        // 使用StringBuilder 来存储结果
        StringBuilder res = new StringBuilder();
        // 初始化进位数
        int digit = 0;
        for (int i = 0; i < lenl; i++) {
            int achar = 0;
            int bchar = 0;
            if (i < lena) {
                achar = a.charAt(lena - 1 - i) - '0';
            }
            if (i < lenb) {
                bchar = b.charAt(lenb - 1 - i) - '0';
            }
            // 当前循环中的和等于a中对应的字符加上b中对应的字符加上上次循环的进位
            int sum = achar + bchar + digit;
            digit = sum / 2;
            res.append(sum % 2);
            
        }
        // 循环结束，如果还有进位，则需要再加入一位
        if (digit == 1) {
            res.append(1);
        }
        // 这里使用reverse函数返回正确的顺序的结果
        return res.reverse().toString();

    }
    
}
