
class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int maxLen = 1; 
        if (freqMap.containsKey(1)) {
            int ones = freqMap.get(1);
            maxLen = Math.max(maxLen, ones % 2 == 1 ? ones : ones - 1);
        }
        for (int x : freqMap.keySet()) {
            if (x == 1) continue;
            long curr = x;
            int currentLen = 0;
            
            while (curr <= 1000000000L && freqMap.containsKey((int) curr) && freqMap.get((int) curr) >= 2) {
                currentLen += 2;
                curr *= curr;
            }
            if (curr <= 1000000000L && freqMap.containsKey((int) curr)) {
                
                currentLen += 1;
            } else {
                
                currentLen -= 1;
            }
            
            maxLen = Math.max(maxLen, currentLen);
        }
        
        return maxLen;
    }
}