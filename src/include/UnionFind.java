package include;

public class UnionFind {
    int[] father;
    public UnionFind(int len) {
        father = new int[len];
        for (int i = 0; i < len; i++)
            father[i] = i;
    }
    public void Union(int x, int y) {
        int root1 = findFather(x);
        int root2 = findFather(y);
        if (root1 != root2)
            father[root1] = root2;
    }
    public int Find(int x) {
        int son = x;
        while (x != father[x])
            x = father[x];
        while (son != father[son]) {
            int temp = son;
            son = father[son];
            father[temp] = x;
        }
        return x;
    }
    public int findFather(int x) {
        while (x != father[x])
            x=father[x];
        return x;
    }
}
