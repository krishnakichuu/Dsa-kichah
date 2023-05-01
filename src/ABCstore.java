import java.util.ArrayList;
import java.util.List;

public class ABCstore {

    static int string = 0;

    class ListofObjete{

        public ListofObjete(String item, int rate, String u) {
            this.item = item;
            this.rate = rate;
            this.u = u;
        }

        String item;
        int rate;
        String u;


    }

    List<ABCstore.ListofObjete> list = new ArrayList<>() ;

    public void addItem( List<ABCstore.ListofObjete> list){

        list.add(new ListofObjete("maggi",10,"packet"));
        list.add(new ListofObjete("rice",50,"kg"));
        list.add(new ListofObjete("wheat",60,"kg"));
        list.add(new ListofObjete("coco",100,"kg"));
        list.add(new ListofObjete("ink",20,"ml"));

    }












}
