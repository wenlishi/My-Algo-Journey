public class Solution_MyMethod {
    public double myPow(double x, int n) {
        boolean less = false;
        if (n < 0) {
            less = true;
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
        return less ? 1.0 / res : res;
        
    }
    
    public double digui(double x, Long n, Map<Long, Double> memo) {
        if (n == 1) {
            return x;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        double half = digui(x, n / 2, memo);
        double result = half * half;
        memo.put(n, result);
        return result;
    }
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
    
