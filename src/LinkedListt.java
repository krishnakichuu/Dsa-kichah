import org.w3c.dom.ls.LSInput;

import java.util.*;

public class LinkedListt {
    public static class ListNode {

        public ListNode(int valu) {
            this.val = valu;
        }

         int val;
         ListNode next;

    }

    public ListNode head;
    private ListNode last;

    public ListNode insertLast(int val){
        var node = new ListNode(val);

        if (head == null)
            head = last = node;
        else {
            last.next = node;
            last = node;
        }
        return head;
        }

        public void inserfirst(int val){
        var node =  new ListNode(val);
        if (head == null)
            head =last=node;
        else{
         node.next = head;
         head = node;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {

        var cur = head;
        Map<Integer,Integer> map = new TreeMap<>();

        while (cur != null){

            if (map.containsKey(cur.val)){
                map.put(cur.val,map.get(cur.val)+1);

            }else {
                map.put(cur.val,1);
            }

            cur = cur.next;
        }

        ListNode ansList = new ListNode(0);
        var cur2 = ansList;

        for (var items : map.entrySet()){

            if (items.getValue() == 1){
                cur2.next = new ListNode(items.getKey());
                cur2 = cur2.next;
            }

        }

     return ansList.next;


    }


    public ListNode swapNodes(ListNode head, int k) {

        int count = 0;

        var cur = head;

        while (cur != null){

            count++;
            cur = cur.next;

        }

        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);

        int node1time = k;
        int node2time = count - k;

        cur = head;
        count = 1;
        while (cur!=null){

            if (count == k){
                node1 = cur;
            }if (count == node2time){
                node2 = cur;
            }

        }

        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;


        return head;

    }

    public int findindex(int item){
        var cur = head;
        int index = 0;
        while (cur.next != null){
            if (cur.val == item)
                return index;
            else
                index++;

            cur = cur.next;
        }
        return -1;
    }


    public ListNode middleNode() {
        var cur = head;
        int count = 0;
        while (cur != null){
            cur = cur.next;
            count++;
        }

        int mid = (count/2) +1;

        var cur1 = head;
        int count1 = 0;
        while(count1 != mid){
            cur1 = cur1.next;
            count1++;

        }
return cur1;
    }

    public ListNode reverseList() {
        ListNode pre = head;
        ListNode curr = head.next;
        while(curr != null){
            var next = curr.next;
          curr.next = pre;
          pre = curr;
          curr = next;
        }

        last = head;
        last.next = null;
         head = pre;

        return pre;
    }

    public boolean hasCycle() {
        Set<ListNode> set = new HashSet<>();
        var cur = head;
        while (cur != null) {
            if (set.contains(cur))
                return true;
            else {
                set.add(cur);
                cur = cur.next;
            }
        }
     return false;
    }

    public ListNode detectCycle() {

     Set<ListNode> set = new HashSet<>();
     var cur = head;
     while(cur != null){
         if(set.contains(cur))
             return cur;
         else{
             set.add(cur);
             cur = cur.next;
         }
     }
         return null;

    }

    public boolean isPalindrome(){

        Stack<ListNode> stack =  new Stack<>();
        var cur  = head;
        while(cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        var cur1 = head;
       while(!stack.isEmpty()){
           if(stack.peek().val == cur1.val) {
               stack.pop();
               cur1 = cur1.next;
               continue;
           }
           else
               return false;


       }
       return true;
    }

    public ListNode oddEvenList(){

        ListNode end = null;
        var cur = head;
        int count = 0;
        while(cur.next != null){
            count++;
            cur = cur.next;
        }
        end = cur;
        int time;
      if(count%2 == 0)
          time = count/2;
      else
          time = (count/2)+1;

      var temp = head;
      int howtimes = 0;
      while(howtimes < time){
          end.next = temp.next;
          temp.next = temp.next.next;
          end.next.next = null;
          temp = temp.next;
          end = end.next;
          howtimes++;
      }
      return head;
    }

    public ListNode removeNthFromEnd(int n) {

        int count = 1;
        var cur = head;
        while(cur.next != null){
            cur = cur.next;
            count++;
        }

        if (count == n){
            head = head.next;
            return head;

        }

        int res = 1;
        cur = head;
        while(count-res != n){
            cur = cur.next;
            res++;
        }
        cur.next = cur.next.next;

        return head;
    }

    public ListNode deleteMiddle() {

        if(head == null)
            return null;

      int count = 0;
      var cur = head;
      while(cur.next != null){
          cur = cur.next;
          count++;
      }
      int time = (count%2 == 0)?(count/2)-1:count/2;
      count = 0;
      cur = head;
      while (time !=count){
          cur = cur.next;
          count++;
      }
      cur.next = cur.next.next;

      return head;
    }

    public ListNode sortList() {
        var fisrt = head;
        ListNode second = null;

        while(fisrt.next != null){
            second = fisrt.next;
            while (second != null){
                if(fisrt.val > second.val){
                    var temp = fisrt.val;
                    fisrt.val = second.val;
                    second.val = temp;
                    second = second.next;
                }else

                    second = second.next;
            }
            fisrt = fisrt.next;
        }
        return head;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Set<ListNode> set = new HashSet<>();
        var cur = headA;
        while(cur != null){
            set.add(cur);
            cur = cur.next;
        }
        cur = headB;
        while(cur != null){
            if(set.contains(cur))
                return cur;
            else {
                set.add(cur);
                cur = cur.next;
            }
        }
        return null;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        if(l1.val == 0 && l2.val == 0)
            return new ListNode(0);


       long list1 = 0;
       long list2 = 0;
       int count = 0;

       var cur = l1;
       while(cur != null){
           list1 += Math.pow(10,count) * cur.val;
           count++;
           cur = cur.next;
       }

         cur = l2;
         count =0;
        while(cur != null){
            list2 += Math.pow(10,count) * cur.val;
            count++;
            cur = cur.next;
        }

        long total = (list1+list2);

       ListNode finallist = new ListNode(0);
       ListNode temp = finallist;
       while(total != 0){
           temp.next = new ListNode((int)(total%10));
           temp = temp.next;
           total = total/10;
       }

       return finallist.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if(k == 1 || head == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy,pre = dummy , nxt = dummy;

        int count =0;

        while(cur.next != null){
            cur = cur.next;
            count++;
        }
        while(count >= k){
            cur = pre.next;
            nxt = cur.next;
            for(int i =0;i<k;i++){
                cur.next = nxt.next;
                nxt.next = pre.next;
                pre.next = nxt;
                nxt = cur.next;
            }
            pre = cur;
            count-=k;
        }
        return dummy.next;
    }
    public ListNode rotateRight(ListNode head, int k) {

        int count = 0;
        var cur = head;

        while(cur!=null){
            cur = cur.next;
            count++;
        }
      int rotateK = (count<=k) ? count%k : k;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy,nxt = dummy;

        while(rotateK != 0){
            pre = dummy.next;
            cur = pre;
            nxt = cur.next;
            while(nxt.next != null){
                cur = nxt;
                nxt = nxt.next;
            }
            cur.next = null;
            nxt.next = pre;
            dummy.next = nxt;
            rotateK--;
        }
        return dummy.next;
    }

    public void display() {

        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val+"<->");
            temp = temp . next;
        }
        System.out.println("NULL");

    }
}
