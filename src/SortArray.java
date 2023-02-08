public class SortArray {

    public int[] plusOne(int[] digits) {
        int lastVal = digits[digits.length-1] + 1;

        digits[digits.length-1] = lastVal;

        if(digits[digits.length -1] + 1 == 10 ){
            int lastVal1 = digits[digits.length-1] + 1;

            int val1 = lastVal1 / 10;
            int val2 = lastVal1 % 10;
            int i = 2;
            while(digits[digits.length-i] + 1 == 10) {
                int val3 = digits[digits.length - i] / 10;
                int val4 = digits[digits.length - i] % 10;


            }

        }

        return digits;
    }
}
