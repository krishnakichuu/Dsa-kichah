public class DoubleLinkedListt {

    private class Node{


        private int val;
        private Node prev;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

    }

    private Node fisrt;
    private Node last;


    public void insertlast(int val){
        var node =  new Node(val);

        if (fisrt == null)
            fisrt = last = node;
        else{
            last.next = node;
            node.prev = last;
            last =  node;
        }
    }

    public void insertfisrt(int val){
        var node = new Node(val);
        if(fisrt == null)
            fisrt = last = node;
        else{
            node.next = fisrt;
            fisrt.prev =node;
            fisrt = node;
        }
    }

    public void insertpos(int val,int pos){
        var node = new Node(val);
        int count = 0;
        var cur = fisrt;
        while(count < pos){
            cur = cur.next;
            count++;
        }

        if(cur.next == null){
            cur.next = node;
            node.prev = cur;
        }
        node.next = cur.next;           // first declare the node next and prev then declare exits node prev and next...
        node.prev = cur;
        cur.next = node;
        node.next.prev = node;
    }

    public void deletepos(int pos){
          int count = 1;
          var cur = fisrt;

          while(count < pos-1){
              cur = cur.next;
              count++;
          }
          if(cur.next.next == null){
             cur.next= null;
          }
          else {
              cur.next = cur.next.next;
              cur.next.prev = cur;
          }
    }

  public void reverse(){

        var cur = last;
        Node temp = null;

        while (cur != null){
            temp = cur.next;
            cur.next = cur.prev;
            cur.prev = temp;
            cur = cur.next;
        }

        Node temp1 = last;
        last = fisrt;
        fisrt = temp1;
  }
    public void middleNode() {
        var cur = fisrt;
        int count = 0;
        while (cur != null){
            cur = cur.next;
            count++;
        }

        int mid = (count/2) +1;

        var cur1 = fisrt;


    }


    public void display() {
        Node  temp = fisrt;
        while (temp != null) {
            System.out.print(temp.val+"<->");
            temp = temp . next;
        }
        System.out.println("NULL");
    }




}
