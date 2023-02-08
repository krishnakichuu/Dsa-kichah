public class StringPalidrom {
    public boolean isPalidrome(String s) {

        String newstring = "";
        for (var ch : s.toLowerCase().toCharArray()) {
            if (ch == ',' || ch == ' ' || ch == ':')
                continue;
            newstring += ch;
        }
        if (s.equals(reverseString(s,0)))
            return true;

        return false;


    }

    public String reverseString(String s,int i) {

        if(i == s.length())
            return null;


        reverseString(s,i+1);
        String string = "";
        string += s.charAt(i);
      return s;
    }
}

