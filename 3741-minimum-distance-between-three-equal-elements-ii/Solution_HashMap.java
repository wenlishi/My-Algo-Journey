import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution_HashMap {
    public int minimumDistance(int[] nums) {
        Map<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.get(nums[i]).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                hashMap.put(nums[i], list);
            }
        }
        int dis = Integer.MAX_VALUE;
        // 这里看似是双层循环，实际上内层循环每个元素只会被访问一次，所以时间复杂度是O(n)
        for (Map.Entry<Integer, ArrayList<Integer>> entry : hashMap.entrySet()) {
            ArrayList<Integer> valueList = entry.getValue();
            for (int i = 2; i < valueList.size(); i++) {
                dis = Math.min(dis, 2*(valueList.get(i) - valueList.get(i - 2)));
            }
        }
        if (dis == Integer.MAX_VALUE) {
            return -1;
        }
        return dis;
    }
}