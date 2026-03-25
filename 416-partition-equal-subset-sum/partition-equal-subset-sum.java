class Solution {
     public boolean subsetSumToK(int n, int k, int[] nums) {
        // Initialize previous row of DP table with false
        boolean[] prev = new boolean[k + 1];

        // Base case: sum 0 can always be formed with empty subset
        prev[0] = true;

        // Base case: if first element <= k, mark true
        if (nums[0] <= k) {
            prev[nums[0]] = true;
        }

        // Iterate over elements starting from second
        for (int ind = 1; ind < n; ind++) {
            // Current row of DP table
            boolean[] cur = new boolean[k + 1];
            cur[0] = true; // sum 0 always possible

            for (int target = 1; target <= k; target++) {
                // Option 1: not take current element
                boolean notTaken = prev[target];

                // Option 2: take current element if possible
                boolean taken = false;
                if (nums[ind] <= target) {
                    taken = prev[target - nums[ind]];
                }

                // Store true if either option is true
                cur[target] = notTaken || taken;
            }
            // Move current row to previous for next iteration
            prev = cur;
        }

        // Return if sum k is possible using all elements
        return prev[k];
    }

    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int totalSum=0;
        for(int i=0;i<n;i++) totalSum+=nums[i];
        if(totalSum%2==1) return false;
        int target=totalSum/2;
        return subsetSumToK(n,target,nums);

        
    }
}