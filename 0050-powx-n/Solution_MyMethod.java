import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_MyMethod {
    public double myPow(double x, int n) {
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
        }
        long exponent = Math.abs((long)n); // 使用long避免溢出
        // 分解指数为2的幂次和
        List<Long> components = decompose(exponent);
        // 创建记忆化存储
        Map<Long, Double> memo = new HashMap<>();
        double res = 1.0;
        for (long num: components) {
            res = res * digui(x, num, memo); 
        }
        return isNegative ? 1.0 / res : res;
        
    }
    // 递归计算x的n次方，使用记忆化避免重复计算
    public double digui(double x, Long n, Map<Long, Double> memo) {
        // 终止条件
        if (n == 1) {
            return x;
        }
        // 检查记忆化存储中是否已有结果
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        // 递归计算
        double half = digui(x, n / 2, memo);
        double result = half * half;
        // 存储结果到记忆化存储中
        memo.put(n, result);
        return result;
    }
    // 分解指数为2的幂次和
    public List<Long> decompose(long n) {
        long with = 1;
        List<Long> res = new ArrayList<>();
        long temp = 0;
        while (with <= n) {
            temp = with & n;
            if (temp != 0) {
                res.add(temp);
            }
            with <<= 1;
        }
        return res;
    }
}
    
