public class Customer {

    public Customer(String name, int mobNo, String date) {
        this.name = name;
        this.mobNo = mobNo;
        this.date = date;
    }

    String name;
    int mobNo;
    String date;


    ABCstore store = new ABCstore();

    public void byitem(String item,int q){

        for (var items :store.list){

            if(items.item.equals(item)){

            }
        }

    }




}
