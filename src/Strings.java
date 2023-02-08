import java.util.*;

public class Strings {


    public String removeOuterParentheses(String s) {
        char[] ar = s.toCharArray();

        StringBuilder str = new StringBuilder();

        int count = 0;
        for (char ch : ar) {

            if (ch == '(')
                count++;
            else
                count--;

            if ((count != 1 || ch != '(') && (count != 0 || ch != ')'))
                str.append(ch);


        }
        return str.toString();
    }

    //using stack
    public String removeOuterParentheses1(String s) {

        Stack<Character> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();


        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {

            if (stack.isEmpty()) {
                stack.push(arr[i]);
                list.add(i);
            } else if (arr[i] == ')' && stack.peek() == '(') {
                stack.pop();
                if (stack.isEmpty())
                    list.add(i);
            } else
                stack.push(arr[i]);
        }

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < list.size(); i += 2) {

            str.append(s.substring(list.get(i) + 1, list.get(i + 1)));

        }
        return str.toString();

    }

    public String reverseWords(String s) {

        List<String> listString = new ArrayList<>();

        StringBuilder str;

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            str = new StringBuilder();
            int k = i;
            while (k < arr.length && arr[k] != ' ') {
                str.append(arr[k++]);
            }
            if (!str.isEmpty())
                listString.add(str.toString());

            i = k;
        }
        Stack<String> stack = new Stack<>();
        int j = 0;
        while (j < listString.size()) {
            stack.push(listString.get(j++));
        }
        StringBuilder string = new StringBuilder();
        while (!stack.isEmpty()) {
            string.append(stack.pop() + " ");
        }

        string.deleteCharAt(string.length() - 1);

        return string.toString();
    }

    public String largestOddNumber(String num) {

        if (num.charAt(num.length() - 1) % 2 != 0)
            return num;

        if (num.length() > 3)
            if (num.charAt(num.length() - 1) == 0)
                return num;
            else if (num.charAt(num.length() - 1) % 2 != 0)
                return num;


        char[] srt = num.toCharArray();
        StringBuilder string = new StringBuilder();
        int max = 0;
        for (var ch : srt) {
            if (ch % 2 != 0 && ch > max)
                max = ch;
        }
        if ((char) max != 0)
            string.append((char) max);
        else
            return string.toString();

        return string.toString();
    }


    public String largestOddNumber1(String num) {

        if (num.charAt(num.length() - 1) % 2 != 0)
            return num;

        char[] arr = num.toCharArray();
        int oddpos = 0;
        for (int i = arr.length - 1; i >= 0; i--) {

            if (arr[i] % 2 != 0) {
                oddpos = i;
                break;
            }
        }

        StringBuilder string = new StringBuilder();
        if (oddpos != -1)
            string.append(num.substring(0, oddpos + 1));

        return string.toString();


    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int c = 0;
        while (c < first.length()) {
            if (first.charAt(c) == last.charAt(c))
                c++;
            else
                break;
        }
        return c == 0 ? "" : first.substring(0, c);
    }

    public boolean isIsomorphic1(String s, String t) {

        Map<Character, Integer> map1 = new LinkedHashMap<>();
        Map<Character, Integer> map2 = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map1.containsKey(s.charAt(i)))
                map1.put(s.charAt(i), map1.get(s.charAt(i)) + 1);
            else
                map1.put(s.charAt(i), 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (map2.containsKey(t.charAt(i)))
                map2.put(t.charAt(i), map2.get(t.charAt(i)) + 1);
            else
                map2.put(t.charAt(i), 1);
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();


        for (var val : map1.values()) {
            list1.add(val);
        }
        for (var val : map2.values()) {
            list2.add(val);
        }

        if (list1.size() != list2.size())
            return false;

        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i))
                return false;
        }

        return true;


    }

    public List<Integer> isIsomorphic(String s, String t) {

        List<Integer> list1 = new ArrayList<>();
//        List<Integer> list2 = new ArrayList<>();


        for (int i = 0; i < s.length() - 1; i++) {
            int times = 1;
            int j = i + 1;
            while (s.charAt(i) == s.charAt(j)) {
                j++;
                times++;
            }
            list1.add(times);
            i = j;
        }

        return list1;
    }

    public boolean isomeric(String s, String t) {

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char a = s.charAt(i);
            char b = t.charAt(i);

            if (map.containsKey(a))
                if (map.get(a).equals(b))
                    continue;
                else
                    return false;

            else if (!map.containsValue(b))
                map.put(a, b);
            else
                return false;
        }

        return true;

    }

    public boolean rotateString(String s, String goal) {

        if (s.length() != goal.length())
            return false;

        int firstposition = 0;

        int i = 0;
        for (int j = 0; j < s.length(); j++) {

            if (s.charAt(i) == goal.charAt(j))
                firstposition = j;
        }

        for (int k = 0; k < s.length(); k++) {

            if (s.charAt(k) != goal.charAt(firstposition % goal.length()))
                return false;
            firstposition++;

        }
        return true;
    }


    public boolean isAnagram(String s, String t) {

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        String A = "";
        String B = "";

        for (int i = 0; i < a.length; i++) {
            A += a[i];
            B += b[i];

        }

        return A.equals(B);


    }

    public boolean isAnagram1(String s, String t) {

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            if (map1.containsKey(s.charAt(i)))
                map1.put(s.charAt(i), map1.get(s.charAt(i)) + 1);
            else
                map1.put(s.charAt(i), 1);

        }
        for (int j = 0; j < t.length(); j++) {

            if (map2.containsKey(t.charAt(j)))
                map2.put(t.charAt(j), map2.get(t.charAt(j)) + 1);
            else
                map2.put(t.charAt(j), 1);
        }

        for (Character ch : map1.keySet()) {
            if (map2.containsKey(ch)) {
                if (map1.get(ch) != map2.get(ch))
                    return false;
            } else
                return false;
        }

        return true;

    }

    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else
                map.put(s.charAt(i), 1);
        }

        LinkedHashMap<Character, Integer> reverseSortedMap = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));


        String newString = "";

        for (var ch : reverseSortedMap.entrySet())
            for (int i = 0; i < ch.getValue(); i++)
                newString += ch.getKey();

        return newString;
    }

    int longparn(String s) {

        int longcount = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                longcount++;
            if (s.charAt(i) == ')')
                longcount--;

            ans = Math.max(ans, longcount);
        }
        return ans;

    }


    public int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                if ((s.charAt(i) == 'V' || s.charAt(i) == 'X') && s.charAt(i - 1) == 'I')
                    total += (map.get(s.charAt(i)) - 2 * (map.get(s.charAt(i - 1))));
                else if ((s.charAt(i) == 'L' || s.charAt(i) == 'C') && s.charAt(i - 1) == 'X')
                    total += (map.get(s.charAt(i)) - 2 * (map.get(s.charAt(i - 1))));
                else if ((s.charAt(i) == 'D' || s.charAt(i) == 'M') && s.charAt(i - 1) == 'C')
                    total += (map.get(s.charAt(i)) - 2 * (map.get(s.charAt(i - 1))));
                else
                    total += map.get(s.charAt(i));
            } else

                total += map.get(s.charAt(i));

        }
        return total;
    }


    public String longestPalindrome1(String s) {

        int fisrt = 0;
        int last = s.length() - 1;

        for (int i = 0; i <= s.length() / 2; i++) {
            int tempfisrt = fisrt;
            int templast = last;
            if (s.charAt(tempfisrt) == s.charAt(templast)) {
                tempfisrt++;
                templast--;
                continue;
            } else {

                fisrt++;
                last--;

            }


        }
        String ans = s.substring(fisrt, last);

        return ans;
    }


        public int beautySum (String s){
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                int[] freq = new int[26];
                for (int j = i; j < s.length(); j++) {
                    freq[s.charAt(j) - 'a']++;
                    res += helper(freq);
                }
            }
            return res;
        }

        public int helper(int[] arr){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 26; i++) {
                if (arr[i] == 0) {
                    continue;
                }
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);
            }
            return max - min;
        }


    public int myAtoi(String s) {
        int res = 0;

        for (int i =0;i<s.length();i++) {
             if(s.charAt(i) -  '0' >= 0 && s.charAt(i)- '0' <= 9) {
                 if (s.charAt(i) != '0') {
                     res = (res * 10) + (s.charAt(i) - '0');
                 } else {
                     continue;
                 }
             }
             else
                 break;
        }

        return res;
    }

    public int myAtoi1(String s) {

        String s1 = s.trim();

        if (s1.length()==0)
            return 0;

        long ans  =0;
        int sign =1;

        if(s1.charAt(0) == '-') {
            sign = -1;
        }

        int start = (s1.charAt(0) == '+' || s1.charAt(0)=='-') ? 1:0;

        s1 = s1.substring(start,s1.length());


        for(int i =0;i<s1.length();i++){
            if((s1.charAt(i) - '0' >= 0) && (s1.charAt(i) - '0' <= 9))
                ans = (ans * 10) + (s1.charAt(i) -'0');
            if(ans*sign < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            if (ans*sign > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(s1.charAt(i) == ' ' || !Character.isDigit(s1.charAt(i)))
                break;
        }

       return (int)ans*sign;
    }
}



