import java.util.*;

public class Graph {


    class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }


    }

    public void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj) {

        vis[node] = 1;

        for (var it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(it, vis, adj);
            }
        }

    }


    public int findCircleNum(int[][] isConnected) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < isConnected.length; i++) {
            list.add(new ArrayList<>());
        }

        for (int j = 0; j < isConnected.length; j++) {
            for (int k = 0; k < isConnected.length; k++) {
                if (isConnected[j][k] == 1 && j != k) {
                    list.get(j).add(k);

                }
            }
        }

        int[] vis = new int[isConnected.length];
        int cnt = 0;


        for (int i = 0; i < isConnected.length; i++) {

            if (vis[i] == 0) {
                cnt++;
                dfs(i, vis, list);
            }
        }
        return cnt;

    }


    public void bfs(Pair node, int[][] visMat, List<List<Integer>> adj, int row, int col) {


        Queue<Pair> queue = new LinkedList<>();
        queue.add(node);
        visMat[node.row][node.col] = 1;

        while (queue.isEmpty()) {
            var takeNode = queue.poll();
            int r = takeNode.row;
            int c = takeNode.col;
            if (visMat[r][c] == 0) {
                if (r == 0 && c == 0) {

                    if (adj.get(r).get(c + 1) == 1) {
                        visMat[r][c + 1] = 1;
                        queue.add(new Pair(r, c + 1));
                    }

                    if (adj.get(r + 1).get(c) == 1) {
                        visMat[r + 1][c] = 1;
                        queue.add(new Pair(r + 1, c));
                    }

                    if (adj.get(r + 1).get(c + 1) == 1) {
                        visMat[r + 1][c + 1] = 1;
                        queue.add(new Pair(r + 1, c + 1));
                    }


                } else if (r == 0 && c != col - 1) {


                    if (adj.get(r).get(c + 1) == 1) {
                        visMat[r][c + 1] = 1;
                        queue.add(new Pair(r, c + 1));
                    }

                    if (adj.get(r + 1).get(c) == 1) {
                        visMat[r + 1][c] = 1;
                        queue.add(new Pair(r + 1, c));
                    }

                    if (adj.get(r + 1).get(c + 1) == 1) {
                        visMat[r + 1][c + 1] = 1;
                        queue.add(new Pair(r + 1, c + 1));
                    }

                    if (adj.get(r).get(c - 1) == 1) {
                        visMat[r][c - 1] = 1;
                        queue.add(new Pair(r, c - 1));
                    }
                    if (adj.get(r + 1).get(c - 1) == 1) {
                        visMat[r + 1][c - 1] = 1;
                        queue.add(new Pair(r - 1, c - 1));
                    }

                } else if (r == 0 && c == col - 1) {

                    if (adj.get(r + 1).get(c) == 1) {
                        visMat[r + 1][c] = 1;
                        queue.add(new Pair(r + 1, c));
                    }

                    if (adj.get(r).get(c - 1) == 1) {
                        visMat[r][c - 1] = 1;
                        queue.add(new Pair(r, c - 1));
                    }
                    if (adj.get(r - 1).get(c - 1) == 1) {
                        visMat[r - 1][c - 1] = 1;
                        queue.add(new Pair(r - 1, c - 1));
                    }

                } else if (r != row - 1 && c == 0) {

                    if (adj.get(r).get(c + 1) == 1) {
                        visMat[r][c + 1] = 1;
                        queue.add(new Pair(r, c + 1));
                    }

                    if (adj.get(r + 1).get(c) == 1) {
                        visMat[r + 1][c] = 1;
                        queue.add(new Pair(r + 1, c));
                    }

                    if (adj.get(r + 1).get(c + 1) == 1) {
                        visMat[r + 1][c + 1] = 1;
                        queue.add(new Pair(r + 1, c + 1));
                    }
                    if (adj.get(r - 1).get(c) == 1) {
                        visMat[r - 1][c] = 1;
                        queue.add(new Pair(r - 1, c));
                    }
                    if (adj.get(r - 1).get(c - 1) == 1) {
                        visMat[r - 1][c - 1] = 1;
                        queue.add(new Pair(r - 1, c - 1));
                    }


                } else if (c == 0 && r == row - 1) {

                    if (adj.get(r - 1).get(c) == 1) {
                        visMat[r - 1][c] = 1;
                        queue.add(new Pair(r - 1, c));
                    }
                    if (adj.get(r - 1).get(c - 1) == 1) {
                        visMat[r - 1][c - 1] = 1;
                        queue.add(new Pair(r - 1, c - 1));
                    }

                    if (adj.get(r).get(c + 1) == 1) {
                        visMat[r][c + 1] = 1;
                        queue.add(new Pair(r, c + 1));
                    }


                } else if (r == row - 1 && c != col - 1) {

                    if (adj.get(r - 1).get(c) == 1) {
                        visMat[r - 1][c] = 1;
                        queue.add(new Pair(r - 1, c));
                    }

                    if (adj.get(r).get(c + 1) == 1) {
                        visMat[r][c + 1] = 1;
                        queue.add(new Pair(r, c + 1));
                    }

                    if (adj.get(r).get(c - 1) == 1) {
                        visMat[r][c - 1] = 1;
                        queue.add(new Pair(r, c - 1));
                    }

                    if (adj.get(r - 1).get(c + 1) == 1) {
                        visMat[r - 1][c + 1] = 1;
                        queue.add(new Pair(r - 1, c + 1));
                    }


                    if (adj.get(r - 1).get(c - 1) == 1) {
                        visMat[r - 1][c - 1] = 1;
                        queue.add(new Pair(r - 1, c - 1));
                    }


                } else if (r == row - 1 && c == col - 1) {

                    if (adj.get(r - 1).get(c) == 1) {
                        visMat[r - 1][c] = 1;
                        queue.add(new Pair(r - 1, c));
                    }

                    if (adj.get(r - 1).get(c - 1) == 1) {
                        visMat[r - 1][c - 1] = 1;
                        queue.add(new Pair(r - 1, c - 1));
                    }

                    if (adj.get(r).get(c - 1) == 1) {
                        visMat[r][c - 1] = 1;
                        queue.add(new Pair(r, c - 1));
                    }


                }


            }

        }


    }


    public int noOfIsland(List<List<Integer>> adj) {

        int noOfIsland = 0;
        int row = adj.size();
        int col = adj.get(0).size();

        int[][] visMat = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (adj.get(i).get(j) == 1 && visMat[i][j] == 0) {
                    noOfIsland++;
                    bfs(new Pair(i, j), visMat, adj, row, col);
                }

            }
        }

        return noOfIsland;
    }

    public void dfsFlood(int[][] mat, int[][] vis, int start, int end, int colour, int givenColor) {

        if (start < 0 || start >= mat.length || end < 0 || end >= mat[0].length || mat[start][end] == colour ||
                mat[start][end] != givenColor)
            return;

        if (start >= 0 && start < mat.length && end >= 0 && end < mat[0].length &&
                mat[start][end] == givenColor) {
            mat[start][end] = colour;
            vis[start][end] = -1;
        }
        dfsFlood(mat, vis, start - 1, end, colour, givenColor);
        dfsFlood(mat, vis, start + 1, end, colour, givenColor);
        dfsFlood(mat, vis, start, end + 1, colour, givenColor);
        dfsFlood(mat, vis, start, end - 1, colour, givenColor);

    }

    public int[][] fillFlood(int[][] mat, int start, int end, int color) {

        int[][] replica = mat;
        int[][] vis = new int[mat.length][mat[0].length];
        int givenColour = mat[start][end];
        dfsFlood(replica, vis, start, end, color, givenColour);
        return replica;
    }


    class CPair {
        int cur;
        int from;

        public CPair(int cur, int from) {
            this.cur = cur;
            this.from = from;
        }
    }

    public boolean bfs(int j, List<List<Integer>> adj, int V, boolean[] vis) {

        vis[j] = true;
        Queue<CPair> queue = new LinkedList<>();
        CPair n = new CPair(j, -1);

        queue.add(n);

        while (!queue.isEmpty()) {
            var node = queue.poll();
            int cur = node.cur;
            int form = node.from;

            for (int list : adj.get(cur)) {

                if (list != form && vis[list] == true)
                    return true;

                if (form != list) {
                    queue.add(new CPair(list, cur));
                    vis[list] = true;
                }

            }


        }

        return false;


    }

    public boolean delectCycle(int V, List<List<Integer>> adj) {

        Queue<CPair> queue = new LinkedList<>();
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) vis[i] = false;

        for (int j = 0; j < V; j++) {
            if (vis[j] == false) {
                if (bfs(j, adj, V, vis)) return true;
            }
        }


        return false;

    }

    class DistancePair {
        int row;
        int col;
        int dis;

        public DistancePair(int row, int col, int dis) {
            this.row = row;
            this.col = col;
            this.dis = dis;
        }


    }

    public void bfsDistance(int[][] adj, int[][] vis, int[][] distance) {
        Queue<DistancePair> queue = new LinkedList<>();

        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[0].length; j++) {
                if (adj[i][j] == 0) {
                    queue.add(new DistancePair(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }


        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            var node = queue.poll();
            int row = node.row;
            int col = node.col;
            int dis = node.dis;

            distance[row][col] = dis;

            for (int i = 0; i < 4; i++) {

                int r = row + drow[i];
                int c = col + dcol[i];

                if (r >= 0 && r < adj.length && c >= 0 && c < adj[0].length && vis[r][c] == 0) {

                    queue.add(new DistancePair(r, c, dis + 1));
                    vis[r][c] = 1;

                }


            }

        }
    }


    public int[][] updateMatrix(int[][] mat) {

        int[][] vis = new int[mat.length][mat[0].length];
        int[][] dis = new int[mat.length][mat[0].length];


        bfsDistance(mat, vis, dis);

        return dis;


    }


    public void bfs(int[][] vis, char[][] board, int row, int col) {
        if (row < 0 || row >= vis.length || col < 0 || col >= vis[0].length || vis[row][col] == 1 || board[row][col] == 'O')
            return;

        vis[row][col] = 1;
        int[] r = {-1, 0, 1, 0};
        int[] c = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            bfs(vis, board, row + r[i], col + c[i]);
        }

    }

    public void solve(char[][] board) {
        int[][] vis = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (((i == 0) || (j == 0) || j == board[0].length - 1 || i == board.length - 1) && vis[i][j] == 0 && board[i][j] == 'O') {
                    bfs(vis, board, i, j);
                }
            }
        }
        for (int i = 0; i < vis.length; i++) {
            for (int j = 0; j < vis[0].length; j++) {
                if (vis[i][j] != 1)
                    board[i][j] = 'X';
            }
        }

    }

    public int numEnclaves(int[][] grid) {

        int countLand = 0;

        int[][] vis = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if ((i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) && vis[i][j] == 0 && grid[i][j] == 1) {
                    landDfs(grid, vis, i, j);
                }

            }

        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    countLand++;
                }
            }
        }
        return countLand++;
    }

    public void landDfs(int[][] grip, int[][] vis, int row, int col) {
        if ((row < 0 || col < 0 || row >= grip.length || col >= grip[0].length || row < 0 || col < 0) || (vis[row][col] == 1) || grip[row][col] == 0)
            return;

        vis[row][col] = 1;

        int[] r = {-1, 0, 1, 0};
        int[] c = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            landDfs(grip, vis, row + r[i], col + c[i]);
        }
    }

    public int countDistinctIslands(int[][] grid) {

        Set<List<List<Integer>>> set = new HashSet<>();
        int[][] vis = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                List<List<Integer>> temp = new ArrayList<>();
                if (grid[i][j] == 1 && vis[i][j] == 0) {

                    countDistinctIslandsDfs(grid, vis, i, j, i, j, temp);
                    set.add(temp);

                }

            }
        }

        return set.size();
    }

    public void countDistinctIslandsDfs(int[][] grid, int[][] vis, int baseR, int baseC, int row, int col, List<List<Integer>> set) {

        if ((row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) || vis[row][col] == 1 || grid[row][col] == 0)
            return;

        vis[row][col] = 1;
        List<Integer> interlist = new ArrayList<>();
        interlist.add(baseR - row);
        interlist.add(baseC - col);
        set.add(interlist);


        int[] r = {-1, 0, 1, 0};
        int[] c = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            countDistinctIslandsDfs(grid, vis, baseR, baseC, row + r[i], col + c[i], set);


        }


    }

    public boolean isBipartite(int[][] graph) {

        int[] vis = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            vis[i] = -1;
        }
        for (int i = 0; i < graph.length; i++) {
            if (vis[i] == -1)
                if (isBipartiteDfs(graph, vis, i, 0) == false) return false;
        }

        return true;


    }

    public boolean isBipartiteDfs(int[][] graph, int[] vis, int node, int color) {


        vis[node] = color;

        for (var it : graph[node]) {
            if (vis[it] == -1) {
                if (isBipartiteDfs(graph, vis, it, 1 - color) == false) return false;
            } else if (vis[it] == color)
                return false;
        }

        return true;
    }

    public boolean circleInDirector(int[][] graph) {
        int[] vis = new int[graph.length];
        int[] pathVis = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (vis[i] == 0) {
                if (circleInDirectorDfs(graph, vis, pathVis, i) == true) return true;
            }
        }
        return false;

    }

    public boolean circleInDirectorDfs(int[][] graph, int[] vis, int[] pathVis, int node) {

        vis[node] = 1;
        pathVis[node] = 1;


        for (int it : graph[node]) {
            if (vis[it] == 0) {
                if (circleInDirectorDfs(graph, vis, pathVis, it) == true)
                    return true;

            } else if (pathVis[it] == 1) {
                return true;
            }
        }

        pathVis[node] = 0;
        return false;
    }

    public List<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {

        int[] vis = new int[adj.size()];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < adj.size(); i++) {
            if (vis[i] == 0) {
                topologicalSortDfs(adj, vis, stack, i);
            }

        }

        List<Integer> sortList = new ArrayList<>();
        while (!stack.isEmpty()) {
            sortList.add(stack.pop());
        }
        return sortList;

    }

    public void topologicalSortDfs(ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> stack, int node) {

        vis[node] = 1;

        for (var it : adj.get(node)) {
            if (vis[it] == 0) {
                topologicalSortDfs(adj, vis, stack, it);
            }
        }

        stack.add(node);

    }

    public List<Integer> topologicalSortB(ArrayList<ArrayList<Integer>> adj) {

        int[] degree = new int[adj.size()];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < adj.size(); i++) {
            for (var it : adj.get(i)) {
                degree[it]++;
            }
        }
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            var node = queue.poll();
            ans.add(node);
            for (int it : adj.get(node)) {
                degree[it]--;
                if (degree[it] == 0) {
                    queue.add(it);
                }
            }

        }

        return ans;

    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        List<Integer> ans = new ArrayList<>();

        List<List<Integer>> newAdj = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            newAdj.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            for (var it : graph[i]) {
                newAdj.get(it).add(i);
            }
        }

        int[] inDegree = new int[graph.length];

        for (int i = 0; i < newAdj.size(); i++) {
            for (var it : newAdj.get(i)) {
                inDegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {

            if (inDegree[i] == 0) {
                queue.add(i);
            }


        }

        while (!queue.isEmpty()) {

            var node = queue.poll();
            ans.add(node);

            for (var subnode : newAdj.get(node)) {
                inDegree[subnode]--;
                if (inDegree[subnode] == 0) {
                    queue.add(subnode);
                }
            }
        }

        Collections.sort(ans);

        return ans;


    }

    public class GraphPair {

        int node;
        int dis;


        public GraphPair(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }
    }

    public int[] shortestPath(int[][] edges, int n, int m, int src){

        Queue<GraphPair> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] dis = new int[n];
        for (int i = 0; i < dis.length; i++) {
            dis[i] = -1;
        }

        queue.add(new GraphPair(src, 0));

        while (!queue.isEmpty()) {
            var pair = queue.poll();
            int node = pair.node;
            int distance = pair.dis;
            dis[node] = distance;

            for (var it : adj.get(node)) {
                if (dis[it] == -1) {
                    queue.add(new GraphPair(it, distance + 1));
                }
            }


        }


        return dis;


    }

    class GraphPairHeight {

        public GraphPairHeight(int node, int height) {
            this.node = node;
            this.weight = height;
        }

        int node;
        int weight;

    }

    public int[] shortestPath(int N, int M, int[][] edges, int src) {

        ArrayList<ArrayList<GraphPairHeight>> graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            graph.get(edges[i][0]).add(new GraphPairHeight(edges[i][1], edges[i][2]));
        }

        var stack = toposort(graph);

        int[] dis = new int[N];
        for (int i = 0; i < N; i++) {
            dis[i] = (int) 1e9;
        }
        dis[src] = 0;


        while (!stack.isEmpty()) {
            var node = stack.pop();

            for (var it : graph.get(node)) {
                if (dis[node] + it.weight < dis[it.node]) {
                    dis[it.node] = dis[node] + it.weight;
                }
            }
        }
        return dis;

    }

    public Stack<Integer> toposort(ArrayList<ArrayList<GraphPairHeight>> graph) {

        Stack<Integer> stack = new Stack<>();
        int[] vis = new int[graph.size()];

        for (int i = 0; i < graph.size(); i++) {
            if (vis[i] == 0) {
                toposortdfs(i, graph, stack, vis);
            }
        }
        return stack;
    }

    public void toposortdfs(int node, ArrayList<ArrayList<GraphPairHeight>> graph, Stack<Integer> stack, int[] vis) {

        vis[node] = 1;

        for (var it : graph.get(node)) {
            if (vis[it.node] == 0)
                toposortdfs(it.node, graph, stack, vis);
        }

        stack.add(node);
    }

    class WordString {

        public WordString(String srt, int level) {
            this.srt = srt;
            this.level = level;
        }

        String srt;
        int level;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>();

        for (var str : wordList) {
            set.add(str);
        }

        Queue<WordString> queue = new LinkedList<>();

        queue.add(new WordString(beginWord, 1));

        while (!queue.isEmpty()) {
            var node = queue.poll();

            if (node.srt.equals(endWord))
                return node.level;

            for (int i = 0; i < node.srt.length(); i++) {
                for (int j = 'a'; j <= 'z'; j++) {
                    char ch = (char) j;
                    String stirng = node.srt.substring(0, i) + ch + node.srt.substring(i + 1);
                    if (set.contains(stirng)) {
                        queue.add(new WordString(stirng, node.level + 1));
                        set.remove(stirng);
                    }
                }
            }
        }
        return 0;

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> ansList = new ArrayList<>();

        Set<String> set = new HashSet<>();
        for (var str : wordList) {
            set.add(str);
        }

        Queue<ArrayList<String>> queue = new LinkedList<>();
        ArrayList<String> onelist = new ArrayList<>();
        onelist.add(beginWord);
        queue.add(onelist);
        ArrayList<String> usedlvl = new ArrayList<>();
        usedlvl.add(beginWord);
        int lvl = 0;

        while (!queue.isEmpty()) {
            var node = queue.poll();
            var lastele = node.get(node.size() - 1);

            if (node.size() > lvl) {
                lvl++;
                for (var it : usedlvl) {
                    set.remove(it);
                }
            }
            if (lastele.equals(endWord)) {

                if (ansList.size() == 0)
                    ansList.add(node);
                else if (ansList.get(0).size() == node.size())
                    ansList.add(node);
            } else {
                for (int i = 0; i < lastele.length(); i++) {
                    for (int j = 'a'; j <= 'z'; j++) {
                        char ch = (char) j;
                        String stirng = lastele.substring(0, i) + ch + lastele.substring(i + 1);
                        if (set.contains(stirng)) {
                            ArrayList<String> newnode = new ArrayList<>(node);
                            newnode.add(stirng);
                            queue.add(newnode);
                            usedlvl.add(stirng);
                        }
                    }
                }
            }
        }
        return ansList;
    }


    public int[] unDirectedGraph(List<List<List<Integer>>> adj, int src) {

        int[] dis = new int[adj.size()];

        for (int i = 0; i < dis.length; i++) {
            dis[i] = (int) 1e9;
        }

        PriorityQueue<List<Integer>> queue = new PriorityQueue<>();

        dis[src] = 0;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(src);
        queue.add(list);

        while (!queue.isEmpty()) {
            var node = queue.poll();

            for (var it : adj.get(node.get(1))) {
                int n = it.get(0);
                int newDis = node.get(1) + it.get(1);

                if (dis[n] > newDis) {
                    dis[n] = newDis;
                    List<Integer> newList = new ArrayList<>();
                    newList.add(newDis);
                    newList.add(n);
                    queue.add(newList);
                }

            }


        }
        return dis;
    }

    class PairNode {
        int dis;
        int node;

        public PairNode(int dis, int node) {
            this.dis = dis;
            this.node = node;
        }


    }

    public int[] unDirectedGraphSet(ArrayList<ArrayList<ArrayList<Integer>>> adj, int src) {

        int[] dis = new int[adj.size()];
        Set<PairNode> set = new HashSet<>();
        dis[src] = 0;
        set.add(new PairNode(0, src));

        while (!set.isEmpty()) {
            var node = set.stream().findFirst().get();
            set.remove(node);

            for (var it : adj.get(node.node)) {
                int n = it.get(0);
                int newdis = node.dis + it.get(1);

                if (dis[n] > newdis) {
                    dis[n] = newdis;
                    set.add(new PairNode(newdis, n));
                }
            }


        }
        return dis;
    }

    public class NewPair {

        public NewPair(int dis, int node) {
            this.dis = dis;
            this.node = node;
        }

        int dis;
        int node;


    }

    public List<Integer> printPath(List<List<List<Integer>>> adj, int src, int des) {

        List<Integer> path;
        int[] dis = new int[adj.size()];
        int[] parent = new int[adj.size()];
        for (int i = 0; i < dis.length; i++) {
            dis[i] = (int) 1e9;
            parent[i] = i;
        }
        PriorityQueue<NewPair> queue = new PriorityQueue<>();
        queue.add(new NewPair(0, src));
        dis[src] = 0;

        while (!queue.isEmpty()) {

            var node = queue.poll();


            for (var it : adj.get(node.node)) {
                int n = it.get(0);
                int lenght = it.get(1) + node.dis;

                if (dis[n] > lenght) {
                    dis[n] = lenght;
                    parent[n] = node.node;
                    queue.add(new NewPair(lenght, n));
                }


            }


        }

        List<Integer> preans = new ArrayList<>();
        preans.add(des);
        int form = des;
        while (parent[form] != form) {
            preans.add(parent[form]);
            des = parent[form];
        }
        int last = preans.size() - 1;
        for (int i = 0; i < preans.size() / 2; i++) {
            int temp = preans.get(i);
            preans.set(i, preans.get(last));
            preans.set(last, temp);
            last--;
        }
        return preans;
    }

    class PairRC {

        public PairRC(int row, int col) {
            this.row = row;
            this.col = col;
        }

        int row;
        int col;


    }

    class disAndPair {


        public disAndPair(int dis, PairRC RC) {
            this.dis = dis;
            this.RC = RC;
        }

        int dis;
        PairRC RC;


    }

    public int Shortpathtodes(int[][] graph, int fromR, int fromC, int desR, int desC) {

        int[][] dis = new int[graph.length][graph[0].length];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; i++) {
                dis[i][j] = (int) 1e9;
            }
        }

        dis[fromR][fromC] = 0;

        Queue<disAndPair> queue = new LinkedList<>();

        disAndPair distance = new disAndPair(0, new PairRC(fromR, fromC));

        queue.add(distance);


        int[] r = {-1, 0, 1, 0};
        int[] c = {0, 1, 0, -1};

        while (!queue.isEmpty()) {

            var disObj = queue.poll();

            for (int i = 0; i < 4; i++) {

                int row = disObj.RC.row + r[i];
                int col = disObj.RC.col + c[i];
                int newdis = disObj.dis + 1;

                if (row >= 0 && row < graph.length && col >= 0 &&
                        col < graph[0].length && graph[row][col] != 0) {

                    if (dis[row][col] > newdis) {

                        dis[row][col] = newdis;
                        queue.add(new disAndPair(newdis, new PairRC(row, col)));

                        if (row == desR && col == desC)
                            return newdis;

                    }
                }
            }
        }

        return -1;
    }

    class Pairof {

        public Pairof(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }

        int node;
        int dis;


    }

    class Three {


        public Three(int stop, int node, int dis) {
            this.stop = stop;
            this.node = node;
            this.dis = dis;
        }

        int stop;
        int node;
        int dis;


    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<Pairof>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            list.get(flights[i][0]).add(new Pairof(flights[i][1], flights[i][2]));
        }

        int[] dis = new int[n];
        for (int i = 0; i < dis.length; i++) {
            dis[i] = (int) 1e9;
        }

        dis[src] = 0;

        Three node = new Three(0, src, 0);

        Queue<Three> queue = new LinkedList<>();

        queue.add(node);

        while (!queue.isEmpty()) {

            var mark = queue.poll();
            int stop = mark.stop;
            int N = mark.node;
            int des = mark.dis;

            if (N == dst || stop > k)
                continue;

            for (Pairof it : list.get(N)) {
                if (dis[it.node] > des + it.dis) {
                    dis[it.node] = des + it.dis;
                    queue.add(new Three(stop + 1, it.node, des + it.dis));
                }

            }

        }

        if (dis[dst] == 1e9)
            return -1;

        return dis[dst];

    }

    public int minScore(int n, int[][] roads) {

        List<List<List<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.length; i++) {
            adj.get(roads[i][0]).add(Arrays.asList(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(Arrays.asList(roads[i][0], roads[i][2]));
        }

        int[] vis = new int[n + 1];
        int[] min = {Integer.MAX_VALUE};

        helperdfs(1, adj, vis, min);

        return min[0];

    }

    public void helperdfs(int n, List<List<List<Integer>>> roads, int[] vis, int[] min) {

        if (vis[n] == 1)
            return;

        vis[n] = 1;

        for (var node : roads.get(n)) {
            min[0] = Math.min(node.get(1), min[0]);
            helperdfs(node.get(0), roads, vis, min);
        }


    }

    public int makeConnected(int n, int[][] connections) {
        int[] vis = new int[n];

        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> adj2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < connections.length; i++) {

            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);


        }
        for (int i = 0; i < n; i++) {
            adj2.add(new ArrayList<>());
        }

        for (int i = 0; i < connections.length; i++) {

            adj2.get(connections[i][0]).add(connections[i][1]);
            adj2.get(connections[i][1]).add(connections[i][0]);


        }

        int connection = -1;
        int[] extraconnection = new int[]{0};

        for (int i = 0; i < adj.size(); i++) {

            if (vis[i] == 0) {
                connection++;
                helpermakeConnected(adj, vis, i, extraconnection);
            }
        }

        extraconnection = new int[]{0};
        vis = new int[n];

        for (int i = 0; i < adj2.size(); i++) {

            if (vis[i] == 0) {
                helpermakeConnected(adj2, vis, i, extraconnection);
            }
        }

        if (connection <= extraconnection[0]) {
            return connection;
        }

        return -1;
    }

    public void helpermakeConnected(List<List<Integer>> adj, int[] vis, int node, int[] extranode) {


        vis[node] = 1;

        for (var it : adj.get(node)) {

            if (vis[it] == 1) {
                extranode[0]++;
            }

            if (vis[it] == 0) {
                helpermakeConnected(adj, vis, it, extranode);
            }


        }


    }

    class tempPair {

        public tempPair(int parent, int child) {
            this.parent = parent;
            this.child = child;
        }

        int parent;
        int child;


    }

    public int minReorder(int n, int[][] connections) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        List<List<Integer>> list = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < connections.length; i++) {
            list.get(connections[i][0]).add(connections[i][1]);
            list.get(connections[i][1]).add(connections[i][0]);
            map.get(connections[i][0]).add(connections[i][1]);
        }


        int redirection = 0;

        int[] vis = new int[n];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);

        while (!queue.isEmpty()) {

            var node = queue.poll();
            vis[node] = 1;

            for (var it : list.get(node)) {
                if (vis[it] == 0) {
                    if (map.containsKey(node)) {
                        List<Integer> form = map.get(node);
                        if (chechcontain(form, it)) {
                            redirection++;
                        }
                    }
                    queue.add(it);

                }


            }


        }


        return redirection;


    }

    public boolean chechcontain(List<Integer> list, int val) {


        for (int num : list) {

            if (num == val)
                return true;

        }

        return false;

    }

    public long countPairs(int n, int[][] edges) {

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        int[] vis = new int[n];
        List<Integer> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                int[] nodeCount = new int[]{0};
                helpercountPairs(i, list, vis, nodeCount);
                graph.add(nodeCount[0]);
            }
        }
        if (graph.size() == 1)
            return 0;
        long ans = 0;
        for (int i = 0; i < graph.size(); i++) {
            int state = graph.get(i);
            int toMul = 0;
            for (int j = i + 1; j < graph.size(); j++) {
                toMul += graph.get(j);
            }
            ans += state * toMul;
        }
        return ans;
    }

    public void helpercountPairs(int node, List<List<Integer>> list, int[] vis, int[] nodeCount) {
        vis[node] = 1;
        nodeCount[0]++;
        for (var it : list.get(node)) {
            if (vis[it] == 0) {
                helpercountPairs(it, list, vis, nodeCount);
            }
        }
    }

    class GraphMST{

        int node;
        int dis;

        public GraphMST(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }
    }

    class WNP{

        public WNP(int weight, int node, int parent) {
            this.weight = weight;
            this.node = node;
            this.parent = parent;
        }

        int weight;
        int node;
        int parent;



    }

    public int spanningTree(int V, int E, int edges[][]){


        List<List<GraphMST>> adj = new ArrayList<>();

        for (int i = 0; i<edges.length;i++){
            adj.add(new ArrayList<>());
        }

        for (int i = 0;i<edges.length;i++){

            adj.get(edges[i][0]).add(new GraphMST(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new GraphMST(edges[i][0],edges[i][2]));


        }

        PriorityQueue<WNP> queue = new PriorityQueue<>();

        List<List<Integer>> list = new ArrayList<>();

        queue.add(new WNP(0,0,-1));

        int[] vis = new int[V];

        while (!queue.isEmpty()){

        }

   return 1;
    }


}
