import java.util.Stack;

public class BSTIterator1 {

    public static class TreeNode {
    int val;
    BSTIterator1.TreeNode left;
        BSTIterator1.TreeNode right;
    TreeNode() {


    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, BSTIterator1.TreeNode left, BSTIterator1.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

    Stack<TreeNode> stack =  new Stack<>();

    public BSTIterator1(TreeNode root) {
        var cur = root;

       while(cur!= null){
           stack.add(cur);
           cur = cur.left;
       }
    }

    public int next() {
       var nextval =  stack.pop();
       if (nextval.right!= null){
           var rightCur = nextval.right;
           while (rightCur!=null){
               stack.add(rightCur);
               rightCur = rightCur.left;
           }
       }
       return nextval.val;
    }

    public boolean hasNext() {
       if (stack.isEmpty())
           return false;
       else
           return true;
    }


}
