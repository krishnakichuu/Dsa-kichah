import java.util.ArrayList;
import java.util.List;

public class Disjoind {

    List<Integer> parent = new ArrayList<>();
    List<Integer> rank =new ArrayList<>();

    public Disjoind(int n){
        for (int i = 1;i<=n;i++){
            parent.add(i);
            rank.add(0);
        }
    }

   public int findparent(int node){

        if (node == parent.get(node))
            return node;

        int par = findparent(parent.get(node));

        parent.set(node,par);

        return parent.get(node);

   }
   public void unionByRank(int u, int v){
        int ux = findparent(u);
        int vx = findparent(v);

        if(rank.get(ux)<rank.get(vx)){
          parent.set(ux,vx);
        }else if (rank.get(vx) < rank.get(ux)){
            parent.set(vx,ux);
        }else {
            parent.set(vx,ux);
            int r = rank.get(ux);
            rank.set(ux,r+1);


        }



   }




}
