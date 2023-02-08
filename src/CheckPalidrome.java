public class CheckPalidrome {
    public boolean isPalindrome(int x) {
        if(x>=0) {
            int newX = x;
            int reverse = 0;
            while (newX != 0) {
                reverse = reverse * 10 + newX % 10;
                newX /= 10;
            }
            return (reverse == x) ? true : false;
        }
        else
            return false;
    }
}
