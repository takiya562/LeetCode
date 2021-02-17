class Trie {

    private String val;
    private Trie[] children;

    /** Initialize your data structure here. */
    public Trie() {
        this.val = null;
        children = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie cur = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new Trie();
            }
            cur = cur.children[index];
        }
        cur.val = word;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie cur = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (cur.children[index] == null)
                return false;
            cur = cur.children[index];
        }
        return cur.val != null;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie cur = this;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (cur.children[index] == null)
                return false;
            cur = cur.children[index];
        }
        return true;
    }
}