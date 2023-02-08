import java.util.*;


class Pair{
    int row;
    int col;
    int tm;

    public Pair(int row, int col, int tm) {
        this.row = row;
        this.col = col;
        this.tm = tm;
    }
}

public class NewStack {

    Stack<Integer> prices = new Stack<>();
    Stack<Integer> ind = new Stack<>();
    int index;

    public NewStack() {
        index = -1;
    }


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] newArray = new int[nums1.length];
        int l = 0;

        for (int i = 0; i < nums1.length; i++) {
            int val = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                if (val == nums2[j]) {
                    for (int k = j + 1; k < nums2.length; k++) {
                        if (nums2[j] < nums2[k]) {
                            newArray[l++] = nums2[k];
                            break;
                        }
                    }
                    break;
                }
            }
            l++;

        }

        for (int i = 0; i < newArray.length; i++) {

            if (newArray[i] == 0)
                newArray[i] = -1;

        }
        return newArray;

    }


    public int[] nextGreaterElements1(int[] nums) {
        int n = nums.length;


        int[] newArray = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {                                            // [1,5,7,9,2,5,7,4]    5,7,9,-1,5,7,-1,-1;

            while (!stack.isEmpty() && stack.peek() <= nums[i % n])
                stack.pop();

            if (i < n)
                if (!stack.isEmpty())
                    newArray[i] = stack.peek();
                else
                    newArray[i] = -1;


            stack.push(nums[i % n]);
        }


        return newArray;

    }

    public int trap(int[] height) {
        int count = 0;                                      // 5,7,8,9,4,5,2
        int i = 0;
        int k = 1;
        int j = 0;

        while (i < height.length) {
            if (height[i] > height[k]) {
                k++;
                if (k == height.length) {
                    i++;
                    k = i;
                    continue;
                }
                continue;
            } else if (height[i] < height[k]) {
                i++;
                k++;
                continue;
            }

            for (int l = i + 1; l < k; l++) {
                count += height[i] - height[l];
            }
            if (k == height.length - 1)
                break;
            else if (height[k] <= height[k + 1]) {
                i = k + 1;
                k = i + 1;
            } else {
                i = k;
                k = k + 1;
            }
        }
        return count;
    }

    public int trap1(int[] height) {
        int count = 0;

        int[] prefix = new int[height.length];
        int[] suffix = new int[height.length];

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, height[i]);
            prefix[i] = max;
        }
        max = Integer.MIN_VALUE;

        for (int i = height.length - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            suffix[i] = max;
        }

        for (int i = 0; i < height.length; i++) {
            count += (Math.min(prefix[i], suffix[i])) - height[i];
        }
        return count;
    }

    public int sumSubarrayMins1(int[] arr) {
        int total = 0;
        int min;
        for (int i = 0; i < arr.length; i++) {
            min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                total += min;
            }
        }
        return total;
    }

    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        long total = 0;
        int n = arr.length;
        int[] nextsmall = new int[n];
        int[] presmall = new int[n];

        for (int i = 0; i < arr.length; i++) {
            nextsmall[i] = n - i - 1;
            presmall[i] = i;
        }
        for (int i = 0; i < arr.length; i++) {

            while (!s1.isEmpty() && arr[s1.peek()] > arr[i]) {
                nextsmall[s1.peek()] = i - s1.peek() - 1;
                s1.pop();
            }
            s1.push(i);

        }

        for (int i = n - 1; i >= 0; i--) {

            while (!s2.isEmpty() && arr[s2.peek()] >= arr[i]) {
                presmall[s2.peek()] = s2.peek() - i - 1;
                s2.pop();
            }
            s2.push(i);

        }
        int MOD = 1000000007;
        for (int i = 0; i < n; i++) {
            total += (arr[i] * (presmall[i] + 1) * (nextsmall[i] + 1));
            total %= MOD;
        }
        return (int) total;
    }

    public int next(int price) {

        index++;

        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            ind.pop();
        }
        if (prices.isEmpty()) {
            prices.push(price);
            ind.push(index);

            return index + 1;
        }
        int ans = ind.peek();
        prices.push(price);
        ind.push(index);

        return ind.peek() - ans;
    }

    public int[] asteroidCollision(int[] asteroids) {


        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {

            while (!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0 && stack.peek() < (asteroids[i] * -1)) {
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0 && stack.peek() >= (asteroids[i] * -1))
                if (stack.peek() == (asteroids[i] * -1)) {
                    stack.pop();
                    continue;
                } else
                    continue;

            stack.push(asteroids[i]);
        }

        if (stack.size() == 0)
            return new int[]{};

        int[] ans = new int[stack.size()];

        for (int i = ans.length - 1; i >= 0; i--) {

            ans[i] = stack.pop();

        }
        return ans;
    }

    public long subArrayRanges(int[] nums) {
        long total = 0;

        for (int i = 0; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = i; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);

                total += (max - min);
            }
        }
        return total;
    }

    public long subArrayRanges1(int[] arr) {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s11 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s22 = new Stack<>();

        int small = 0;
        int large = 0;

        long total = 0;
        int n = arr.length;
        int[] nextsmall = new int[n];
        int[] presmall = new int[n];
        int[] nextlarge = new int[n];
        int[] prelarge = new int[n];

        for (int i = 0; i < arr.length; i++) {
            nextsmall[i] = n - i - 1;
            nextlarge[i] = n - i - 1;
            prelarge[i] = i;
            presmall[i] = i;
        }
        for (int i = 0; i < arr.length; i++) {

            while (!s1.isEmpty() && arr[s1.peek()] > arr[i]) {
                nextsmall[s1.peek()] = i - s1.peek() - 1;
                s1.pop();
            }
            s1.push(i);
            while (!s11.isEmpty() && arr[s11.peek()] < arr[i]) {
                nextlarge[s11.peek()] = i - s11.peek() - 1;
                s11.pop();
            }
            s11.push(i);
        }

        for (int i = n - 1; i >= 0; i--) {

            while (!s2.isEmpty() && arr[s2.peek()] >= arr[i]) {
                presmall[s2.peek()] = s2.peek() - i - 1;
                s2.pop();
            }
            s2.push(i);
            while (!s22.isEmpty() && arr[s22.peek()] <= arr[i]) {
                prelarge[s22.peek()] = s22.peek() - i - 1;
                s22.pop();
            }
            s22.push(i);

        }

        for (int i = 0; i < arr.length; i++) {
            large += (arr[i] * (prelarge[i] + 1) * (nextlarge[i] + 1));
        }

        for (int i = 0; i < n; i++) {
            small += (arr[i] * (presmall[i] + 1) * (nextsmall[i] + 1));

        }

        total = large - small;

        return total;


    }

    public int largestRectangleArea(int[] heights) {

        int maxrectangle = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int minval = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                minval = Math.min(minval, heights[j]);
                maxrectangle = Math.max(maxrectangle, (minval * (j + 1 - i)));
            }

        }
        return maxrectangle;
    }

    public int largestRectangleArea1(int[] heights) {

        int[] leftsmall = new int[heights.length];
        int[] rightsmall = new int[heights.length];

        Stack<Integer> s1 = new Stack<>();

        for (int i = 0; i < heights.length; i++) {

            while (!s1.isEmpty() && heights[s1.peek()] >= heights[i]) {
                s1.pop();
            }
            if (s1.isEmpty()) {
                leftsmall[i] = 0;
                s1.push(i);
            } else {
                leftsmall[i] = s1.peek() + 1;
                s1.push(i);
            }
        }
        s1.clear();

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!s1.isEmpty() && heights[s1.peek()] >= heights[i]) {
                s1.pop();
            }
            if (s1.isEmpty()) {
                rightsmall[i] = heights.length - 1;
                s1.push(i);
            } else {
                rightsmall[i] = s1.peek() - 1;
                s1.push(i);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, heights[i] * (rightsmall[i] - leftsmall[i] + 1));
        }
        return max;
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];


        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = nums[i];
            for (int j = 0; j < k; j++) {                 //3,3,5,5,6,7
                max = Math.max(max, nums[i + j]);
            }
            ans[i] = max;
        }
        return ans;
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int countfresh = 0;
        Queue<Pair> queue = new LinkedList<>();
        int[][] vis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }else
                    vis[i][j] = 0;

                if (grid[i][j] == 1)
                    countfresh++;
            }
        }
        int tm = 0;
        int cnt = 0;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int r = queue.peek().row;
            int c = queue.peek().col;
            int t = queue.peek().tm;
            tm = Math.max(tm,t);
            queue.remove();

            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] != 2 && grid[nrow][ncol] == 1) {
                    queue.add(new Pair(nrow, ncol, t + 1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }
            }

        }
        if (cnt != countfresh)
            return -1;
       return tm;
    }
}


