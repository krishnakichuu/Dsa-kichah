import java.util.*;

public class SundayContext {


    public int alternateDigitSum(int n) {
        int mainAns = 0;
        Stack<Integer> stack = new Stack<>();
        int temp = n;
        while (temp != 0) {
            int take = temp;
            int put = take % 10;
            stack.add(put);
            temp /= 10;
        }
        boolean plus = true;

        while (!stack.isEmpty()) {
            if (plus == true) {
                mainAns += stack.pop();
                plus = false;
            } else {
                mainAns -= stack.pop();
                plus = true;
            }
        }

        return mainAns;
    }

    public int[][] sortTheStudents(int[][] score, int k) {
        int[] decnum = new int[score.length];
        int[] roword = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            decnum[i] = score[i][k];
            roword[i] = i;
        }

        for (int j = 0; j < decnum.length; j++) {
            for (int l = j + 1; l < decnum.length; l++) {
                if (decnum[j] < decnum[l]) {
                    int temp = decnum[j];
                    decnum[j] = decnum[l];
                    decnum[l] = temp;

                    int temp2 = roword[j];
                    roword[j] = roword[l];
                    roword[l] = temp2;
                }
            }

        }

        int[][] mat = new int[score.length][score[0].length];

        for (int m = 0; m < roword.length; m++) {
            for (int n = 0; n < score[0].length; n++) {
                mat[m][n] = score[roword[m]][n];

            }
        }
        return mat;

    }

    public int distinctIntegers(int n) {
        Set<Integer> visitedNum = new HashSet<>();
        int ans = 1;
        int x = n;
        while (x != 0) {
            for (int i = 1; i <= x; i++) {
                if (x % i == 1 && !visitedNum.contains(i)) {
                    ans++;
                    visitedNum.add(i);
                }
            }
            x--;
        }
        return ans;
    }

}
