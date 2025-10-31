import java.util.HashSet;

public class Solution_Hash {
    public int[] getSneakyNumbers(int[] nums) {
        int[] res = new int[2];
        HashSet<Integer> seen = new HashSet<>();
        int index = 0;
        for (int num : nums) {
            if (seen.contains(num)) {
                res[index++] = num;
            } else {
                seen.add(num);
            }

        }
        return res;
    }
}
