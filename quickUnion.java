public class quickUnion {
    private int[] id;

    // Constructor
    public quickUnion(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
    }

    // Find the root of a node
    private int root(int i) {
        while (i != id[i]) i = id[i];
        return i;
    }


    // Check if two nodes are connected
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    // Union operation to connect two nodes
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    // Main method to test the quickUnion class
    public static void main(String[] args) {
        // Create an instance of quickUnion with 10 elements
        quickUnion qu = new quickUnion(100);

        // Perform union operations
        qu.union(4, 3);
        qu.union(3, 8);
        qu.union(6, 5);
        qu.union(9, 4);
        qu.union(2, 1);

        // Check connections
        System.out.println("Are 8 and 9 connected? " + qu.connected(8, 9)); // true
        System.out.println("Are 5 and 4 connected? " + qu.connected(5, 4)); // false

        // Additional connections and checks
        qu.union(5, 0);
        qu.union(7, 2);
        qu.union(6, 1);
        qu.union(7, 3);

        System.out.println("Are 0 and 7 connected? " + qu.connected(0, 7)); // true
    }
}
