import org.w3c.dom.html.HTMLHeadElement;
import org.w3c.dom.ls.LSInput;

import javax.naming.StringRefAddr;
import java.util.*;

public class ArraysClass {
    public void rotate(int[] nums, int k) {

        if (nums.length == 0)
            return;
        int k1 = k % nums.length;
        while (k1 != 0) {
            int i = 0;
            for (int j = 1; j < nums.length; j++) {
                if (k1 != 0) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
            k1--;
        }

    }

    public void alterRotated(int[] arr, int k) {
        if (arr.length == 0)
            return;

        if (k % arr.length == 0)
            return;


    }

    // move zero to last
    public int[] moveZero(int[] arr) {
        int[] newArray = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                newArray[j++] = arr[i];
            }
        }

        return newArray;
    }


    public void moverZeros(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
    }

    public int linearSearch(int[] arr, int target) {

        int targetIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                targetIndex = i;
        }
        return targetIndex;
    }

    static int searchInSorted(int arr[], int N, int K) {

        for (int i = 0; i < N; i++) {
            if (arr[i] == K)
                return 1;
        }
        return -1;

    }

    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {

        ArrayList<Integer> arrays = new ArrayList<>();
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (arr1[i] != arr2[j]) {
                if (arr1[i] > arr2[j]) {
                    arrays.add(arr2[j]);
                    arrays.add(arr1[i]);
                    j++;
                    i++;
                } else {
                    arrays.add(arr2[i]);
                    arrays.add(arr1[j]);
                    i++;
                    j++;
                }
            }
            i++;
            j++;
        }

        return arrays;

    }

    public int missingelement(int[] nums) {
        Arrays.sort(nums);
        int missingElement = 0;
        if (nums.length == 1)
            if (nums[0] == 1)
                return 0;
            else
                return 1;

        if (nums.length == 2)
            if (nums[0] == 0 && nums[1] == 1)
                return 2;
            else
                return 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != i)
                missingElement = i;
        }
        return missingElement;


    }

    public int missing(int[] arr, int N) {

        if (arr.length == 1 && arr[0] == 0)
            return 1;

        int[] newArray = new int[N + 1];
        for (int i = 0; i < arr.length; i++) {
            newArray[arr[i]] += 1;
        }
        for (int i = 1; i < newArray.length; i++) {
            if (newArray[i] == 0)
                return i;
        }
        return 0;
    }

    public int consecutiveOnes(int[] nums) {

        int[] array = new int[nums.length];

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)

                array[j]++;
            else
                j++;
        }
        Arrays.sort(array);
        return array[array.length - 1];


    }

    public int lengthOfArr(int[] arr, int k) {
        Arrays.sort(arr);
        int sum = 0;
        int subArrayTime = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum <= k) {
                sum += arr[i];
                subArrayTime++;
            }
        }

        return subArrayTime;

    }

    public int consecutiveArray(int[] A, int k) {
        int total = 0;
        int max = 0;
        int sum = 0;
        int maxsum = 0;
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum <= k) {
                max = Math.max(max, maxsum += 1);
            } else {
                i -= 2;
                maxsum = 0;
                sum = 0;
            }
        }

        for (var n : A) {
            total += n;
        }
        if (total < k)
            return 0;

        return max;

    }

    public int consecutivesubarrays(int[] arr, int k) {
        int start = 0;
        int end = -1;
        int sum = 0;
        int maxLength = 0;
        while (start < arr.length) {
            while ((end + 1 < arr.length) && (sum + arr[end + 1] <= k))
                sum += arr[++end];

            if (sum == k) {
                maxLength = Math.max(maxLength, end - start + 1);
            }
            sum -= arr[start];
            start++;

        }
        return maxLength;
    }

    public int singleNumber(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else {
                map.put(nums[i], 1);
            }
        }

        for (var entry : map.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();

        }
        return 0;
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                if (matrix[i][j] == target)
                    return true;

        return false;


    }

    public int rowWithMax1s(int arr[][], int n, int m) {

        int[] oneFrq = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1)
                    oneFrq[i]++;
            }
        }
        int min = oneFrq[0];
        for (int i = 0; i < oneFrq.length; i++) {
            if (min > oneFrq[i] && oneFrq[i] != 0)
                min = oneFrq[i];
        }
        for (int i = 0; i < oneFrq.length; i++) {
            if (min == oneFrq[i])
                return i + 1;
        }
        return 0;
    }


    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
        return result;
    }

    public int[] countArray(int[] arr) {
        int[] count = new int[3];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++)
                arr[k++] = i;
        }
        return arr;
    }

    public void majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (var arr : nums) {
            if (map.containsKey(arr))
                map.put(arr, map.get(arr) + 1);
            else
                map.put(arr, 1);
        }


    }

    public int maxSubArray(int[] nums) {
        int maxsum = Integer.MIN_VALUE;

        if (nums.length == 1)
            return nums[0];


        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = i; j < nums.length; j++) {
                max += nums[j];
                if (max > maxsum)
                    maxsum = max;
            }
        }
        return maxsum;

    }

    public int maxSubArrays(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum > max) max = sum;

            if (sum < 0) sum = 0;
        }

        return max;

    }

    public void subArrayFindK(int[] arr, int k) {

        for (int i = 0; i < arr.length; i++) {
            int sumK = 0;
            for (int j = i; j < arr.length; j++) {
                sumK += arr[j];
                if (sumK == k) {
                    for (int l = i; l <= j; l++)
                        System.out.print(arr[l] + " ");

                    System.out.println();
                }
            }
        }
    }

    public int maxProfit(int[] prices) {
        int count = 0;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++)
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] < prices[j]) {
                    maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
                    count++;
                }
            }
        if (count == 0)
            return 0;

        return maxProfit;
    }


    public int maxProfitt(int[] prices) {
        int maxpro = 0;
        int minShare = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minShare = Math.min(minShare, prices[i]);
            maxpro = Math.max(maxpro, prices[i] - minShare);
        }
        return maxpro;
    }

    public int[] rearrangeArray(int[] nums) {

        int[] positive = new int[nums.length / 2];
        int[] negative = new int[nums.length / 2];

        int p = 0;
        int n = 0;
        for (int num : nums) {
            if (num > 0)
                positive[p++] = num;
            else
                negative[n++] = num;
        }
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < positive.length && j < negative.length) {

            nums[k++] = positive[i++];
            nums[k++] = negative[j++];

        }
        return nums;
    }

    public void permutation(int[] nums) {
        if (nums == null && nums.length <= 1) return;

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;
        int j = nums.length - 1;
        if (i >= 0) {
            while (nums[j] < nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);


    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverse(int[] arr, int i, int j) {
        while (i < j)
            swap(arr, i++, j--);
    }


    public ArrayList<Integer> leaders(int arr[], int n) {
        ArrayList<Integer> array = new ArrayList<>();

        int i = 0;
        while (i < arr.length) {
            int j = i + 1;
            while (j < arr.length) {
                if (arr[i] < arr[j]) {
                    i++;
                    j = i + 1;
                } else
                    j++;
            }
            array.add(arr[i++]);
        }
        return array;
    }

    //Longest Consecutive Sequence

    public int longestConsecutive(int[] nums) {

        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;

        Arrays.sort(nums);

        int count = 1;
        int subcount = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] - 1)
                count = Math.max(count, subcount += 1);
            else if (nums[i] == nums[i + 1])
                count = Math.max(count, subcount);
            else
                subcount = 1;
        }

        return count;
    }

    //using hashset

    int longestConsecutive2(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (var num : arr) {
            set.add(num);
        }

        int longsub = 0;

        for (var nums : arr) {
            if (!set.contains(nums - 1)) {
                int current = nums;
                int currentsub = 1;

                while (set.contains(current + 1)) {
                    current += 1;
                    currentsub += 1;
                }

                longsub = Math.max(longsub, currentsub);
            }
        }
        return longsub;
    }

    public void setZeroes(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {

                    for (int k = 0; k < matrix[i].length; k++) {
                        if (matrix[i][k] != 0)
                            matrix[i][k] = -1;
                    }
                    for (int l = 0; l < matrix.length; l++) {
                        if (matrix[l][j] != 0)
                            matrix[l][j] = -1;
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == -1)
                    matrix[i][j] = 0;
            }
        }

    }

    public void setZeroes1(int[][] matrix) {

        int col0 = 1;
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0)
                col0 = 0;
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;

            }

            if (col0 == 0)
                matrix[i][0] = 0;

        }

    }


    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] newMatrix = new int[row][col];

        int l = -1;
        for (int i = matrix.length - 1; i >= 0; i--) {
            l++;
            int k = 0;
            for (int j = 0; j < matrix[i].length; j++) {

                newMatrix[k++][l] = matrix[i][j];
            }
        }

        for (int i = 0; i < newMatrix.length; i++)
            for (int j = 0; j < newMatrix[i].length; j++)
                matrix[i][j] = newMatrix[i][j];

    }


    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++) {
                list.add(matrix[i][j]);


                if (j == matrix[i].length - 1)
                    for (int k = i + 1; k < matrix.length; k++) {
                        list.add(matrix[k][j]);


                        if (k == j)
                            for (int l = j - 1; l >= 0; l--) {
                                list.add(matrix[k][l]);

                                if (l == 0)
                                    for (int h = i - 1; h > 0; h--) {
                                        list.add(matrix[h][k]);
                                    }

                            }
                    }

            }
        return list;
    }


    public List<Integer> spiralOrder1(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        int div = 0;

        while (left <= right && top <= bottom) {

            if (div == 0) {
                for (int i = left; i <= right; i++)
                    list.add(matrix[top][i]);
                top++;
            } else if (div == 1) {
                for (int i = top; i <= bottom; i++)
                    list.add(matrix[i][right]);
                right--;
            } else if (div == 2) {

                for (int i = right; i >= left; i--)
                    list.add(matrix[bottom][i]);
                bottom--;
            } else if (div == 3) {
                for (int i = bottom; i >= top; i--)
                    list.add(matrix[i][left]);
                left++;
            }

            div = (div + 1) % 4;
        }
        return list;

    }


    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> row, pre = null;

        for (int i = 0; i < numRows; i++) {
            row = new ArrayList<>();

            for (int j = 0; j <= i; j++)
                if (j == 0 || j == i)
                    row.add(1);
                else
                    row.add(pre.get(j - 1) + pre.get(j));


            pre = row;
            list.add(row);

        }


        return list;
    }

    public List<Integer> majorityElement(int[] nums) {

        int times = nums.length / 3;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (var arr : nums) {
            if (map.containsKey(arr))
                map.put(arr, map.get(arr) + 1);
            else
                map.put(arr, 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > times)
                list.add(entry.getKey());
        }
        return list;
    }

    // three sum in duplicate
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> oneseq;

        for (int i = 0; i < nums.length - 2; i++)
            for (int j = i + 1; j < nums.length - 1; j++)
                for (int k = j + 1; k < nums.length; k++)
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        oneseq = new ArrayList<>();
                        oneseq.add(nums[i]);
                        oneseq.add(nums[j]);
                        oneseq.add(nums[k]);

                        set.add(oneseq);
                    }
        for (var numss : set)
            result.add(numss);

        return result;
    }

    public List<List<Integer>> threeSum1(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (var ar : nums)
            if (map.containsKey(ar))
                map.put(ar, map.get(ar) + 1);
            else
                map.put(ar, 1);

        return result;
    }

    public List<List<Integer>> threeSum11(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {

                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[low]);
                        list.add(nums[high]);
                        result.add(list);

                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;

                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < sum) low++;

                    else
                        high--;
                }
                ;
            }

        }
        return result;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        List<Integer> oneseq;

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    for (int l = k + 1; l < nums.length; l++) {

                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            oneseq = new ArrayList<>();
                            oneseq.add(nums[i]);
                            oneseq.add(nums[j]);
                            oneseq.add(nums[k]);
                            oneseq.add(nums[l]);

                            set.add(oneseq);
                        }
                    }
                }
            }
        }

        for (var numss : set) {

            list.add(numss);
        }
        return list;
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {


        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        List<Integer> oneSeq;

        for (int i = 0; i < nums.length - 2; i++)
            for (int j = i + 1; j < nums.length - 1; j++)
                for (int k = j + 1; k < nums.length; k++)
                    if (binaryearch(nums, k + 1, nums.length - 1, target - (nums[i] + nums[j] + nums[k]))) {
                        oneSeq = new ArrayList<>();
                        oneSeq.add(nums[i]);
                        oneSeq.add(nums[j]);
                        oneSeq.add(nums[k]);
                        oneSeq.add(target - (nums[i] + nums[j] + nums[k]));

                        set.add(oneSeq);
                    }

        for (var numss : set)
            list.add(numss);

        return list;
    }

    public boolean binaryearch(int[] arr, int start, int end, int target) {


        if (start <= end) {
            int mid = (start + end) / 2;


            if (arr[mid] == target) return true;

            if (arr[mid] > target)
                return binaryearch(arr, start, mid - 1, target);

            return binaryearch(arr, mid + 1, end, target);

        }

        return false;

    }

    public List<List<Integer>> fourSum22(int[] nums, int target) {


        List<List<Integer>> res = new ArrayList<>();

        if (nums == null && nums.length == 0)
            return res;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double target_2 = target - nums[j] - nums[i];
                int front = j + 1;
                int back = n - 1;

                while (back > front) {

                    double twoSum = nums[front] + nums[back];

                    if (twoSum < target_2) front++;

                    else if (twoSum > target_2) back--;

                    else {

                        List<Integer> set = new ArrayList<>();
                        set.add(nums[i]);
                        set.add(nums[j]);
                        set.add(nums[front]);
                        set.add(nums[back]);

                        res.add(set);

                        while (front < back && nums[front] == set.get(2)) ++front;

                        while (front < back && nums[back] == set.get(3)) --back;


                    }

                }
                while (j + 1 < n && nums[j + 1] == nums[j]) j++;


            }
            while (i + 1 < n && nums[i + 1] == nums[i]) i++;
        }
        return res;
    }


    public int longsubArray(int[] arr) {

        int maxSeq = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if (sum == 0)
                    maxSeq = Math.max(maxSeq, j - i + 1);
            }

        }
        return maxSeq;

    }

    public int longsubArray1(int[] arr) {

        int max = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];
            if (sum == 0) {
                max = i + 1;
            } else {

                if (map.containsKey(sum)) {
                    max = Math.max(max, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }
        return max;
    }

    public List<List<Integer>> merge(int[][] intervals) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l;
        for (int i = 0; i < intervals.length; i++)
            for (int j = 0; j < intervals[i].length - 1; j++)
                if (!list.isEmpty()) {
                    if (list.get(list.size() - 1).get(1) > intervals[i][j] &&
                            list.get(list.size() - 1).get(0) < intervals[i][j + 1]) {
                        l = new ArrayList<>();
                        l.add(list.get(list.size() - 1).get(0));
                        l.add(intervals[i][j + 1]);
                        list.remove(list.size() - 1);
                        list.add(l);
                    } else {
                        l = new ArrayList<>();
                        l.add(intervals[i][j]);
                        l.add(intervals[i][j + 1]);
                        list.add(l);
                    }
                } else {
                    l = new ArrayList<>();
                    l.add(intervals[i][j]);
                    l.add(intervals[i][j + 1]);
                    list.add(l);

                }

        return list;

    }

    public void merge11(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[j++];
        }
        Arrays.sort(nums1);

    }


    public int reversePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > (double) nums[j] * 2)
                    count++;
            }
        }
        return count;
    }

    public int maxProduct(int[] nums) {

        int maxProduct = 0;
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                maxProduct = Math.max(maxProduct, product);
            }


        }
        return maxProduct;
    }


    int findFloor(long arr[], int n, long x) {
        return findFloor2(arr, 0, n - 1, x);
    }

    private int findFloor2(long[] arr, int start, int last, long x) {

        int mid = (start + last) / 2;
        if (start <= last) {
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return findFloor2(arr, start, mid - 1, x);
            return findFloor2(arr, mid + 1, last, x);
        }

        return mid - 1;
    }

    int findFloor22(long arr[], int n, long x) {

        int start = 0;
        int end = n - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;

            if (arr[mid] == x)
                return mid;

            else if (arr[mid] > x)
                end = mid - 1;
            else
                start = mid + 1;

        }
        if (start > end)
            return mid - 1;

        return mid;
    }

    public int searchRange(int[] arr, int target) {

        int res = -1;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                res = mid;
            }
            if (arr[mid] >= target) {
                if (arr[mid] == target)
                    start = mid + 1;
                else
                    end = mid - 1;
            } else
                start = mid + 1;

        }
        int first = res;
        for (int i = res; i > 0; i--) {
            if (arr[i] == target)
                first = i;
        }

        return (res - first) + 1;
    }

    int count(int[] arr, int n, int x) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x)
                count++;
        }

        return count;

    }

    public int findPeakElement(int[] nums) {

        int peak = Integer.MIN_VALUE;

        for(int i =0;i<nums.length;i++){
           peak = Math.max(nums[i],peak);
        }
        int left = 0;
        int mid = nums.length/2;
        int right = nums.length-1;
        while(left<=mid){
            if (nums[left] == peak)
                return left;
            left++;
        }
        while (right>mid) {
            if (nums[right] == peak)
                return right;
            right--;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int first = 0;
        int last = nums.length-1;
        int mid = (first+last)/2;

        while(first<=mid){
            if(nums[first] == target)
                return first;
            first++;
        }
        while(last>mid){
            if(nums[last] == target)
                return last;

            last--;
        }

        return -1;
    }

    public int search2(int[] nums,int target){

        int left = 0;
        int right= nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;

            if(nums[mid] == target)
                return mid;

            if(nums[left] <= nums[mid]){
                if(nums[left]<=target && target <= nums[mid])
                    right =mid-1;
                else
                    left = mid+1;
            }
            else
                if(nums[mid] <= target && target<=nums[right])
                    left = mid+1;

                else
                    right = mid-1;
        }

        return -1;

        }

    public boolean search1(int[] nums, int target) {

        int start = 0;
        int end = nums.length-1;
        while(start<=end){

            int mid = (start+end)/2;

            if(nums[mid] == target)
                return true;

            if(nums[start] <= nums[mid])
                if(nums[start]<=target && target<=nums[mid])
                    end =mid-1;
                else
                    start = mid+1;

            else
                if (nums[mid] <= target && target <= nums[end])
                        start =mid+1;

                else
                    end = mid -1;

        }
        return false;


    }

    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length-1;

        int min = Integer.MAX_VALUE;

        while(left<=right){

            if(nums[left] <= nums[right]){
                min = nums[left];
                break;
            }
            int mid = (left/right)/2;
            if(nums[left]<=nums[mid]){
                min =  nums[left];
                left = mid+1;
            }else {
                min = nums[mid];
                right = mid-1;
            }
        }

      return min;
    }

    int findKElement(int[] arr1,int[] arr2,int k){
        int[] newarray = new int[arr1.length+arr2.length];
        int i=0,j=0,l=0;

        while (i<arr1.length&&j<arr2.length){

            if(arr1[i] <= arr2[j]){
                newarray[l++] = arr1[i++];
            }
            else
                newarray[l++] = arr2[j++];
        }
        while(i<arr1.length)
            newarray[l++] = arr1[i++];

        while(j<arr2.length)
            newarray[l++] = arr2[j++];

        return newarray[k-1];
    }

    boolean matrixSerach(int[][] matrix,int target){
        int start = 0;
        int end = matrix.length-1;


        while(start<=end){

            int left =0;
            int right = matrix[start].length-1;

            while(left<=right){

                int mid = (left+right)/2;

                if(matrix[start][mid] == target)
                       return true;

                if(matrix[start][mid] > target)
                    right = mid-1;
                else
                    left = mid+1;
            }
            start++;
        }

        return false;
    }

     public boolean matrixSearch2(int[][] matrix , int target){

        int start = 0;
        int end = (matrix.length * matrix[0].length) -1;

        while (start<= end){

            int mid = (start+end)/2;
            int mid1 = mid / matrix[0].length;
            int mid2 = mid % matrix[0].length;

            if(matrix[mid1][mid2] == target)
                return true;

            if(matrix[mid1][mid2] < target){
                start = mid+1;
            }else
                end = mid-1;
        }

        return false;

     }

    public int[] findPeakGrid(int[][] mat) {

        int start = 0;
        int end  = mat.length-1;

        while(end>=start){

            int mid = (start+end)/2;
            int max = Integer.MIN_VALUE;
            int maxnoinRow = 0;

            for (int i = 0; i < mat[mid].length; i++) {
                if(mat[mid][i] > max) {
                    max = mat[mid][i];
                    maxnoinRow = i;
                }
            }

            if(mid == 0){
                if(mat[mid][maxnoinRow] >= mat[mid+1][maxnoinRow])
                    return new int[]{mid,maxnoinRow};
            }

           else if(mid == mat.length-1){
                if(mat[mid][maxnoinRow]>=mat[mid-1][maxnoinRow])
                    return new int[]{mid,maxnoinRow};
            }
            else if (mat[mid][maxnoinRow] >= mat[mid-1][maxnoinRow] && mat[mid][maxnoinRow]>=mat[mid+1][maxnoinRow])
                return new int[]{mid,maxnoinRow};

          if(mid == mat.length-1 || mid != 0)
            if(mat[mid][maxnoinRow] < mat[mid-1][maxnoinRow])
                end = mid-1;
            else
                start = mid+1;

            else

                if(mat[mid][maxnoinRow] < mat[mid+1][maxnoinRow])
                    start = mid+1;

                else
                    end = mid -1;

        }
        return new int[]{-1,-1};

    }

}






