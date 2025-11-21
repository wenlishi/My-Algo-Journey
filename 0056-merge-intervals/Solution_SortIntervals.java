public class Solution_SortIntervals {
    public int[][] merge(int[][] intervals) {
        
        int n = intervals.length;
        // 按照区间起点排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // 结果列表
        List<int []> res = new ArrayList<>();

        // 遍历所有区间
        for (int i = 0; i < n; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            // 如果处理的是第一个区间，或者当前区间的起点大于结果列表中最后一个区间的终点，说明没有重叠，直接添加
            if (i == 0 || res.get(res.size() - 1)[1] < L) {
                res.add(intervals[i]);
            } else {
                // 否则说明有重叠，更新结果列表中最后一个区间的终点为两者的较大值
                // 为什么是最大值，因为可能是包含于前一个区间的情况，如[1,5]和[2,3]，这种情况下终点仍然是5  
                int[] lastMerge = res.get(res.size() - 1);
                lastMerge[1] = Math.max(lastMerge[1], R);
            }
        }
        // 最后列表转换为数组返回
        return res.toArray(new int[res.size()][]);
    }
}