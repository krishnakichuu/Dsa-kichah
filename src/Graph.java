import java.util.*;

public class Graph {


   class Pair{
       int row;
       int col;
       public Pair(int row, int col){
           this.row = row;
           this.col = col;
       }


   }

    public void dfs(int node, int[] vis,ArrayList<ArrayList<Integer>> adj){

        vis[node] =1;

        for (var it : adj.get(node)){
            if (vis[it] == 0){
                dfs(it,vis,adj);
            }
        }

    }


    public int findCircleNum(int[][] isConnected) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i =0;i<isConnected.length;i++){
            list.add(new ArrayList<>());
        }

        for (int j=0;j<isConnected.length;j++){
            for (int k =0;k<isConnected.length;k++){
                if (isConnected[j][k] == 1 && j!=k) {
                    list.get(j).add(k);

                }
            }
        }

        int[] vis  =  new int[isConnected.length];
        int cnt =0;


        for (int i=0;i<isConnected.length;i++){

            if (vis[i] ==  0){
                cnt++;
                dfs(i,vis,list);
            }
        }
        return cnt;

    }




    public void bfs(Pair node,int[][] visMat, List<List<Integer>> adj,int row, int col){



        Queue<Pair> queue = new LinkedList<>();
        queue.add(node);
        visMat[node.row][node.col] = 1;
        while(queue.isEmpty()){
            var takeNode = queue.poll();
            int r= takeNode.row;
            int c = takeNode.col;
            if(visMat[r][c] == 0) {
                if (r == 0 && c == 0) {

                    if(adj.get(r).get(c + 1) == 1){
                       visMat[r][c+1] = 1;
                       queue.add(new Pair(r,c+1));
                    }

                    if (adj.get(r+1).get(c) ==1){
                        visMat[r+1][c] =1;
                        queue.add(new Pair(r+1,c));
                    }

                    if (adj.get(r+1).get(c+1) == 1){
                        visMat[r+1][c+1] = 1;
                        queue.add(new Pair(r+1,c+1));
                    }


                }else if(r == 0 && c != col-1){


                    if(adj.get(r).get(c + 1) == 1){
                        visMat[r][c+1] = 1;
                        queue.add(new Pair(r,c+1));
                    }

                    if (adj.get(r+1).get(c) ==1){
                        visMat[r+1][c] =1;
                        queue.add(new Pair(r+1,c));
                    }

                    if (adj.get(r+1).get(c+1) == 1){
                        visMat[r+1][c+1] = 1;
                        queue.add(new Pair(r+1,c+1));
                    }

                    if (adj.get(r).get(c-1) == 1){
                        visMat[r][c-1] =1;
                        queue.add(new Pair(r,c-1));
                    }
                    if (adj.get(r+1).get(c-1) == 1){
                        visMat[r+1][c-1] = 1;
                        queue.add(new Pair(r-1,c-1));
                    }

                }
                else if (r == 0 && c == col-1){

                    if (adj.get(r+1).get(c) ==1){
                        visMat[r+1][c] =1;
                        queue.add(new Pair(r+1,c));
                    }

                    if (adj.get(r).get(c-1) == 1){
                        visMat[r][c-1] =1;
                        queue.add(new Pair(r,c-1));
                    }
                    if (adj.get(r-1).get(c-1) == 1){
                        visMat[r-1][c-1] = 1;
                        queue.add(new Pair(r-1,c-1));
                    }

                }
                else if(r!=row-1 && c==0){

                    if(adj.get(r).get(c + 1) == 1){
                        visMat[r][c+1] = 1;
                        queue.add(new Pair(r,c+1));
                    }

                    if (adj.get(r+1).get(c) ==1){
                        visMat[r+1][c] =1;
                        queue.add(new Pair(r+1,c));
                    }

                    if (adj.get(r+1).get(c+1) == 1){
                        visMat[r+1][c+1] = 1;
                        queue.add(new Pair(r+1,c+1));
                    }
                    if (adj.get(r-1).get(c) == 1){
                        visMat[r-1][c] = 1;
                        queue.add(new Pair(r-1,c));
                    }
                    if (adj.get(r-1).get(c-1) == 1){
                        visMat[r-1][c-1] = 1;
                        queue.add(new Pair(r-1,c-1));
                    }


                }else if (c==0 && r == row-1){

                    if (adj.get(r-1).get(c) == 1){
                        visMat[r-1][c] = 1;
                        queue.add(new Pair(r-1,c));
                    }
                    if (adj.get(r-1).get(c-1) == 1){
                        visMat[r-1][c-1] = 1;
                        queue.add(new Pair(r-1,c-1));
                    }

                    if(adj.get(r).get(c + 1) == 1){
                        visMat[r][c+1] = 1;
                        queue.add(new Pair(r,c+1));
                    }


                }else if (r == row-1 && c != col-1){

                    if (adj.get(r-1).get(c) == 1){
                        visMat[r-1][c] = 1;
                        queue.add(new Pair(r-1,c));
                    }

                    if(adj.get(r).get(c + 1) == 1){
                        visMat[r][c+1] = 1;
                        queue.add(new Pair(r,c+1));
                    }

                    if(adj.get(r).get(c - 1) == 1){
                        visMat[r][c-1] = 1;
                        queue.add(new Pair(r,c-1));
                    }

                    if(adj.get(r-1).get(c + 1) == 1){
                        visMat[r-1][c+1] = 1;
                        queue.add(new Pair(r-1,c+1));
                    }


                    if(adj.get(r-1).get(c - 1) == 1){
                        visMat[r-1][c-1] = 1;
                        queue.add(new Pair(r-1,c-1));
                    }


                }else if (r == row-1 && c == col-1){

                    if(adj.get(r-1).get(c ) == 1){
                        visMat[r-1][c] = 1;
                        queue.add(new Pair(r-1,c));
                    }

                    if(adj.get(r-1).get(c - 1) == 1){
                        visMat[r-1][c-1] = 1;
                        queue.add(new Pair(r-1,c-1));
                    }

                    if(adj.get(r).get(c - 1) == 1){
                        visMat[r][c-1] = 1;
                        queue.add(new Pair(r,c-1));
                    }


                }


            }

        }


    }


    public int noOfIsland(List<List<Integer>> adj){
       int noOfIsland = 0;
        int row = adj.size();
        int col = adj.get(0).size();

        int[][] visMat = new int[row][col];

        for (int i=0;i< row;i++){
            for (int j =0;j<col;j++){
                if (adj.get(i).get(j) == 1 && visMat[i][j] == 0){
                    noOfIsland++;
                    bfs(new Pair(i,j),visMat, adj,row,col);
                }

            }
        }

return noOfIsland;
    }

    public void dfsFlood(int[][] mat ,int[][] vis, int start , int end, int colour, int givenColor){

       if (start<0 || start>=mat.length || end<0 || end>=mat[0].length || mat[start][end] == colour ||
               mat[start][end] != givenColor)
           return;

     if (start>=0 && start<mat.length && end>=0 && end<mat[0].length &&
             mat[start][end] == givenColor){
         mat[start][end] = colour;
         vis[start][end] = -1;
     }
     dfsFlood(mat,vis,start-1,end,colour,givenColor);
     dfsFlood(mat,vis,start+1,end,colour,givenColor);
     dfsFlood(mat,vis,start, end+1,colour,givenColor);
     dfsFlood(mat,vis,start,end-1,colour,givenColor);

   }

    public int[][] fillFlood(int[][] mat, int start , int end, int color){

       int[][] replica = mat;
       int[][] vis = new int[mat.length][mat[0].length];
       int givenColour = mat[start][end];
       dfsFlood(replica,vis,start,end,color,givenColour);
       return replica;
   }


   class CPair{
       int cur;
       int from;

       public CPair(int cur, int from){
           this.cur = cur;
           this.from = from;
       }
   }

   public boolean bfs(int j ,List<List<Integer>> adj, int V,boolean[] vis){

       vis[j] = true;
       Queue<CPair> queue = new LinkedList<>();
       CPair n = new CPair(j,-1);

       queue.add(n);

       while(!queue.isEmpty()){
           var node = queue.poll();
           int cur = node.cur;
           int form = node.from;

           for (int list : adj.get(cur)){

               if (list != form && vis[list] == true)
                   return true;

               if(form!=list){
                 queue.add(new CPair(list,cur));
                 vis[list] = true;
               }

           }


       }

       return false;


   }

   public boolean delectCycle(int V , List<List<Integer>> adj){

       Queue<CPair> queue =new LinkedList<>();
       boolean[] vis = new boolean[V];
       for (int i = 0;i<V;i++) vis[i] = false;

       for (int j =0;j<V;j++){
         if (vis[j] == false){
             if(bfs(j,adj,V,vis)) return true;
         }
       }


      return false;

   }
   class DistancePair{
       int row;
       int col;
       int dis;

       public DistancePair(int row, int col, int dis) {
           this.row = row;
           this.col = col;
           this.dis = dis;
       }


   }

   public void bfsDistance(int[][] adj, int[][] vis, int[][] distance){
       Queue<DistancePair> queue = new LinkedList<>();

       for (int i=0;i<adj.length;i++){
           for (int j=0;j<adj[0].length;j++){
               if (adj[i][j] == 0) {
                   queue.add(new DistancePair(i, j, 0));
                   vis[i][j] = 1;
               }
           }
       }


       int[] drow ={-1,0,1,0};
       int[] dcol ={0,1,0,-1};

       while (!queue.isEmpty()){
           var node = queue.poll();
           int row = node.row;
           int col =node.col;
           int dis = node.dis;

          distance[row][col] = dis;

           for (int i=0;i<4;i++){

                  int r = row+drow[i];
                  int c = col+dcol[i];

             if (r>=0 && r<adj.length && c>=0 && c<adj[0].length && vis[r][c] == 0){

                 queue.add(new DistancePair(r,c,dis+1));
                 vis[r][c] =1;

             }


           }

       }
   }


    public int[][] updateMatrix(int[][] mat) {

       int[][] vis =  new int[mat.length][mat[0].length];
       int[][] dis = new int[mat.length][mat[0].length];


       bfsDistance(mat,vis,dis);

       return dis;





    }



    public void  bfs(int[][] vis, char[][] board,int row,int col){
       if ( row<0 || row>=vis.length || col < 0 || col>=vis[0].length || vis[row][col] == 1 || board[row][col] == 'O')
           return;

       vis[row][col] =1;
       int[] r = {-1,0,1,0};
       int[] c = {0,1,0,-1};
       for (int i = 0;i<4;i++){
           bfs(vis,board,row+r[i],col+c[i]);
       }

   }

    public void solve(char[][] board) {
       int[][] vis = new int[board.length][board[0].length];
       for (int i = 0;i<board.length;i++){
           for (int j =0;j<board[0].length;j++){
               if (((i==0) || (j==0) || j == board[0].length-1 || i == board.length-1 ) && vis[i][j] == 0 && board[i][j] == 'O'){
                   bfs(vis,board,i,j);
               }
           }
       }
       for (int i = 0;i<vis.length;i++){
           for (int j =0;j<vis[0].length;j++){
            if (vis[i][j] != 1)
                board[i][j] = 'X';
           }
       }

   }

    public int numEnclaves(int[][] grid) {

       int countLand = 0;

       int[][] vis = new int[grid.length][grid[0].length];

       for (int i =0;i<grid.length;i++){
           for (int j =0;j<grid[0].length;j++){

               if ((i == 0 || j ==0 || i == grid.length-1||j==grid[0].length-1) && vis[i][j] == 0 && grid[i][j] == 1){
                   landDfs(grid,vis,i,j);
               }

           }

       }
       for (int i =0;i<grid.length;i++){
           for (int j =0;j<grid[0].length-1;j++){
               if (grid[i][j] == 1 && vis[i][j] == 0){
                   countLand++;
               }
           }
       }
return countLand++;
    }
    public void landDfs(int[][] grip, int[][] vis, int row, int col){
        if( ( row<0 || col < 0 ||row >= grip.length || col>=grip[0].length || row<0 || col < 0 ) || (vis[row][col] == 1) || grip[row][col] == 0)
            return;

        vis[row][col] = 1;

        int[] r = {-1,0,1,0};
        int[] c = {0,1,0,-1};

        for (int i = 0;i<4;i++){
            landDfs(grip,vis,row+r[i],col+c[i]);
        }
   }

   public int countDistinctIslands(int[][] grid) {

       Set<List<List<Integer>>> set = new HashSet<>();
       int[][] vis  = new int[grid.length][grid[0].length];
       for (int i =0;i<grid.length;i++){
           for (int j =0;j<grid[0].length;j++){
               List<List<Integer>> temp =new ArrayList<>();
               if(grid[i][j] == 1 && vis[i][j] ==0){

                 countDistinctIslandsDfs(grid,vis,i,j,i,j,temp);
                 set.add(temp);

               }

           }
       }

        return set.size();
    }

    public void countDistinctIslandsDfs(int[][] grid,int[][] vis,int baseR, int baseC,int row, int col , List<List<Integer>> set){

       if (( row<0 || col < 0|| row >= grid.length|| col>=grid[0].length) || vis[row][col] == 1 || grid[row][col] == 0 )
           return;

       vis[row][col] = 1;
       List<Integer> interlist = new ArrayList<>();
       interlist.add(baseR-row);
       interlist.add(baseC-col);
       set.add(interlist);


        int[] r = {-1,0,1,0};
        int[] c = {0,1,0,-1};

        for (int i = 0;i<4;i++){
            countDistinctIslandsDfs(grid,vis,baseR,baseC,row+r[i],col+c[i],set);


        }


    }

    public boolean isBipartite(int[][] graph) {

       int[] vis = new int[graph.length];
       for (int i =0;i<graph.length;i++){
           vis[i]=-1;
       }
       for (int i =0;i<graph.length;i++) {
           if (vis[i] == -1)
           if(isBipartiteDfs(graph, vis, i, 0)==false) return false;
       }

      return true;


    }

    public boolean isBipartiteDfs(int[][] graph, int[] vis,int node, int color){


       vis[node] = color;

      for(var it : graph[node]){
         if (vis[it] == -1){
             if (isBipartiteDfs(graph,vis,it,1-color) == false) return false;
         }
         else if (vis[it] == color)
             return false;
      }

      return true;
    }

    public boolean circleInDirector(int[][] graph){
      int[] vis = new int[graph.length];
      int[] pathVis = new int[graph.length];

      for (int i=0;i<graph.length;i++){
          if (vis[i] == 0){
              if (circleInDirectorDfs(graph,vis,pathVis,i)==true) return true;
          }
      }
       return false;

    }
    public boolean circleInDirectorDfs(int[][] graph,int[] vis, int[] pathVis,int node){

       vis[node] = 1;
       pathVis[node] = 1;



       for (int it : graph[node]){
           if (vis[it] == 0){
               if (circleInDirectorDfs(graph,vis,pathVis,it) == true)
                   return true;

           } else if(pathVis[it] == 1){
               return true;
           }
       }

       pathVis[node] =0;
       return false;
   }

 public List<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj){

       int[] vis = new int[adj.size()];
       Stack<Integer> stack =new Stack<>();

       for (int i = 0;i<adj.size();i++){
           if (vis[i] == 0){
               topologicalSortDfs(adj,vis,stack,i);
           }

       }

       List<Integer> sortList = new ArrayList<>();
       while (!stack.isEmpty()){
           sortList.add(stack.pop());
       }
  return sortList;

 }
 public void topologicalSortDfs(ArrayList<ArrayList<Integer>> adj,int[] vis, Stack<Integer> stack,int node){

       vis[node] = 1;

       for (var it : adj.get(node)){
           if (vis[it] == 0){
               topologicalSortDfs(adj,vis,stack,it);
           }
       }

       stack.add(node);

 }
 public List<Integer> topologicalSortB(ArrayList<ArrayList<Integer>> adj){

       int[] degree = new int[adj.size()];
       Queue<Integer> queue =new LinkedList<>();
       List<Integer> ans =  new ArrayList<>();

          for (int i =0;i<adj.size();i++){
              for (var it : adj.get(i)){
                  degree[it]++;
              }
          }
    for (int i = 0;i<degree.length;i++){
        if (degree[i] == 0){
            queue.add(i);
        }
    }

    while (!queue.isEmpty()){
        var node = queue.poll();
        ans.add(node);
        for(int it : adj.get(node)){
            degree[it]--;
            if (degree[it] == 0){
                queue.add(it);
            }
        }

    }

return ans;

 }

    public List<Integer> eventualSafeNodes(int[][] graph){

       List<Integer> ans  = new ArrayList<>();

       List<List<Integer>> newAdj = new ArrayList<>();

       for (int i =0;i<graph.length;i++){
           newAdj.add(new ArrayList<>());
       }

       for (int i = 0 ;i<graph.length;i++){
           for (var it : graph[i]){
              newAdj.get(it).add(i);
           }
       }

       int[] inDegree = new int[graph.length];

       for (int i =0;i<newAdj.size();i++){
           for (var it : newAdj.get(i)){
               inDegree[it]++;
           }
       }

       Queue<Integer> queue =new LinkedList<>();
       for (int i = 0;i<inDegree.length;i++){

           if (inDegree[i] == 0){
               queue.add(i);
           }


       }

       while (!queue.isEmpty()){

           var node = queue.poll();
           ans.add(node);

           for (var subnode : newAdj.get(node)){
               inDegree[subnode]--;
               if (inDegree[subnode] == 0){
                   queue.add(subnode);
               }
           }
       }

       Collections.sort(ans);

       return ans;




    }

    public class GraphPair{

       int node;
       int dis;


        public GraphPair(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }
    }

    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        Queue<GraphPair> queue =new LinkedList<>();
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       for (int i =0;i<n;i++){
           adj.add(new ArrayList<>());
       }

       for(int i =0 ;i<m;i++){
          adj.get(edges[i][0]).add(edges[i][1]);
          adj.get(edges[i][1]).add(edges[i][0]);
       }

       int[] dis = new int[n];
       for (int i =0;i<dis.length;i++){
           dis[i] = -1;
       }

       queue.add(new GraphPair(src,0));

       while (!queue.isEmpty()){
           var pair = queue.poll();
           int node = pair.node;
           int distance = pair.dis;
           dis[node] = distance;

           for (var it : adj.get(node)){
               if (dis[it] == -1){
                   queue.add(new GraphPair(it,distance+1));
               }
           }


       }



     return dis;


    }

    class GraphPairHeight{

        public GraphPairHeight(int node, int height) {
            this.node = node;
            this.height = height;
        }

        int node;
       int height;

    }
    public int[] shortestPath(int N,int M, int[][] edges) {

       ArrayList<ArrayList<GraphPairHeight>> graph =new ArrayList<>();

       for (int i =0;i<N;i++){
           graph.add(new ArrayList<>());
       }

       for (int i = 0 ;i<M;i++){
           graph.get(edges[i][0]).add(new GraphPairHeight(edges[i][1],edges[i][2]));
       }

     return new int[9];
    }

    public Stack<Integer> toposort( ArrayList<ArrayList<GraphPairHeight>> graph){

       Stack<Integer> stack = new Stack<>();
       int[] vis = new int[graph.size()];

       for (int i = 0;i<graph.size();i++){
           if (vis[i] == 0){
               toposortdfs(i,graph,stack,vis);
           }
       }
       return stack;
    }
    public void toposortdfs(int node,ArrayList<ArrayList<GraphPairHeight>> graph, Stack<Integer> stack,int[] vis){

       vis[node] = 1;

       for (var it : graph.get(node)){
          if (vis[it.node] == 0)
              toposortdfs(it.node,graph,stack,vis);
       }

        stack.add(node);
   }


}
