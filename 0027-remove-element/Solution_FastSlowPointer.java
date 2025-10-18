
public class Solution_FastSlowPointer {
    public int removeElement(int[] nums, int val) {
    //     int fast = 0;
    //     int slow = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[fast] != val) {
    //             nums[slow] = nums[fast];
    //             slow ++; 
    //         }
    //         fast ++;        
    //     }
    //     return slow;
        
    // }
        

        // 下面的写法本质和上面的一样
        int index = 0;
        for(int num : nums){
            if(num != val){
                nums[index++] = num;
            }
        }
        return index;
    }
}
