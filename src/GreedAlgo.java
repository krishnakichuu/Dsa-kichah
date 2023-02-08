import java.util.*;

public class GreedAlgo {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);
        int cookiesCount = 0;
        int j = 0;
        for (int i = 0; j < g.length && i < s.length; i++, j++) {
            if (s[i] >= g[j]) {
                cookiesCount++;
            }
        }                                           // 25
        return cookiesCount;
    }                                                                    // [5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5]

    public boolean lemonadeChange(int[] bills) {

        int[] change = new int[3];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                change[0]++;
            } else if (bills[i] == 10) {
                change[1]++;
            } else {
                change[2]++;
            }
            if (bills[i] == 10) {
                if (change[0] == 0)
                    return false;
                else
                    change[0]--;
            }                                                                        // [5,5,10,10,20]
            else if (bills[i] == 20) {
                if (change[0] <= 2 && change[1] == 0)
                    return false;
                if (change[0] == 0)
                    return false;

                else if (change[1] == 0) {
                    change[0] -= 3;
                } else {
                    change[0]--;
                    change[1]--;
                }
            }


        }

        return true;

    }

    public boolean checkValidString(String s) {// (*))
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                open.push(i);
            else if (s.charAt(i) == '*')
                star.push(i);                                //( * )
            else if (s.charAt(i) == ')') {
                if (!open.isEmpty())
                    open.pop();
                else if (!star.isEmpty())
                    star.pop();
                else
                    return false;
            }
        }

        if (open.isEmpty())
            return true;                                   // 3
        //  0 1 2
        //  "(((((()*)(*)*))())())(()())())))((**)))))(()())()"
        while (!open.isEmpty()) {

            if (star.isEmpty())
                return false;

            else if (open.peek() > star.peek())
                return false;

            else if (open.peek() < star.peek()) {
                open.pop();
                star.pop();
            }
        }

        return true;
    }

    public boolean canJump(int[] nums) {

        int rechageable = 0;

        for (int i = 0; i < nums.length; i++) {
            if (rechageable < i)
                return false;

            rechageable = Math.max(rechageable, nums[i] + i);
        }

        return false;


    }

    public int jump1(int[] nums) {


        int rechaable = nums[0];
        int minJump = 0;

        for (int i = 0; i < nums.length; i++) {

            if (rechaable >= nums.length - 1)
                break;

            if (rechaable < nums[i] + i) {

                rechaable = nums[i] + i;
                minJump++;
            }
        }
        return minJump;
    }

    public int jump2(int[] nums) {

        int res = 0;
        int left = 0, right = 0;

        while (right < nums.length - 1) {
            int faster = 0;
            for (int i = left; i <= right; i++) {
                faster = Math.max(faster, nums[i] + i);
            }
            left = right;
            right = faster;
            res++;
        }
        return res;

    }

    public int candy(int[] ratings) {

        int[] leftTo = new int[ratings.length];
        int[] rightTo = new int[ratings.length];

        for (int i = 0; i < ratings.length; i++) {
            leftTo[i] = 1;
            rightTo[i] = 1;
        }

        for (int j = 0; j < ratings.length; j++) {
            if (j != 0 && ratings[j] > ratings[j - 1])
                leftTo[j] += leftTo[j - 1];
        }
        for (int k = ratings.length - 1; k >= 0; k--) {
            if (k != ratings.length - 1 && ratings[k] > ratings[k + 1])
                rightTo[k] += rightTo[k + 1];
        }

        int ans = 0;
        for (int m = 0; m < ratings.length; m++) {
            ans += Math.max(leftTo[m], rightTo[m]);
        }

        return ans;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        if(intervals.length == 0){
            int[][] ans = new int[1][2];
            ans[0][0] = newInterval[0];
            ans[0][1] = newInterval[1];
            return ans;
        }

        int[][] newans = new int[intervals.length][];
        if (newInterval[1] < intervals[0][0]) {
            newans = new int[intervals.length + 1][2];
            newans[0][0] = newInterval[0];
            newans[0][1] = newInterval[1];
            for (int i = 1; i <= intervals.length; i++) {
                newans[i][0] = intervals[i - 1][0];
                newans[i][1] = intervals[i - 1][1];
            }

        } else if (intervals[intervals.length - 1][1] < newInterval[0]) {
            newans = new int[intervals.length + 1][2];
            newans[newans.length - 1][0] = newInterval[0];
            newans[newans.length - 1][1] = newInterval[1];
            for (int j = 0; j < intervals.length; j++) {
                newans[j][0] = intervals[j][0];
                newans[j][1] = intervals[j][1];
            }

        } else {
            newans = new int[intervals.length + 1][2];
            int satisfied = 1;
            int fromWhat = 0;
            for (int k = 0; k < intervals.length; k++) {
                if (newInterval[0] > intervals[k][1] && newInterval[1] < intervals[k + 1][0]) {
                    newans[k][0] = intervals[k][0];
                    newans[k][1] = intervals[k][1];
                    newans[k + 1][0] = newInterval[0];
                    newans[k + 1][1] = newInterval[1];
                    fromWhat = k + 2;
                    satisfied = 0;
                    break;

                } else {
                    newans[k][0] = intervals[k][0];
                    newans[k][1] = intervals[k][1];
                }
            }

            if (satisfied == 0) {
                for (int l = fromWhat; l < newans.length; l++) {
                    newans[l][0] = intervals[l - 1][0];
                    newans[l][1] = intervals[l - 1][1];
                }
            } else {

                var refnew = newInterval;

                List<List<Integer>> ans = new ArrayList<>();
                for (int i = 0; i < intervals.length; i++) {
                    if (intervals[i][1] < refnew[0]) {
                        List<Integer> newlist = new ArrayList<>();
                        newlist.add(intervals[i][0]);
                        newlist.add(intervals[i][1]);
                        ans.add(newlist);
                    } else if (refnew[1] < intervals[i][0]) {
                        List<Integer> newlist = new ArrayList<>();
                        newlist.add(refnew[0]);
                        newlist.add(refnew[1]);
                        ans.add(newlist);
                        newlist = new ArrayList<>();
                        newlist.add(intervals[i][0]);
                        newlist.add(intervals[i][1]);
                        ans.add(newlist);
                    } else {
                        refnew[0] = Math.min(intervals[i][0], refnew[0]);
                        refnew[1] = Math.max(intervals[i][1], refnew[1]);
                    }

                }

                newans = new int[ans.size()][2];
                int i = 0;
                for (var integer : ans){
                    newans[i][0] = integer.get(0);
                    newans[i][1] = integer.get(1);
                    i++;
                }

                return newans;
            }

        }
        return newans;
    }
}
