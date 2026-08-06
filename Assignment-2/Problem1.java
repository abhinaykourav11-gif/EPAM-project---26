import java.util.*;

public class Problem1 {
    static ArrayList<Integer>[] tree;
    static int[] key;
    static boolean[] visited;
    static int count = 0;
    static int K;

    static void dfs(int node, int xorValue) {
        visited[node] = true;

        int currentXor = xorValue ^ key[node];

        if (currentXor >= K) {
            count++;
        }

        for (int child : tree[node]) {
            if (!visited[child]) {
                dfs(child, currentXor);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        K = sc.nextInt();

        key = new int[N + 1];
        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            key[i] = sc.nextInt();
        }

        for (int i = 0; i < N - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            tree[u].add(v);
            tree[v].add(u);
        }

        dfs(1, 0);

        System.out.println(count);
    }
}
