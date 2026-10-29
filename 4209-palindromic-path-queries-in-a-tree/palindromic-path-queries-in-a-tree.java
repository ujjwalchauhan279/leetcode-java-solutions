class Solution {
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int LOG = 17;
        int[][] up = new int[LOG][n];
        int[] tin = new int[n];
        int[] tout = new int[n];
        int[] depth = new int[n];
        int[] bit = new int[n + 2];
        char[] arr = s.toCharArray();

        int[] timer = {0};

        dfs(0, 0, graph, up, tin, tout, depth, timer);

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                up[j][i] = up[j - 1][up[j - 1][i]];
            }
        }

        for (int i = 0; i < n; i++) {
            update(bit, tin[i], 1 << (arr[i] - 'a'));
            update(bit, tout[i] + 1, 1 << (arr[i] - 'a'));
        }

        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split(" ");

            int u = Integer.parseInt(parts[1]);

            if (parts[0].equals("update")) {
                char c = parts[2].charAt(0);

                int mask = (1 << (arr[u] - 'a')) ^ (1 << (c - 'a'));

                update(bit, tin[u], mask);
                update(bit, tout[u] + 1, mask);

                arr[u] = c;
            } else {
                int v = Integer.parseInt(parts[2]);
                int lca = getLCA(u, v, depth, up, LOG);

                int mask = query(bit, tin[u])
                         ^ query(bit, tin[v])
                         ^ (1 << (arr[lca] - 'a'));

                ans.add((mask & (mask - 1)) == 0);
            }
        }

        return ans;
    }

    private void dfs(int u, int p, List<Integer>[] graph,
                     int[][] up, int[] tin, int[] tout,
                     int[] depth, int[] timer) {

        tin[u] = ++timer[0];
        up[0][u] = p;

        for (int v : graph[u]) {
            if (v == p) continue;

            depth[v] = depth[u] + 1;
            dfs(v, u, graph, up, tin, tout, depth, timer);
        }

        tout[u] = timer[0];
    }

    private void update(int[] bit, int i, int mask) {
        while (i < bit.length) {
            bit[i] ^= mask;
            i += i & -i;
        }
    }

    private int query(int[] bit, int i) {
        int mask = 0;

        while (i > 0) {
            mask ^= bit[i];
            i -= i & -i;
        }

        return mask;
    }

    private int getLCA(int u, int v, int[] depth, int[][] up, int LOG) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = 0; j < LOG; j++) {
            if ((diff & (1 << j)) != 0) {
                u = up[j][u];
            }
        }

        if (u == v) return u;

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[j][u] != up[j][v]) {
                u = up[j][u];
                v = up[j][v];
            }
        }

        return up[0][u];
    }
}