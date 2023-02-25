import com.sun.source.tree.Tree;

import java.util.*;

public class BTS {
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
    TreeNode ans = new TreeNode();

    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null)
            return null;
        if (root.val == val)
            return root;
        if (root.val>val)
            return searchBST(root.left,val);
            else{
                return searchBST(root.right,val);
        }
    }
    public void helper(TreeNode root, int val){
         if (root.val == val)
             ans=root;
         if (root.val>val)
             helper(root.left,val);
         else if (root.val<val)
             helper(root.right,val);

    }

    public int findCeil(TreeNode root,int maxCeil,int k){

      if (root == null)
          return 0;

      if (root.val >= k){
          maxCeil = Math.min(maxCeil,root.val);
          findCeil(root.left,maxCeil,k);
          return maxCeil;
      }

      else {
          return findCeil(root.right,maxCeil,k);
      }
    }

    public  int findFloor(TreeNode root,int k){
        int flood = -1;

        while(root!=null){

             if (root.val == k)
                 return k;

             if (root.val > k)
                 root = root.left;

             else{
                 flood = root.val;
                 root = root.right;
             }

        }
        return flood;


    }

    public TreeNode insertIntoBST(TreeNode root, int val) {

          var cur  = root;
        while(cur.left != null || cur.right != null){

            if (cur.val > val){
                if (cur.left != null)
                cur = cur.left;
                else{
                    TreeNode node = new TreeNode(val);
                    cur.left = node;
                  return root;
                }
            }else{
                if (cur.right != null)
                    cur =cur.right;
                else {
                    TreeNode node = new TreeNode(val);
                    cur.right = node;
                   return root;
                }
            }

        }
       if (cur.val >val)
           cur.left = new TreeNode(val);
       else
           cur.right = new TreeNode(val);

       return root;

    }
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null)
            return null;

        if (root.left == null && root.right == null && root.val == key){
            return null;
        }

        TreeNode tempLeft;
        TreeNode tempRight;
        TreeNode cur2;
        TreeNode preNode = null;
        var cur = root;

        while(cur != null){

            if (cur.val > key){
                preNode = cur;
                cur =cur.left;
            }else if(cur.val < key) {
                preNode = cur;
                cur = cur.right;
            }

            else if (cur.val == key){

                if (preNode == null){
                    if (cur.left == null)
                        return cur.right;
                    if (cur.right == null)
                        return cur.left;

                    var left = cur.left;
                    var right = cur.right;
                   var cur3 = left;
                   while(cur3.right != null){
                       cur3 = cur3.right;
                   }
                   cur3.right = right;
                   return left;
                }

              else if (cur.left != null && cur.right != null){

                    tempLeft = cur.left;
                    tempRight = cur.right;
                    cur2 = tempRight;

                    while(cur2.left != null){
                        cur2 = cur2.left;
                    }
                   cur2.left = tempLeft;

                    if (preNode.val > tempRight.val) {
                        preNode.left = tempRight;
                        break;
                    }else{
                        preNode.right = tempRight;
                        break;
                    }
                }

              else if(cur.right  == null && cur.left != null){

                    if (preNode.val > cur.left.val) {
                        preNode.left = cur.left;
                        break;
                    }else if (preNode.val < cur.left.val){
                        preNode.right = cur.left;
                        break;
                    }
                }

                else if (cur.left == null && cur.right != null){


                    if (preNode.val > cur.right.val){
                        preNode.left = cur.right;
                        break;
                    }else if (preNode.val < cur.right.val){
                        preNode.right = cur.right;
                        break;
                    }


                }else if (cur.left == null && cur.right == null){
                    if (cur.val < preNode.val){
                        preNode.left = null;
                        break;
                    }else{
                        preNode.right = null;
                        break;
                    }
                }


            }

        }


      return root;
    }
    public int kthSmallest1(TreeNode root, int k) {
       List<Integer> list = new ArrayList<>();
       helpers(list,root);
        Collections.sort(list);
        return list.get(k-1);



    }

    public void helpers(List<Integer> list , TreeNode root){
        if (root == null)
            return;
        list.add(root.val);
        helpers(list,root.left);
        helpers(list,root.right);
    }
    int enter = 0;
    int val = 0;


    public int kthSmallest(TreeNode root ,int k){
        kthSmallesthelper(root,k);
        return val;
    }

    public void kthSmallesthelper(TreeNode root, int k) {

        if (root == null)
            return;


        kthSmallesthelper(root.left, k);
        enter++;
        if (enter ==k){
            val = root.val;
        }

        kthSmallesthelper(root.right,k);


    }
    public boolean isValidBST(TreeNode root) {
       List<Integer> list =new ArrayList<>();
       validhealper(root,list);

       for (int i = 0;i<list.size()-1;i++){
           if (list.get(i)>list.get(i+1))
               return false;
       }

       return true;

    }

    public void validhealper(TreeNode root,List<Integer> list){

        if (root == null)
            return;

        validhealper(root.left,list);
        list.add(root.val);
        validhealper(root.right,list);


    }

    public TreeNode LCBWhile(TreeNode root , TreeNode p , TreeNode q){

        var cur = root;

        while(true){
            if (cur.val < p.val && cur.val < q.val){
                cur = cur.right;
                continue;
            }if (cur.val>p.val && cur.val>q.val){
                cur = cur.left;
                continue;
            }
            return cur;

        }


    }
    public TreeNode niveApproch(int[] arr){

        TreeNode node = new TreeNode(arr[0]);

        for (int i = 1;i<arr.length;i++){

       insertNode(node,arr[i]);

        }
        return node;
    }

    public void insertNode(TreeNode root,int val){
        var cur = root;
        var preNode  = root;

        while (cur!=null){
            if(cur.val>val) {
                preNode = cur;
                cur = cur.left;
            }
            else {
                preNode = cur;
                cur = cur.right;
            }

        }

        if (preNode.val > val){

            preNode.left = new TreeNode(val);
        }else {
            preNode.right = new TreeNode(val);
        }


    }

    public TreeNode inorderSuccessor(TreeNode root, int val){


       TreeNode success = null;

       var cur = root;

       while(cur!=null){
         if (cur.val > val){
             success = cur;
             cur = cur.left;
         }else{
             cur = cur.right;
         }
       }
       return success;

    }



}
