import java.util.*;

public class Heap {
     ListNode head;

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {
      }
     ListNode(int val) {
          this.val = val;
      }
      ListNode(int val, ListNode next) {
          this.val = val; this.next = next; }

    }
    public boolean countSub(long arr[], long n) {

        long rootLength = n/2;
        for (int  i = 0;i<rootLength;i++){
            int l = (2*i)+1;
            int r = (2*i)+2;
           if(l < arr.length && arr[l] > arr[i])
               return false;
           if(r < arr.length && arr[r] > arr[i])
               return false;
        }
        return true;
    }

    public ListNode mergeKLists(ListNode[] lists) {

        Queue<Integer> minHeap = new PriorityQueue<>();

        for(var ls : lists){
            while(ls != null){
                minHeap.add(ls.val);
                ls = ls.next;
            }
        }

        while (!minHeap.isEmpty()){
            helpinsert(minHeap.poll());
        }

      return head;
    }
  public void helpinsert(int val){
       ListNode node = new ListNode(val);
       if(head == null){
           head = node;
       }else{
           var cur = head;
           while(cur.next != null){
               cur = cur.next;
           }
           cur.next = node;

       }
  }

    public int leastInterval(char[] tasks, int n) {

        if(tasks.length == 1)
            return 1;
        else if(n == 0)
            return tasks.length;

        int minTaskTime =0;

        Map<Character,Integer> map = new HashMap<>();
        for (var ch : tasks){
            map.put(ch,1+map.getOrDefault(ch,0));
        }
        Queue<Integer> preQ = new PriorityQueue<>();

        for (var fr : map.entrySet()){
           preQ.add(-1*fr.getValue());
        }
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        boolean doing = true;
        while(doing){
            minTaskTime++;
            if(!preQ.isEmpty()) {
                int taskFrq = preQ.poll() + 1;
                int waitTime = minTaskTime + n;
                ArrayList<Integer> list = new ArrayList<>();
                list.add(taskFrq);
                list.add(waitTime);
                if (taskFrq != 0)
                    q.add(list);
            }

            if(!q.isEmpty() && minTaskTime == q.peek().get(1)){
                var peek = q.poll();
                preQ.add(peek.get(0));
            }
        if (preQ.isEmpty() && q.isEmpty())
            doing = false;

        }

       return minTaskTime;


        }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0)
            return false;

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0 ;i<hand.length;i++){
            map.put(hand[i],1+map.getOrDefault(hand[i],0));
        }
        Queue<Integer> q = new PriorityQueue<>();

        for(var key : map.entrySet()){
           q.add(key.getKey());
        }

        Map<Integer,List<Integer>> n = new HashMap<>();

        while(!q.isEmpty()){
          int setFirst = q.peek();
          int cardSize = 0;
          while(cardSize<groupSize){
              if(!map.containsKey(setFirst+cardSize) || map.get(setFirst+cardSize)==0){
                  return false;
              }else
                  map.put(setFirst+cardSize,map.get(setFirst+cardSize)-1);

              if(map.get(setFirst+cardSize)==0)
                  q.poll();

              cardSize++;


          }

        }
        return true;
    }

    }


