import java.util.*;

public class Tree {

    int diameter = 0;
    int total = Integer.MIN_VALUE;
    boolean same = true;



    public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
      TreeNode() {

      }
      TreeNode(int val) {
          this.val = val;
      }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }


    }


    public int minDepth(TreeNode root){


       if (root == null)
           return 0;

       if (root.right == null && root.left == null)
           return 1;


      return minDepthHelper(root);

    }

    public int minDepthHelper(TreeNode root){

        if (root == null)
            return 0;

        int left = minDepth(root.left);

        int right = minDepth(root.right);

        int take = 0;

        if (left == 0){
            take = right;
        }else if (right == 0){
            take = left;
        }else if(left <= right){
            take = left;
        } else{
            take = right;
        }
        return 1+take;


    }


    public void tree(TreeNode tree){

        if (tree == null)
            return;

        tree(tree.left);
        System.out.println(tree.val);
        tree(tree.right);


    }

    public TreeNode sortedArrayToBST(int[] nums){

        return maketree(nums,0,nums.length-1);

    }
    public TreeNode maketree(int[] nums,int start, int end ){

       if (start > end)
           return null;

       if (start == end)
           return new TreeNode(nums[start]);

        int m = (start+end) / 2 ;
        var node = new TreeNode(nums[m]);

        node.left = maketree(nums,start,m-1);
        node.right = maketree(nums,m+1,end);

        return node;


    }





  public List<Integer> inorderTraversal(TreeNode root) {

      List<Integer> list =  new ArrayList<>();
      helper(root,list);
      return list;
    }
    public void helper(TreeNode root,List<Integer> list){

        if (root == null)return;

        helper(root.left,list);
        list.add(root.val);
        helper(root.right,list);

    }
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> finalAns = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            List<TreeNode> list = new ArrayList<>();

            while (!queue.isEmpty()){
                list.add(queue.poll());
            }

            for (var val : list){
               if(val.left != null){
                   queue.add(val.left);
               }
               if (val.right != null){
                   queue.add(val.right);
               }
            }

            List<Integer> lvlList = new LinkedList<>();
            for (var val: list){
                lvlList.add(val.val);
            }
            finalAns.add(lvlList);

        }
return finalAns;
    }

    public List<Integer> iterationPreOrder(TreeNode root){

        if (root ==null)
            return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.add(root);

        while (!stack.empty()){

           var popnode = stack.pop();

           list.add(popnode.val);

            if(popnode.right != null)
                stack.add(popnode.right);

            if(popnode.left != null)
                stack.add(popnode.left);


        }
        return list;
    }

    public List<Integer> iterationInorder(TreeNode root){

        if (root == null)
            return new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans =  new ArrayList<>();

        var node = root;


        while(!stack.isEmpty() || node != null){

            if(node != null){
                stack.add(node);
                node = node.left;
            }else{
                var val = stack.pop();
                ans.add(val.val);
                node= val.right;
            }

        }

        return ans;


    }

    public List<Integer> postInteration(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.add(root);

        while (!stack1.empty()){

            var take = stack1.pop();
            stack2.add(take);
            if(take.left != null){
                stack1.add(take.left);
            }
            if (take.right!= null){
                stack1.add(take.right);
            }

        }

        while (!stack2.empty()){

            ans.add(stack2.pop().val);
        }
        return ans;
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        List<List<Integer>> finalAns = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            List<TreeNode> list = new ArrayList<>();

            while (!queue.isEmpty()){
                list.add(queue.poll());
            }

            for (var val : list){
                if(val.left != null){
                    queue.add(val.left);
                }
                if (val.right != null){
                    queue.add(val.right);
                }
            }

            List<Integer> lvlList = new LinkedList<>();
            for (var val: list){
                lvlList.add(val.val);
            }
            finalAns.add(lvlList);

        }
        return finalAns.size();


    }

    public int maxDepth1(TreeNode root){

       if(root == null){
           return 0 ;
       }
       return 1+Math.max(maxDepth1(root.left),maxDepth1(root.right));


    }

    public boolean isBalanced(TreeNode root) {

        if (root == null)
            return true;

        int left = lastnode(root.left);
        int right = lastnode(root.right);

      if(Math.abs(left-right) > 1){
          return false;
      }
      boolean leftch = isBalanced(root.left);
      boolean rightch = isBalanced(root.right);

      if(!leftch || !rightch)
          return false;

      return true;
    }
    public int lastnode(TreeNode root){

        if (root == null)
            return 0;

        int left = lastnode(root.left);
        int right = lastnode(root.right);

        return 1+Math.max(left,right);


    }
    public int diameterOfBinaryTree(TreeNode root) {


     helper(root);
     return diameter;


    }
    public void helper(TreeNode root){

        if(root == null)
            return;

        int left = Height(root.left);
        int right = Height(root.right);

        diameter = Math.max(diameter,left+right);

        helper(root.left);
        helper(root.right);

    }


    public int Height(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = Height(root.left);
        int right = Height(root.right);

        return 1+ Math.max(left,right);
    }

    public int  maxPathSum(TreeNode root){
        maxPathSum1(root);
        return total;
    }

    public void  maxPathSum1(TreeNode root) {

        if(root == null)
            return;

        int left = totalNode(root.left);
        int right = totalNode(root.right);

        maxPathSum1(root.left);
        maxPathSum1(root.right);

        total = Math.max(root.val+left+right,total);

    }

    public int totalNode(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(0, totalNode(root.left));
        int right =Math.max(0, totalNode(root.right));

        return root.val+Math.max(left,right);

    }

    public boolean isSameTree(TreeNode p, TreeNode q){

        helper(p,q);
        return same;

    }
    public void helper(TreeNode p ,TreeNode q){

        if(p == null && q==null)
            return;
        if(p==null||q==null){
            same = false;
            return;
        }
        int val1 =p.val;
        int val2 =q.val;
        same = (same == true)?(val2 == val1):false;
        helper(p.left,q.left);

        helper(p.right,q.right);



    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> finalList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while(!stack.empty()){
            List<TreeNode> TempList = new ArrayList<>();
            while(!stack.empty()){
                TempList.add(stack.pop());
            }
            if((finalList.size()+1) % 2 != 0)
            for(var item : TempList) {
                if(item.left != null)
                    stack.add(item.left);
                if(item.right!=null)
                    stack.add(item.right);
            }
            else
                for (var item : TempList){
                 if(item.right!=null)
                     stack.add(item.right);
                 if(item.left != null)
                     stack.add(item.left);
             }
                List<Integer> list = new ArrayList<>();
         for (var list1 : TempList){
             list.add(list1.val);
         }
         finalList.add(list);

        }
        return finalList;
    }

    public List<Integer> boundaryTreversal(TreeNode root){
       Stack<Integer> stack = new Stack<>();
       List<Integer> list = new ArrayList<>();
       leftOnly(root,list);
       list.remove(list.size()-1);
       leaf(root,list);
       list.remove(list.size()-1);
       rightOnly(root,stack);
       while (!stack.empty()){
           list.add(stack.pop());
       }
       list.remove(list.size()-1);
       return list;

    }
    public void leftOnly(TreeNode root,List<Integer> list){
        if (root == null) {
            return;
        }
        list.add(root.val);
        var node = (root.left == null) ? root.right : root.left;
        leftOnly(node,list);

    }
    public void leaf(TreeNode root,List<Integer> list){
        if(root == null)
            return;

            if(root.left == null && root.right == null){
                list.add(root.val);
            }
            leaf(root.left,list);
            leaf(root.right,list);


    }
    public void rightOnly(TreeNode root,Stack<Integer> stack){
        if (root == null){
            return;
        }
      stack.add(root.val);
        var node = (root.right == null) ? root.left : root.right;
      rightOnly(node,stack);
    }

    class Nodes{
        public Nodes(TreeNode root, int vertex, int level) {
            this.root = root;
            this.vertex = vertex;
            this.level = level;
        }

        TreeNode root;
        int vertex;
        int level;

    }

   public List<List<Integer>> verticalTraversal(TreeNode root) {

        if (root==null)
            return new ArrayList<>();
       TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
       Queue<Nodes> queue = new LinkedList<>();
       Nodes n = new Nodes(root, 0, 0);
       queue.add(n);

       while (!queue.isEmpty()) {

           var tempNode = queue.poll();
           var node = tempNode.root;
           int v = tempNode.vertex;
           int l = tempNode.level;

           if (!map.containsKey(v)) {
               map.put(v, new TreeMap<>());
           }
           if (!map.get(v).containsKey(l)) {
               map.get(v).put(l, new PriorityQueue<>());
           }

           map.get(v).get(l).add(node.val);

           if (node.left != null)
               queue.add(new Nodes(node.left, v - 1, l + 1));

           if (node.right != null)
               queue.add(new Nodes(node.right, v + 1, l + 1));
       }

       List<List<Integer>> list = new ArrayList<>();
       for (var mp : map.values()) {
           list.add(new ArrayList<>());
           for (var q : mp.values()) {
               while (!q.isEmpty()) {

                   list.get(list.size() - 1).add(q.poll());
               }

           }

       }

       return list;
   }



   public List<Integer> topView(TreeNode root){
        var n = root;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        List<Integer> list = new ArrayList<>();
        Queue<TreeNodes> queue = new LinkedList<>();
        queue.add(new TreeNodes(root,0));
        int k = 0;

        while (!queue.isEmpty() || k==1){
            var tempnode = queue.poll();
            var node = tempnode.root;
            var vet = tempnode.ver;
            map.put(vet,node.val);
            if (k==0){
                if (node.left !=null){
                    queue.add(new TreeNodes(node.left,(vet-1)));
                }else {
                    k=1;
                    queue.add(new TreeNodes(n,0));
                }
            }else  {

                if(node.right != null){
                    queue.add(new TreeNodes(node.right,(vet+1)));
                }else{
                    k=0;
                }

            }
        }

        for(var m : map.values()){
            list.add(m);
        }

        return list;


   }
    public class TreeNodes{

        TreeNode root;
        int ver;

        public TreeNodes(TreeNode root, int ver) {
            this.root = root;
            this.ver = ver;
        }
    }

   public List<Integer> bottomView(TreeNode root){
        TreeMap<Integer,Integer> map = new TreeMap<>();
        List<Integer> list = new ArrayList<>();
        Queue<TreeNodes> queue = new LinkedList<>();
        queue.add(new TreeNodes(root,0));

        while (!queue.isEmpty()){
         var tempNode=queue.poll();
         var node = tempNode.root;
         int ver = tempNode.ver;
         map.put(ver,node.val);
         if(node.left != null)
            queue.add(new TreeNodes(node.left,(ver-1)));
         if (node.right != null)
             queue.add(new TreeNodes(node.right,(ver+1)));
        }

       for (var m : map.values()){
           list.add(m);
       }
       return list;
   }

   class NewNode{
       public NewNode(TreeNode root, int lvl) {
           this.root = root;
           this.lvl = lvl;
       }

       TreeNode root;
        int lvl;
   }

    public List<Integer> rightSideView1(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
       TreeMap<Integer,Integer> map = new TreeMap<>();
       List<Integer> finalAns = new ArrayList<>();
       Queue<NewNode> queue = new LinkedList<>();
       queue.add(new NewNode(root,0));

       while (!queue.isEmpty()){
           var tempnode = queue.poll();
           var node = tempnode.root;
           int x = tempnode.lvl;

           map.put(x,node.val);

           if (node.left != null)
               queue.add(new NewNode(node.left,x+1));

           if (node.right!=null)
               queue.add(new NewNode(node.right,x+1));

       }

       for (var m:map.values()){
           finalAns.add(m);
       }

       return finalAns;



    }
    List<Integer> list = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
      helper(root,list);
      return list;
    }

    public void helper(TreeNode root,int lvl){
        if(root == null) {
            return;
        }
            if(lvl == list.size())
                list.add(root.val);

            helper(root.right,lvl+1);
            helper(root.left,lvl+1);

    }
    boolean isSym = true;
    public boolean isSymmetric(TreeNode root) {
     if(root.right == null && root.left == null)
           return true;
     helper(root.left,root.right);
     return isSym;
    }
    public void helperss(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null){
            return;
        }
        if(root1.val != root2.val)
            isSym = false;

        helper(root1.left,root2.right);
        helper(root1.right,root1.left);

    }

      public List<Integer> rootPath(TreeNode root,int val){
        if (root == null){
            return new ArrayList<>();
        }
          ArrayList<Integer> ansList = new ArrayList<>();
         helperr(root,val,ansList);
         return ansList;


     }
   public boolean helperr(TreeNode root,int num,ArrayList<Integer> list){
       if (root == null)
           return false;
       list.add(root.val);
       if (root.val==num){
             return true;
         }
       if(!helperr(root.left,num,list) && !helperr(root.right,num,list)) {
             list.remove(list.size() - 1);
             return false;
         }
          return true;

     }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       ArrayList<TreeNode> list1  = new ArrayList<>();
       ArrayList<TreeNode> list2  = new ArrayList<>();
       helpers(root,p.val,list1);
       helpers(root,q.val,list2);

       int size = (list1.size()<=list2.size())? list1.size():list2.size();
       ArrayList<TreeNode> f = (list1.size()<=list2.size())? list1:list2;

       for (int i = 0;i<size;i++) {
           if (list1.get(i).val != list2.get(i).val)
               return list1.get(i-1);

       }

       return f.get(f.size()-1);

        }

        public boolean helpers(TreeNode root,int num, ArrayList<TreeNode> arr){
        if (root == null)
            return false;
        arr.add(root);
        if (root.val == num)
            return true;

        if (!helpers(root.left,num,arr) && !helpers(root.right,num,arr)){
            arr.remove(arr.size()-1);
            return false;
        }

        return true;

        }

        class Node{
            public Node(TreeNode root, int index) {
                this.root = root;
                this.index = index;
            }

            TreeNode root;
            int index;

        }

    public int widthOfBinaryTree(TreeNode root) {
         int width = 0;
        Queue<Node> queue =new LinkedList<>();
        queue.add(new Node(root,0));
        while(!queue.isEmpty()){
            int size = queue.size();
            int  mMin = queue.peek().index;
            int first =0;
            int second =0;

            for (int i = 0;i<size;i++){
                int cur_id = queue.peek().index - mMin;
                var Nody = queue.peek().root;
                queue.poll()
                ;
                if (i ==0)
                    first = cur_id;
                if (i == size-1)
                    second = cur_id;

                if (Nody.left != null)
                    queue.add(new Node(Nody.left,(cur_id*2)+1));
                if (Nody.right != null)
                    queue.add(new Node(Nody.right,(cur_id*2)+2));

            }
            width = Math.max(width,(second-first)+1);
        }
return width;


    }
     TreeNode node = null;
    public void findNode(int num,TreeNode root){

        if (root == null)
            return;
        if (num == root.val)
            node = root;



    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
       List<Integer> ans = new ArrayList<>();
        Map<TreeNode,TreeNode> map = new HashMap<>();
        int distance =0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Queue<TreeNode> queue1=new LinkedList<>();
        Set<TreeNode> set =  new HashSet<>();
        queue1.add(target);
        set.add(target);

        while(!queue.isEmpty()){
            var parent = queue.poll();
            if (parent.left != null) {
                queue.add(parent.left);
                map.put(parent.left , parent);
            }
            if (parent.right!= null) {
                queue.add(parent.right);
                map.put(parent.right,parent);
            }
        }
        while (distance < k){
            int size = queue1.size();
            int time =0;
            while (time<size) {

                var curNode = queue1.poll();
                if (map.containsKey(curNode) && !set.contains(map.get(curNode))){
                    queue1.add(map.get(curNode));
                    set.add(map.get(curNode));
                }
                if (curNode.left != null && !set.contains(curNode.left)) {
                    queue1.add(curNode.left);
                    set.add(curNode.left);
                }
                if (curNode.right != null && !set.contains(curNode.right)) {
                    queue1.add(curNode.right);
                    set.add(curNode.right);
                }

                time++;

            }

           distance++;

        }

        while (!queue1.isEmpty()){
            ans.add(queue1.poll().val);
        }
      return ans;
    }
    public int countNodes(TreeNode root) {
        if (root==null)
            return 0;

        int lefthight = leftTreeheight(root);
        int rightheight = rightTreeheight(root);

      if (lefthight==rightheight){
          return ((int)Math.pow(2,lefthight)) -1;
      }

      return 1+countNodes(root.left)+countNodes(root.right);



    }
    public int leftTreeheight(TreeNode root){
        if (root == null){
            return 0;
        }

      return 1+leftTreeheight(root.left);

    }
    public int rightTreeheight(TreeNode root){
        if (root == null)
            return 0;

        return 1+rightTreeheight(root.right);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
          Map<Integer,Integer> map = new HashMap<>();

          for (int i= 0;i<inorder.length;i++){
              map.put(inorder[i],i);
          }

          return setPathToBuild(preorder,0,preorder.length-1,
                  inorder,0,inorder.length-1,map);
    }

    public TreeNode setPathToBuild(int[] preorder,int preStart,int preend,
                                             int[] inOrder,int inStart,int inEnd,
                                             Map<Integer,Integer> map){

        if (preStart>preend || inStart>inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = map.get(root.val);
        int noNum = inRoot - inStart;

        root.left = setPathToBuild(preorder,preStart+1,preStart+noNum,
                                   inOrder,inStart,inRoot-1,map);
        root.right = setPathToBuild(preorder,preStart+noNum+1,preend,
                                     inOrder,inRoot+1,preend,map);

        return root;

    }



    public String serialize(TreeNode root){

        if (root == null)
            return "";

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder string = new StringBuilder();
        queue.add(root);

        while (!queue.isEmpty()){
            var node = queue.poll();
            if (node == null) {
                string.append("n ");
                continue;
            }

            string.append(node.val+" ");
            queue.add(node.left);
            queue.add(node.right);


        }
        return string.toString();

    }
    public TreeNode deSerialzie(String data){
        if (data == "")
            return null;

        String[] str = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = new TreeNode(Integer.parseInt(str[0]));
        queue.add(node);
        for (int i=1;i<str.length;i++){
            var parent = queue.poll();
            if (!str[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(str[i]));
                queue.add(left);
                parent.left = left;
            }
            if (!str[++i].equals("n")){
              TreeNode right = new TreeNode(Integer.parseInt(str[i]));
              queue.add(right);
              parent.right = right;
            }

        }
     return node;
    }
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            var cur = stack.pop();
            if (cur.right!=null)
                stack.push(cur.right);
            if (cur.left!=null)
                stack.push(cur.left);

            if (!stack.isEmpty()){
                cur.right = stack.pop();

            }
            cur.left=null;

        }

    }

    public int sumNumbers(TreeNode root){

      int[] mainsum = new int[]{0};
      int[] array = new int[]{0};

      helperSum(array,mainsum,root);

      return mainsum[0];


    }

    public void helperSum(int[] arraysum , int[] mainsum, TreeNode node ){

        if (node == null){
            return;
        }

        arraysum[0] = arraysum[0] * 10;
        arraysum[0] += node.val;

        helperSum(arraysum,mainsum,node.left);
        helperSum(arraysum,mainsum,node.right);


       if (node.right == null && node.left ==null)
        mainsum[0] += arraysum[0];


        arraysum[0]-= node.val;
        arraysum[0]/=10;



    }


    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.peek();

            if (node == null)
                break;

                node = queue.poll();

            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }

        }
        while (!queue.isEmpty()){

            var node = queue.poll();
            if (node != null)
                return false;
        }

      return true;
    }


    class PairCount{

        public PairCount(int des, int node) {
            this.des = des;
            this.node = node;
        }

        int des;
        int node;




    }

    class Pair{
        public Pair(int node, int des) {
            this.node = node;
            this.des = des;
        }

        int node;
        int des;

    }

    public int countPaths(int n, int[][] roads) {


        List<List<Pair>> adjlist = new ArrayList<>();

        for (int i=0;i<n;i++){
            adjlist.add(new ArrayList<>());
        }
        for (int i = 0;i<roads.length;i++){
            adjlist.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adjlist.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }


       int[] ways = new int[n];
       int[] des = new int[n];

       ways[0] = 1;

       for (int i = 0;i<n;i++){
           des[i] = (int)1e9;
       }

       des[0] = 0;


       PriorityQueue<List<Integer>> queue = new PriorityQueue<>((x,y)->x.get(0)-y.get(0)) ;
       List<Integer> list = Arrays.asList(0,0);
       queue.add(list);
       int mod = (int)(1e9+7);

       while(!queue.isEmpty()){
           var N = queue.poll();

           for (var it : adjlist.get(N.get(1))){

               if (N.get(0)+it.des < des[it.node]){
                   des[it.node] =N.get(0)+it.des;
                   queue.add(Arrays.asList( N.get(0)+it.des,it.node));
                   ways[it.node]+=ways[N.get(1)];
               }else if(N.get(0)+it.des == des[it.node]){
                   ways[it.node]= (ways[it.node]+ ways[N.get(1)])%mod;
               }


           }

       }
       return ways[n-1] % mod ;
    }

    public int longestZigZag1(TreeNode root) {

        int max = Integer.MIN_VALUE;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            var node = queue.poll();

            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }

            int check = helper2(node);
            max = Math.max(max,check);

        }

      return max;

    }


    public int helper2(TreeNode node){


        return Math.max(helperlongestZigZag1(node.left,'l'), helperlongestZigZag1(node.right,'r'));
    }

    public int helperlongestZigZag1(TreeNode node, char from){

        if (node == null)
            return 0;

        int right = 0;
        int left = 0;

        if (from == 'l'){

            right = helperlongestZigZag1(node.right,'r');

        }
        else if (from == 'r'){
            left = helperlongestZigZag1(node.left,'l');
        }

        return 1 + Math.max(right,left);


    }

  int max = Integer.MIN_VALUE;

   public int longestZigZag(TreeNode root){

       helperlongestZigZag(root.left,'l',0);
       helperlongestZigZag(root.right,'l',0);
       return max;


   }

   public void helperlongestZigZag(TreeNode node,char from,int current){

     if (node == null){
         return;
     }
     max = Math.max(current,max);

     helperlongestZigZag(node.left,'l',(from =='l') ? 1 : current+1);
     helperlongestZigZag(node.right,'r',(from =='r') ? 1 : current+1);

   }

}

