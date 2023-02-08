import java.util.Stack;

public class Palidrome {

    public String checkPalidrome(String s){
       return (s.equals(reverseString(s)))? "is palidrome" : "not palidrome";
    }
    public static String reverseString(String s){
        String newString = "";
        Stack<Character> stack = new Stack<>();
        for (var ch : s.toCharArray())
            stack.push(ch);
        while(!stack.empty()){
            newString += stack.pop();
        }
        return newString;
    }

}
