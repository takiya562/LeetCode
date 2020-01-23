package include;

public class Trie {
    private TreeNode root;

    private static class TreeNode {
        String val;
        TreeNode[] children;

        public TreeNode() {
            this.val = null;
            this.children = new TreeNode[26];
        }
    }

    public Trie() {
        this.root = new TreeNode();
    }

    public void insert(String val) {
        TreeNode cur = root;
        for (int i = 0; i < val.length(); i++) {
            int c = val.charAt(i)-'a';
            if (cur.children[c] == null)
                cur.children[c] = new TreeNode();
            cur = cur.children[c];
        }
        cur.val = val;
    }

    public boolean search (String word, int index) { //用于472题
        TreeNode cur = root;
        for (int i = index; i < word.length(); i++) {
            int c = word.charAt(i)-'a';
            cur = cur.children[c];
            if (cur == null)
                return false;
            if (i < word.length()-1) {
                if (cur.val != null && !word.equals(cur.val)) {
                    if (search(word, i+1))
                        return true;
                }
            }
        }
        return cur.val != null && !word.equals(cur.val);
    }


    public boolean search_norm (String word, int index) {
        TreeNode cur = root;
        for (int i = index; i < word.length(); i++) {
            int c = word.charAt(i)-'a';
            cur = cur.children[c];
            if (cur == null)
                return false;
        }
        return cur.val != null && word.equals(cur.val);
    }

    public String partSearch(String word) {
        TreeNode cur = root;
        String res = null;
        for (int index = 0; index < word.length(); index++) {
            int c = word.charAt(index) - 'a';
            cur = cur.children[c];
            if (cur == null)
                break;
            res = cur.val;
            if (res != null)
                break;
        }
        return res;
    }
}
