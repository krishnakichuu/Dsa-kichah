import java.lang.reflect.Array;
import java.util.*;

public class MedianFinder {

    Queue<Integer> maxHeap ;
    Queue<Integer> minHeap ;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>();
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num){
        maxHeap.add(-1*num);

           if (maxHeap.size() > minHeap.size()+1) {                          //  2 3 7 4    maxheap = [2 ]      minheap = [3 ]
               int insertVal = maxHeap.poll();
               minHeap.add(-1 * insertVal);
           }
        if(minHeap.size() != 0) {

           if (maxHeap.peek() * -1 > minHeap.peek()){
               int insertVal = maxHeap.poll();
               minHeap.add(-1 * insertVal);
           }

           if(minHeap.size()>maxHeap.size()+1){
               int insertVal = minHeap.poll();
               maxHeap.add(-1 * insertVal);
           }
        }
    }

    public double findMedian(){

        if(minHeap.size() == maxHeap.size()){
            int total = minHeap.peek() + (maxHeap.peek() * -1);
            return (double)total/2;
        }
        else if(minHeap.size()>maxHeap.size()){
            return minHeap.peek();
        }
        else
            return maxHeap.peek()*-1;

    }

    public int[] topKFrequent(int[] nums, int k) {

       Map<Integer,Integer> map = new HashMap<>();
       Queue<Integer> queue = new PriorityQueue<>();
        int[] array = new int[k];

       for (var val : nums){
           map.put(val,1+map.getOrDefault(val,0));
       }

       for(var mapval : map.values()){
           queue.add(-1*mapval);
       }
       for(int i = 0;i<array.length;i++){
           int mapvalu = -1*queue.poll();
           for(var mapi : map.entrySet()){
               if(mapi.getValue() == mapvalu){
                   array[i] = mapi.getKey();
                   map.remove(mapi.getKey());
                   break;
               }
           }
       }
       return array;

    }



}
