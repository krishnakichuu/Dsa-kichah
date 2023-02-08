import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

}
