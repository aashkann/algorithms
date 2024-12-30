public class weightedQuickUnion {
    private int[] id;
    private int[] size;

    // Constructor
    public weightedQuickUnion(int N) {
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i; // Each node is its own root initially
            size[i] = 1; // Initial size of each tree is 1
        }
    }

    // Find the root of a node
    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    // Check if two nodes are connected
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    // Union operation to connect two nodes
    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);

        if (rootP == rootQ) return;


        if (size[rootP] < size[rootQ]) {
            id[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            id[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }

    // Main method to test the WeightedQuickUnion class
    public static void main(String[] args) {
        // Create an instance of WeightedQuickUnion with 10 elements
        weightedQuickUnion wqu = new weightedQuickUnion(100);

        // Perform union operations
        wqu.union(4, 3);
        wqu.union(3, 8);
        wqu.union(6, 5);
        wqu.union(9, 40);
        wqu.union(2, 1);

        // Check connections
        System.out.println("Are 8 and 9 connected? " + wqu.connected(8, 9)); // true
        System.out.println("Are 5 and 4 connected? " + wqu.connected(7, 40)); // false

        // Additional connections and checks
        wqu.union(5, 0);
        wqu.union(7, 40);
        wqu.union(6, 1);
        wqu.union(7, 3);

        System.out.println("Are 0 and 7 connected? " + wqu.connected(40, 7)); // true
    }
}
