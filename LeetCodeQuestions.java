import java.util.*;

public class LeetCodeQuestions {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int[digits.length + 1];
        newNumber[0] = 1;
        return newNumber;
    }
    public static int maxArea(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int maxArea = 0;
        while (low < high) {
            int h = Math.min(height[low], height[high]);
            int d = high - low;
            int area = h * d;
            maxArea = Math.max(maxArea, area);
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return maxArea;
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();
        for (int i =0 ; i< nums.length - 2; i++){
            if(i>0 && nums[i] == nums[i-1]){ // try rewriting it as nums[i] == nums[i+1]
                continue;
            }
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k] == 0){
                    ls.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(j<k && nums[j]==nums[j+1])j++;
                    while(j<k && nums[k]==nums[k-1])k--;
                     j++;
                     k--;
                }else if(nums[i]+nums[j]+nums[k] < 0){
                    j++;
                }else k--;

            }
        }
        return ls;
    }
    public static void minAndMax(int a, int b, int c) {
        int max = 0;
        int min = 0;
        if(a > b){
            if(a>c){
                max = a;
            }else{
                max=c;
            }
        }else if(b>c){
            if(b>a){
                max=b;
            }else{
                max=a;
            }
        }else{
            max=c;
        }
        // min
        if(a < b){
            if(a<c){
                min = a;
            }else{
                min=c;
            }
        }else if(b<c){
            if(b<a){
                min=b;
            }else{
                min=a;
            }
        }else{
            min=c;
        }
        System.out.println(min +" "+ max);
    }
    public static int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int firstOccurence = -1;
        int lastOccurence = -1;
        //first occurence
        while(low<=high) {
            int mid = low + (high - low) / 2;
            if(nums[mid]==target){
                if(mid == 0 || nums[mid-1]!=target ){
                    firstOccurence= mid;
                    break;
                }else high = mid -1;
            }else if(nums[mid]<target){
                low = mid+1;
            }else{
                high = mid -1;
            }
        }
        // last occurence
         low = 0;
         high = nums.length-1;
        while(low<= high){
            int mid = low +(high-low)/2;
            if(nums[mid]==target){
                if(mid == nums.length-1 || nums[mid+1] != target){
                    lastOccurence=mid;
                    break;
                }else low = mid + 1;
            }else if(nums[mid]<target){
                low = mid+1;
            }else{
                high = mid -1;
            }
        }

        return new int[]{firstOccurence,lastOccurence};
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0 ;
        int k = nums.length-1;
        int j = i+1;
        int closestSum = nums[0]+nums[1]+nums[2];
        for ( i =0 ; i< nums.length - 2; i++){
            j = i+1;
            k = nums.length-1;
            while(j<k){
                int currentSum = nums[i]+nums[j]+nums[k];
                if(Math.abs(currentSum-target) < Math.abs(closestSum-target)){
                    closestSum = currentSum;
                }
                if(currentSum < target){
                    j++;
                }else if(currentSum > target)
                    k--;
                else return currentSum;
            }
        }
        return closestSum;
    }

    public static int search(int[] nums, int target) {
        if(nums == null || nums.length==0){
            return -1;
        }
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[low] <= nums[mid]){
                if(nums[low]<=target && target < nums[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                if(nums[mid]<target && target <= nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while(i>=0 && j>=0) {
            if(nums1[i]>nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }
        while(j>=0){
            nums1[k--] = nums2[j--];
        }
    }

    public static int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        int candidate = nums[0];
//        int count = 0;
//        for(int i : nums){
//            if(candidate==i){
//                count++;
//                if(count>nums.length/2){
//                    return i;
//                }
//            }else{
//                candidate = i;
//                count = 1;
//            }
//        }
//        return -1;
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        int result = majorityElement(nums);
        System.out.println(result);
    }
}