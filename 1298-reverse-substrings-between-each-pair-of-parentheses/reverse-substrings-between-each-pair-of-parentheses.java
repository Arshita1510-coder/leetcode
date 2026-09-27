class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Stack<Integer> st = new Stack<>();

        // Step 1: Find matching parentheses
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else if (s.charAt(i) == ')') {
                int j = st.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        // Step 2: Traverse with direction changes
        StringBuilder ans = new StringBuilder();
        int i = 0;
        int direction = 1;

        while (i < n) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == ')') {
                i = pair[i];
                direction = -direction;
            } else {
                ans.append(ch);
            }

            i += direction;
        }

        return ans.toString();
    }
}