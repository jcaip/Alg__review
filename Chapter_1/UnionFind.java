public class UnionFind
{
    private int[] id;
    private int count;

    public UnionFind(int N)
    {
        id = new int[N];
        count = N;
        for (int i =0; i < N; i++)
            id[i] = i;
    }

    public int count()
    {
        return count;
    }

    public boolean connected(int p, int q)
    {
        return id[p] == id[q];
    }

    public int find(int p)
    {
        return id[p];
    }

    public void union(int p, int q)
    {
       id[p] = id[q];
    }
}
