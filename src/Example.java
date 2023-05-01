public class Example {
    public static void main(String args[]){
        String originalstrng="hello!";
        String reversestrng="";
        for(int i=0;i<originalstrng.length();i++){
            reversestrng=originalstrng.charAt(i)+reversestrng;
        }
        System.out.println(reversestrng);
    }
}
