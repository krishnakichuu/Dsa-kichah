public class CustomerDetial{

    static int Id = 1;

    public CustomerDetial(String name,String preferRoom){
        this.name = name;
        this.preferRoom = preferRoom;
        this.customerId = Id++;
        this.roomLocated = "";
    }

    String name;
    String preferRoom;
    int customerId;
    String roomLocated;


}
