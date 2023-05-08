import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ZohoInvoice {

    static List<Customer> customers = new ArrayList<>();
    static List<InVoice> inVoice = new ArrayList<>();


    public static void main(String args[]) {

        ZohoInvoice z =new ZohoInvoice();


        customers.add(z.new Customer("krishna",123));
        customers.add(z.new Customer("raj",124));
        customers.add(z.new Customer("kumar",125));

        List<Items> itemsList = new ArrayList<>();
        itemsList.add(z.new Items("bottle",10,"packet",5));
        itemsList.add(z.new Items("pen",50,"kg",4));
        itemsList.add(z.new Items("maavu",60,"kg",3));
        itemsList.add(z.new Items("kadala maadu",70,"kg",9));

        inVoice.add(z.new InVoice(0,itemsList,"krishna",123));


        itemsList = new ArrayList<>();
        itemsList.add(z.new Items("maggi",10,"packet",5));
        itemsList.add(z.new Items("rice",50,"kg",4));
        itemsList.add(z.new Items("wheat",60,"kg",3));
        itemsList.add(z.new Items("salt",70,"kg",9));

        inVoice.add(z.new InVoice(1,itemsList,"krishna",123));


        itemsList = new ArrayList<>();

        itemsList.add(z.new Items("parupu",45,"kg",3));
        itemsList.add(z.new Items("Aachi masala",10,"kg",4));
        itemsList.add(z.new Items("coco",60,"kg",2));
        itemsList.add(z.new Items("jum",10,"kg",4));

        inVoice.add(z.new InVoice(2,itemsList,"raj",124));


        itemsList = new ArrayList<>();

        itemsList.add(z.new Items("maida",35,"kg",1));
        itemsList.add(z.new Items("rice",50,"kg",3));
        itemsList.add(z.new Items("coco",60,"kg",1));
        itemsList.add(z.new Items("bru",10,"kg",2));

        inVoice.add(z.new InVoice(3,itemsList,"krishna",123));

        z.printInvoiceOf(1);
        z.totalofPurchase(123);






    }


    public void totalofPurchase(int cusId){
       int total = 0;

        for (var cus : customers){
            if (cus.Id == cusId){
                System.out.println("Customer name : "+cus.name+" ");
                break;

            }
        }

        for(var invoice : inVoice){
            if (invoice.cusId == cusId){
              for (var item : invoice.list){
                  System.out.println(item.getItem() + " " + item.getPrePrice() +
                          " "+item.getU()+" "+ item.getQuantity()+" "+item.getPrePrice()*item.getQuantity());
                  total += item.getPrePrice() * item.getQuantity();
              }
          }

        }
        System.out.println("total purchase"+ " " +total);

    }

    public void printInvoiceOf(int id){
        int total = 0;
        for (var invoice : inVoice){
            if (id == invoice.id){
                System.out.println("customer name :" + invoice.getName());

                for (Items item : invoice.list){
                    System.out.println(item.getItem()+" "+item.getPrePrice()+" "+
                            item.getU()+" "+item.getQuantity()+" "+item.getPrePrice() * item.getQuantity());
                    int itemPrice =  item.getPrePrice() * item.getQuantity();
                    total += itemPrice;
                }

                System.out.println(total);
                System.out.println("tax : " + 18+"%");
                System.out.println(total+ (total/18));

                break;
            }

        }


    }


    public class Customer {

        private String name;
        private int Id;



        public Customer(String name,int id) {
            this.name = name;
            Id = id;

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }


    }

    public class InVoice {

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCusId() {
            return cusId;
        }

        public void setCusId(int cusId) {
            this.cusId = cusId;
        }

        private String name;
        private int cusId;
        private int id;
        private List<Items> list;


        public InVoice(int id, List<Items> list,String name,int cusId) {
            this.id = id;
            this.list = list;
            this.cusId = cusId;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<Items> getList() {
            return list;
        }

        public void setList(List<Items> list) {
            this.list = list;
        }

    }

    public class Items {

        public Items(String item, int prePrice, String u, int quantity){
            this.item = item;
            this.prePrice = prePrice;
            this.u = u;
            this.quantity = quantity;
        }

        private String item;
        private int prePrice;
        private String u;
        private int quantity;

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public int getPrePrice() {
            return prePrice;
        }

        public void setPrePrice(int prePrice) {
            this.prePrice = prePrice;
        }

        public String getU() {
            return u;
        }

        public void setU(String u) {
            this.u = u;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }


    }


}
