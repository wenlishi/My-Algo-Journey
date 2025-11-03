public class Solution_Improved {
    public long maxProduct(int[] nums) {
        int mx = 0, mx2 = 0;

        for(int x : nums){
            x = Math.abs(x);

            if(x > mx){
                mx2 = mx;
                mx = x;
            }else if(x > mx2){
                mx2 = x;
            }
        }
        // 不用管正负号，最后返回的一定是正的
        return 100000L * mx * mx2;
    }
}
