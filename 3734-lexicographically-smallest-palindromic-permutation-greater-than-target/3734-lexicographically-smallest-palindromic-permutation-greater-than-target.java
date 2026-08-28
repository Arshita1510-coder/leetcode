class Solution {

    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();

        // Count frequency
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Find odd-frequency character
        int oddCount = 0;
        char mid = 0;

        for (int i = 0; i < 26; i++) {

            if (freq[i] % 2 == 1) {
                oddCount++;
                mid = (char) ('a' + i);
            }
        }

        // More than one odd frequency
        // -> palindrome is impossible
        if (oddCount > 1) {
            return "";
        }

        // Frequency for left half
        for (int i = 0; i < 26; i++) {
            freq[i] /= 2;
        }

        int half = n / 2;

        StringBuilder prefix = new StringBuilder();

        // Build left half
        for (int i = 0; i < half; i++) {

            boolean found = false;

            // Try smallest character first
            for (int j = 0; j < 26; j++) {

                if (freq[j] == 0) {
                    continue;
                }

                // Choose j
                freq[j]--;
                prefix.append((char) ('a' + j));

                // Check if ANY valid palindrome
                // can be made with this prefix
                if (isPossible(
                        prefix.toString(),
                        freq,
                        mid,
                        target)) {

                    // Keep this choice
                    found = true;
                    break;
                }

                // Undo choice
                prefix.deleteCharAt(prefix.length() - 1);
                freq[j]++;
            }

            // No character worked
            if (!found) {
                return "";
            }
        }

        // Construct final palindrome
        String ans = buildPalindrome(prefix.toString(), mid);

        // IMPORTANT:
        // Handles n = 1 and also guarantees strict >
        if (ans.compareTo(target) > 0) {
            return ans;
        }

        return "";
    }


    private boolean isPossible(
            String prefix,
            int[] freq,
            char mid,
            String target) {

        StringBuilder remaining = new StringBuilder();

        // Largest possible remaining left half
        for (int i = 25; i >= 0; i--) {

            for (int j = 0; j < freq[i]; j++) {
                remaining.append((char) ('a' + i));
            }
        }

        String left = prefix + remaining.toString();

        // Construct largest possible palindrome
        StringBuilder palindrome = new StringBuilder();

        palindrome.append(left);

        if (mid != 0) {
            palindrome.append(mid);
        }

        palindrome.append(
            new StringBuilder(left).reverse()
        );

        return palindrome.toString().compareTo(target) > 0;
    }


    private String buildPalindrome(
            String left,
            char mid) {

        StringBuilder palindrome = new StringBuilder();

        palindrome.append(left);

        if (mid != 0) {
            palindrome.append(mid);
        }

        palindrome.append(
            new StringBuilder(left).reverse()
        );

        return palindrome.toString();
    }
}