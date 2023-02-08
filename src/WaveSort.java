import java.util.ArrayList;
import java.util.Collections;

public class WaveSort {

        public ArrayList<Integer> wave(ArrayList<Integer> A) {
            Collections.sort(A);

            for(int i =1 ; i<A.size() ; i+=2){
                Collections.swap(A,i,i-1);
            }
            return A;
        }
    }


