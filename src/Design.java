import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Design {

    List<User> list = new ArrayList<>();

    public static void main(String args[]){
        Design d = new Design();
        d.list.add(d.new User("krishna","krishn@gmail.com","12345","M","11-02-2002"));
        d.list.add(d.new User("mohan","mohan@gmail.com","12345","M","11-02-2002"));
        d.list.add(d.new User("magesh","magesh@gmail.com","12345","M","11-02-2002"));
        d.list.add(d.new User("raj","raj@gmail.com","12345","M","11-02-2002"));

        d.login("krishn@gmail.com","12345");

    }


    public void login(String srt, String password){

        for(var list : list) {
            if (list.gmail.equals(srt) && list.password.equals(password)) {
                int n = 2;

                System.out.println("login successfully");
                while(n == 2) {
                    System.out.println("1.for view post");
                    System.out.println("2.for add post");

                    Scanner sc = new Scanner(System.in);
                    var op = sc.nextInt();
                    if (op == 1) {
                        viewPost(srt);
                    }
                    else if(op == 2){
                        var caption = sc.next();
                        var pic = sc.next();
                        addPost(caption, pic, srt);

                        System.out.println("you want to add post press or view 2");
                         var check = sc.nextInt();
                         n = check;

                    }
                }

                break;

            }
            else {
                System.out.println("invalide login");
                return;
            }
        }
    }
    public void addPost(String caption,String pic,String gmail){
        Design d = new Design();
        for (var list : list){
            if (list.gmail.equals(gmail)){
                list.getPost().add(new Design.Post(caption,pic));
            }
        }

    }

    public void viewPost(String gmail){
        for (var list : list){
            if (list.gmail.equals(gmail)){
                for (var list2 : list.getPost()){
                    System.out.println(list2.caption + " " +list2.pic);
                }
            }
        }


    }




    class User{

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGmail() {
            return gmail;
        }

        public void setGmail(String gmail) {
            this.gmail = gmail;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getDOB() {
            return DOB;
        }

        public void setDOB(String DOB) {
            this.DOB = DOB;
        }

        public User(String name, String gmail, String password, String gender, String DOB) {
            this.name = name;
            this.gmail = gmail;
            this.password = password;
            this.gender = gender;
            this.DOB = DOB;
        }


        private String name;
        private String gmail;
        private String password;
        private String gender;
        private String DOB;
        private List<Post> post = new ArrayList<>();

        public List<Post> getPost() {
            return post;
        }

        public void setPost(List<Post> post) {
            this.post = post;
        }



        }




static class Post{

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
    public Post(String caption, String pic) {
        this.caption = caption;
        this.pic = pic;
    }


    private String caption;
    private String pic;


}
}
