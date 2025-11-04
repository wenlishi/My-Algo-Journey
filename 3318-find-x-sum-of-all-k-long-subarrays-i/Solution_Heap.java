import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution_Heap {
    public int[] findXSum(int[] nums, int k, int x) {
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            int right = i + k - 1;
            Map<Integer, Integer> hashMap = new HashMap<>();
            for (int j = i; j <= right; j++) {
                if (hashMap.containsKey(nums[j])) {
                    hashMap.put(nums[j], hashMap.get(nums[j]) + 1);
                } else {
                    hashMap.put(nums[j], 1);
                }
            }

            PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
                        // 首先，比较两个元素的出现频率（值）
                        int freqCompare = Integer.compare(entry1.getValue(), entry2.getValue());
                        if (freqCompare != 0) {
                            // 如果频率不同，返回频率的比较结果。
                            // 对于小顶堆，我们希望频率较小的元素排在前面，这样堆顶就是当前堆中频率最小的。
                            return freqCompare;
                        } else {
                            // 如果频率相同，则比较数字（键）本身的大小。
                            // 注意：这里我们希望，当频率相同时，数字较大的元素被认为“较小”（排在堆顶），
                            // 这样当新元素频率相同但数字更小时，我们会替换掉堆顶那个数字较大的。
                            // 所以用 entry2的key 和 entry1的key 比较。
                            return Integer.compare(entry1.getKey(), entry2.getKey());
                        }
                    }
                }
            );

            // 2. 遍历HashMap，维护一个大小为x的小顶堆
            for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                if (minHeap.size() < x) {
                    minHeap.offer(entry);
                } else {
                    // 获取当前堆顶元素（堆中频率最小，频率相同时是数字最大的那个）
                    Map.Entry<Integer, Integer> peekEntry = minHeap.peek();
                    int peekFreq = peekEntry.getValue();
                    int peekKey = peekEntry.getKey();
                    int currentFreq = entry.getValue();
                    int currentKey = entry.getKey();

                    // 比较逻辑：如果新元素的频率更高，或者频率相同但数字更小，则替换堆顶
                    if (currentFreq > peekFreq) {
                        minHeap.poll();
                        minHeap.offer(entry);
                    } else if (currentFreq == peekFreq) {
                        // ！！！核心逻辑：频率相同时，比较数字大小
                        // 我们希望数字小的优先级更高（更应该被保留），所以如果当前元素的数字大于堆顶元素的数字，就替换
                        if (currentKey > peekKey) {
                            minHeap.poll();
                            minHeap.offer(entry);
                        }
                    }
                    // 如果当前元素频率小于堆顶，或者频率相同但数字更小，则不做任何操作
                }
            }
            int actualSize = minHeap.size(); // 实际取到的元素个数
            int[] topKeys = new int[actualSize]; 

            // 因为是小顶堆，poll()先出来的是频率最小的，所以需要从后往前放
            for (int j = actualSize - 1; j >= 0; j--) {
                topKeys[j] = minHeap.poll().getKey();
            }
            int sum = 0;
            for (int j = 0; j < actualSize; j++) {
                sum += topKeys[j] * hashMap.get(topKeys[j]);
            }
            res[index++] = sum;
        }
        return res;

    }
}
