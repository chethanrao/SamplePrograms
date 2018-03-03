/*
Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?
*/

class MaximumSizeSubArray {
    public int maxSubArrayLen(int[] nums, int k) {
        int largest=0,sum=0,length;
        
        for (int i=0;i<nums.length;i++){
            sum+=nums[i];
            nums[i]=sum;
        }
        
        HashMap<Integer,Integer> hashMap=new HashMap<Integer,Integer>();
       
        hashMap.put(0,0);
        for (int i=0;i<nums.length;i++){
             
           if (hashMap.containsKey(nums[i]-k)){
               int start=hashMap.get(nums[i]-k);
               int end=i;
               length=end-start+1;  
               
               if (length>largest)
                   largest=length;
           }
            
          if (!hashMap.containsKey(nums[i]))
              hashMap.put(nums[i],i+1);
        }
        
        return largest; 
    }
}
