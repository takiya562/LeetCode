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
}
