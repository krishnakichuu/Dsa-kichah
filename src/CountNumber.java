public class CountNumber {
    int count(int N){
        int count = 0;
        int newN = N;
        while(newN!=0){

            if(N%(newN%10) == 0) {

                count++;
            }
            newN = newN/ 10;
        }
        return count;
    }
}
