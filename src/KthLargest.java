import java.util.PriorityQueue;
import java.util.Queue;

class KthLargest {

    Queue<Integer> q = new PriorityQueue<>();
    int takes;


    public KthLargest(int k, int[] nums) {
        this.takes = k;

    for (var num : nums){
        q.add(num);
    }
    int times = (q.size()>=k) ? q.size()-k:0;

    int count = 0;
    while(times != count){
        q.poll();
        count++;
    }

    }

    public int add(int val) {
        if(q.size() >= takes) {
            q.add(val);
            q.poll();
            return q.peek();
        }
        q.add(val);
        return q.peek();
    }
}