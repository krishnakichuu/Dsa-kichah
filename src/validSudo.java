import java.util.HashSet;
import java.util.Set;

public class validSudo {
    public boolean isValid(String [][] sudo){
        Set<String> set = new HashSet<>();
        for (int i =0; i<sudo.length; i++ ){
            for (int j = 0; j < sudo.length; j++) {
                if (sudo[i][j] != ".") {
                    if (!set.add(sudo[i][j] + "found row" + i) ||
                            !set.add(sudo[i][j] + "found col" + j) ||
                            !set.add(sudo[i][j] + "found cub" + i / 3 + "-" + j / 3))
                        return false;
                }
            }

        }
        return true;
    }

}
