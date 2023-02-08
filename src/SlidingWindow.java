import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SlidingWindow {

    public int lengthOfLongestSubstring(String s) {

        int max = Integer.MIN_VALUE;
        Set<Character> map;
        for (int i = 0; i < s.length(); i++) {
            map = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (map.isEmpty()) {
                    map.add(s.charAt(j));
                } else {
                    if (map.contains(s.charAt(j))) {
                        break;
                    } else {
                        map.add(s.charAt(j));
                        max = Math.max(max, map.size());
                    }
                }
            }
        }
        if (max == Integer.MIN_VALUE)
            return 1;
        return max;
    }

    public int longestOnes(int[] nums, int k) {

        int maxOnes = Integer.MIN_VALUE;
        int stratwindow = 0;
        int count = k;
        for (int endwid = 0; endwid < nums.length; endwid++){
            if(nums[endwid] == 1 || count > 0) {
                maxOnes = Math.max(maxOnes, (endwid - stratwindow) + 1);
                if (nums[endwid] == 0)
                    count--;
            } else {
                while (count == 0) {
                    if (nums[stratwindow] == 0) {
                        count++;
                        stratwindow++;
                    } else {
                        stratwindow++;
                    }
                }
                if (nums[endwid] == 0)
                    count--;
            }
        }
        return maxOnes;
    }
    public int characterReplacement(String s, int k) {

        Map<Character, Integer> map = new HashMap<>();
        int startwindow = 0;
        int res = 0;
        int maxfreq = 0;

        for (int endwindow = 0; endwindow < s.length(); endwindow++) {
            if (map.containsKey(s.charAt(endwindow))) {
                map.put(s.charAt(endwindow), map.get(s.charAt(endwindow)) + 1);
            } else
                map.put(s.charAt(endwindow), 1);

            int max = 0;
            for (var entry : map.entrySet()) {
                max = Math.max(max, entry.getValue());
            }

            while(endwindow - startwindow +1 - max > k){
                map.put(s.charAt(startwindow),map.get(s.charAt(startwindow)) -1);
                startwindow++;
            }

            res = Math.max(res,endwindow-startwindow+1);
        }

return res;

    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum =0;
        int subtotal;

        for (int i =0;i<nums.length;i++){
            subtotal = 0;
            for (int j =i;j<nums.length;j++){
                subtotal+=nums[j];
                if(subtotal == goal)
                    sum++;
            }
        }
        return sum;

    }

    public int numSubarraysWithSum1(int[] nums, int goal) {

        int total =0;
        int sum = 0;
        int prefixsum;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        for (int i =0;i<nums.length;i++){
            sum += nums[i];
            prefixsum = sum - goal;
            if(map.containsKey(prefixsum)){
                total+=map.get(prefixsum);
            }
            if(map.containsKey(sum)){
                map.put(sum,map.get(sum)+1);
            }
            else
                map.put(sum,1);
        }

        return total;

    }

    public int numberOfSubarrays(int[] nums, int k) {

      int total = 0;
      int count;
      for(int i =0;i<nums.length;i++){
          count =0;
          for (int j =i;j<nums.length;j++){
              if(nums[i] %2 != 0)
                  count++;

              if(count == k)
                  total++;
          }
      }
      return total;
    }

    public int numberOfSubarrays1(int[] nums, int k) {
        //1,1,2,1,1
        int i = 0;
        int j = 0;
        int oddCount = 0;
        int count = 0;
        int temp = 0;

        while (j < nums.length) {
            if (nums[j] % 2 == 1) {
                oddCount++;
                temp = 0;
            }
            while (oddCount == k) {
                temp++;
                if (nums[i] % 2 == 1) {
                    oddCount--;
                }
                i++;
            }
            count += temp;
            j++;
        }
        return count;
    }
    public int numberOfSubstrings(String s) {
      int total = 0;
      Map<Character,Integer> map;
      for (int i =0;i<s.length();i++){
          map = new HashMap<>();
          map.put('a',0);
          map.put('b',0);
          map.put('c',0);
          for(int j  = i ; j<s.length();j++){
              map.put(s.charAt(j),map.get(s.charAt(j))+1);

              if(map.get('a') >= 1 && map.get('b') >= 1 && map.get('c') >= 1 ){
                  total++;
              }


          }
      }

        return total;

    }

    public int numberOfSubstrings1(String s) {

        int count[] = {0, 0, 0}, res = 0 , i = 0, n = s.length();
        for (int j = 0; j < n; ++j) {
            ++count[s.charAt(j) - 'a'];
            while (count[0] > 0 && count[1] > 0 && count[2] > 0)
                --count[s.charAt(i++) - 'a'];
            res += i;
        }
        return res;

    }


    public int maxScore(int[] cardPoints, int k) {
        int i =0;
        int max = Integer.MIN_VALUE;
        while(i<k+1){
            int sum = 0;
            int j =0;
            while(j<i+1){
                if(i == k)
                    break;
                sum += cardPoints[j++];
            }


            int e = cardPoints.length-1;
            int m = (i == k) ? k : k - j;
            while(e>=cardPoints.length-m){
                if(i == k-1)
                    break;
                sum+= cardPoints[e--];
            }
            i++;
             max = Math.max(max , sum);
        }

        return max;
    }

    public int maxScore1(int[] cardPoints, int k) {
        int l = 0;
        int r = cardPoints.length-k;

        int total =0;
        for(int i = r;i<cardPoints.length;i++){
            total+=cardPoints[i];
        }

        int res = total;

        while (r<cardPoints.length){
            total += cardPoints[l++] - cardPoints[r++];
            res = Math.max(res,total);
        }

return res;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {

        int res =0;
        Set<Integer> set;
        for(int i =0;i<nums.length;i++){
            set = new HashSet<>();
            for(int j = i;j<nums.length;j++){
                if(set.size()<=k){
                    set.add(nums[i]);
                }
                if (set.size() == k)
                    res++;
            }
        }
        return res;

    }
    public int subarraysWithKDistinct1(int[] nums, int k) {

        int count = 0;
        int left =0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int right =0;right<nums.length;right++){
          if(map.containsKey(nums[right]))
              map.put(nums[right],map.get(nums[right])+1);
          else
              map.put(nums[right],1);

          while(map.size()>k){
              map.put(nums[left],map.get(nums[left])-1);
              if(map.get(nums[left]) == 0)
                  map.remove(nums[left]);
              left++;
          }


          count += (right-left)+1;
        }

        int count1 = count;

        int m = k-1;
        count = 0;
        left =0;
        map = new HashMap<>();

        for (int right = 0;right<nums.length;right++){
            if(map.containsKey(nums[right]))
                map.put(nums[right],map.get(nums[right])+1);
            else
                map.put(nums[right],1);


            while(map.size()>m){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left]) == 0)
                    map.remove(nums[left]);
                left++;
            }
            count += (right-left)+1;
        }

      return count1 - count;

    }

    public String minWindow(String s, String t) {


        int start=0;
        int end =0;

      Map<Character,Integer> map = new HashMap<>();

      for (var ch : s.toCharArray()){
            if (map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else {
                map.put(ch,1);
            }
        }
         var maps = map;

        map = new HashMap<>();

      for (var ch : t.toCharArray()){
          if (map.containsKey(ch)){
              map.put(ch,map.get(ch)+1);
          }else {
              map.put(ch,1);
          }
      }
       var mapt = map;

      for (var map1 : mapt.entrySet()){
          if(maps.containsKey(map1.getKey()) && map1.getValue()<=maps.get(map1.getKey()))
              continue;
          else
              return "";
      }
      int min = Integer.MAX_VALUE;

      for (int i =0;i<s.length();i++){
          var tempmap = find(t);
          for (int j =i;j<s.length();j++){

              if(tempmap.containsKey(s.charAt(j))) {
                  tempmap.put(s.charAt(j), tempmap.get(s.charAt(j)) - 1);
                  if (tempmap.get(s.charAt(j)) == 0)
                      tempmap.remove(s.charAt(j));
              }

              if(tempmap.isEmpty()){
                 int temp  = j-i+1;
                 tempmap = find(t);
                 if(min > temp){
                     min = temp;
                     start = i;
                     end = j;
                 }
              }

          }
      }

      return s.substring(start,end+1);

    }

    private Map<Character,Integer> find(String t){
        Map<Character,Integer> map = new HashMap<>();
        for (var ch : t.toCharArray()){
            if (map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else {
                map.put(ch,1);
            }
        }
        return map;
    }

    public String minWindow1(String s, String t) {

        if(t=="")
            return "";

        Map<Character,Integer> countT =new HashMap<>();
        Map<Character,Integer> window =new HashMap<>();

        for(int i =0;i<t.length();i++){
            if (countT.containsKey(t.charAt(i)))
                countT.put(t.charAt(i),countT.get(t.charAt(i))+1);
            else
                countT.put(t.charAt(i),1);
        }

        int have =0;
        int need = countT.size();

        int[] res = {-1,-1};
        int reslength = Integer.MAX_VALUE;

        int l = 0;
        for(int r =0;r<s.length();r++){

            if(window.containsKey(s.charAt(r)))
                window.put(s.charAt(r),window.get(s.charAt(r))+1);
            else
                window.put(s.charAt(r),1);

            if(countT.containsKey(s.charAt(r)) && window.get(s.charAt(r)) == countT.get(s.charAt(r)))
                have++;

            while(have == need){

                if(r-l+1 < reslength){
                    reslength = r -l +1;
                    res[0] = l;
                    res[1]  =r;
                }

                window.put(s.charAt(l),window.get(s.charAt(l))-1);
                if(countT.containsKey(s.charAt(l)) && window.get(s.charAt(l)) < countT.get(s.charAt(l))){
                    have--;

                }
                l++;


            }
        }

        if(reslength != Integer.MAX_VALUE)
            return s.substring(res[0],res[1]+1);
        else
            return "";
    }

    }

