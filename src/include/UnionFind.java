package include;

public class UnionFind {
    private int[] parent;
    public UnionFind(int lenght) {
        parent = new int[lenght];
        for (int i = 0; i < lenght; i++)
            parent[i] = i;
    }

    public int find(int index) {
        if (parent[index] != index)
            parent[index] = find(parent[index]);
        return parent[index];
    }

    public void union(int index1, int index2) {
        parent[find(index2)] = parent[find(index1)];
    }

    public void clear() {
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;
    }

    public boolean isMST() {
        if (parent.length == 0) return true;
        int tmp = find(parent[0]);
        for (int i = 1; i < parent.length; i++) {
            if (tmp != find(i))
                return false;
        }
        return true;
    }

    public int countRoot() {
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i)
                count++;
        }
        return count;
    }
}
