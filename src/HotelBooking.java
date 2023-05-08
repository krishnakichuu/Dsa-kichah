import java.util.*;



public class HotelBooking {

    static int acRoomAvailable = 2;
    static int normalRoomAvailable = 2;

    static List<CustomerDetial> customerDetials = new ArrayList<>();

    public static void main(String args[]){

      boolean run = true;
        while (run) {

            Scanner scan = new Scanner(System.in);
            System.out.println("1.Room book \n2.show rooms available \n3.cancel room\n4.allcustomer detail \n5.exit");
            int option = scan.nextInt();

            if (option == 1){
                System.out.println("Enter customer name : ");
                String customername = scan.next();
                System.out.println("Enter the preference room : AC or nonAc");
                String preference = scan.next();
                bookRoom(customername,preference);
            }
            else if(option == 2){
                System.out.println("--------room available----------");
                showNumber();
            }
            else if (option == 3){
                System.out.println("Enter customer id :");
                Scanner s = new Scanner(System.in);
                int id = s.nextInt();
                cancelBooking(id);
            }
            else if(option == 4){
                System.out.print("all customer detail");
                viewBookedDetail();
            }
            else if (option == 5){
                run = false;
            }

        }



    }

    public static void showNumber(){
        System.out.println("AC room "+acRoomAvailable+ " available");
        System.out.println("NON AC room "+normalRoomAvailable+ " available");

    }

    public static void bookRoom(String name,String roomPre){

        if(acRoomAvailable>0 || normalRoomAvailable>0){
           if (roomPre.equals("AC")){
               if (acRoomAvailable>0){
                   var customer =  new CustomerDetial(name,roomPre);
                   customer.roomLocated = "AC room";
                   customerDetials.add(customer);
                   acRoomAvailable--;
               }else
                   System.out.println("--------------Ac room not available");
           }else if(roomPre.equals("nonAc")){
               if (normalRoomAvailable>0){
                 var customer =  new CustomerDetial(name,roomPre);
                 customer.roomLocated="Non AC room";
                   customerDetials.add(customer);
                   normalRoomAvailable--;
               }else
                   System.out.println("-------------nonAc room not available");
           }
        }
        else if (roomPre.equals("nonAc")){
            System.out.println("---------------nonAC room not available");
        }else
            System.out.println("---------------AC room not available");

    }

    public static void viewBookedDetail() {
        System.out.println("-------Booked ticket detial--------");

        System.out.println("----AC room booked for----");
        if (acRoomAvailable == 2) {
            System.out.println("*******there is no customer*****");
        } else {
            for (var cus : customerDetials) {
                if (cus.preferRoom.equals("AC")) {
                    System.out.println("Customer ID = " + cus.customerId + " ||  " + "customer name = "
                            + cus.name + " || " + "room Allocted = " + cus.roomLocated + " || " +
                            "Customer preference = " + cus.preferRoom);
                }
            }
        }

        System.out.println("-------NON AC room booked detials--------");
        if (normalRoomAvailable == 2) {
            System.out.println("**********there is no customer********");
        } else{
            for (var cus : customerDetials) {
                if (cus.preferRoom.equals("nonAc")) {
                    System.out.println("Customer ID = " + cus.customerId + " || " + "customer name = "
                            + cus.name + " || " + "room Allocted = " + cus.roomLocated + " ||  " +
                            "Customer preference = " + cus.preferRoom);
                }
            }
    }

    }
     public static void cancelBooking(int cusId){
        int i = 0;
        for(var cus : customerDetials){
            var temp = cus;
           if (cus.customerId == cusId){
               customerDetials.remove(i);
               if (temp.preferRoom.equals("AC")){
                   acRoomAvailable++;
               }else if (temp.preferRoom.equals("nonAc")){
                   normalRoomAvailable++;
               }
               break;
           }
           i++;
        }

     }
}
