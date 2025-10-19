public class Solution_Recursion {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        return climbStairsMemo(n, memo);  
        
    }
    private int climbStairsMemo(int n, int[] memo){
        if (n == 1){
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (memo[n] > 0){
            return memo[n];
        }
        memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
        return memo[n];
    }
}