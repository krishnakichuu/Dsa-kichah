import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String args[]) {


        char[][] layout = {{' ', ' ', ' '},
                           {'=', '=', '='},
                           {' ', ' ', ' '},
                           {'=', '=', '='},
                           {' ', ' ', ' '}};

        for (int i = 0; i < 5; i++) {
            System.out.println(Arrays.toString(layout[i]));
        }


        char ch = 'X';

        while (true) {

            System.out.println("enter the place " + ch + " user");

            Scanner scan = new Scanner(System.in);
            int place = scan.nextInt();

            insertXO(place, layout, ch);

            for (int i = 0; i < 5; i++) {
                System.out.println(Arrays.toString(layout[i]));
            }

            if (checkGame(layout)) {
                return;
            }

            if (checkDraw(layout)) {
                System.out.println("match draw");
                return;
            }

            if (ch == 'X') {
                ch = 'O';
            } else {
                ch = 'X';
            }


        }

    }

    public static void insertXO(int place, char[][] layout, char ch) {

        if (place > 0 && place < 4) {
            int i = 0;
            for (int j = 0; j < 3; j++) {
                if (place == j + 1) {
                    layout[i][j] = ch;
                    return;
                }
            }

        } else if (place > 3 && place < 7) {
            int i = 2;
            for (int j = 0; j < 3; j++) {
                if (place == j + 4) {
                    layout[i][j] = ch;
                    return;
                }
            }

        } else if (place > 6 && place < 10) {
            int i = 4;
            for (int j = 0; j < 3; j++) {
                if (place == j + 7) {
                    layout[i][j] = ch;
                    return;
                }
            }

        } else {
            System.out.println("invalid place");
        }

    }

    public static boolean checkGame(char[][] layout) {

        char[] row;

        for (int i = 0; i < 5; i += 2) {
            row = new char[3];
            for (int j = 0; j < 3; j++) {
                row[j] = layout[i][j];
            }
            if (helpercheck(row)) {
                System.out.println(row[0] + " user win the game");
                return true;
            }
        }


        char[] col;
        for (int j = 0; j < 3; j++) {
            col = new char[3];
            int k = 0;
            for (int i = 0; i < 5; i += 2) {
                col[k++] = layout[i][j];
            }
            if (helpercheck(col)) {
                System.out.println(col[0] + " user win the game");
                return true;
            }
        }

        char[] crossR = new char[3];

        crossR[0] = layout[0][0];
        crossR[1] = layout[2][1];
        crossR[2] = layout[4][2];

        if (helpercheck(crossR)) {
            System.out.println(crossR[0] + " user win the game");
            return true;
        }

        char[] crossL = new char[3];

        crossL[0] = layout[0][2];
        crossL[1] = layout[2][1];
        crossL[2] = layout[4][0];

        if (helpercheck(crossL)) {
            System.out.println(crossL[0] + " user win the game");
            return true;
        }
        return false;
    }

    public static boolean helpercheck(char[] arrays) {

        if (arrays[0] == ' ')
            return false;

        char ch = arrays[0];

        for (int i = 1; i < 3; i++) {
            if (ch != arrays[i]) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkDraw(char[][] layout) {
        char ch = ' ';

        for (int i = 0; i < 5; i += 2) {
            for (int j = 0; j < 3; j++) {

                if (ch == layout[i][j]) {
                    return false;
                }
            }
        }


        return true;
    }


}
