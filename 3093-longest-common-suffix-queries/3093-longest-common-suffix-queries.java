class Solution {

    class TrieNode {

        TrieNode[] child = new TrieNode[26];

        int bestIndex;
        int bestLength;

        TrieNode() {
            bestIndex = -1;
            bestLength = Integer.MAX_VALUE;
        }
    }

    TrieNode root = new TrieNode();

    // update best answer at node
    void update(TrieNode node, int index, int len) {

        if (len < node.bestLength) {

            node.bestLength = len;
            node.bestIndex = index;
        }
        else if (len == node.bestLength &&
                 index < node.bestIndex) {

            node.bestIndex = index;
        }
    }

    // insert reversed word
    void insert(String word, int index) {

        TrieNode node = root;

        update(node, index, word.length());

        for (int i = word.length() - 1; i >= 0; i--) {

            char ch = word.charAt(i);

            int c = ch - 'a';

            if (node.child[c] == null) {
                node.child[c] = new TrieNode();
            }

            node = node.child[c];

            update(node, index, word.length());
        }
    }

    // search query
    int search(String word) {

        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; i--) {

            char ch = word.charAt(i);

            int c = ch - 'a';

            if (node.child[c] == null) {
                break;
            }

            node = node.child[c];
        }

        return node.bestIndex;
    }

    public int[] stringIndices(String[] wordsContainer,
                               String[] wordsQuery) {

        // build trie
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        // answer queries
        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }
}