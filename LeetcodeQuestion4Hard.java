public class LeetcodeQuestion4Hard {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = nums1.length -1;
        int j = nums2.length -1;
        int k = nums1.length + nums2.length -1;
        double median = 0;
        int[] temp = new int[nums1.length + nums2.length];
        for(int a = 0 ; a<nums1.length;a++){
            temp[a]=nums1[a];
        }
        while(i>=0 && j>=0){
            if(nums1[i]< nums2[j]){
                temp[k--]=nums2[j--];
            }else{
                temp[k--]=nums1[i--];
            }
        }
        while(j>=0){
            temp[k--]=nums2[j--];
        }
        if(temp.length%2!=0){
            median = temp[temp.length/2];
            return median;
        }else{
            median = (double) (temp[temp.length / 2] + temp[(temp.length / 2) - 1]) /2;
            return median;
        }

    }
    public static void main(String[] args) {
        int[]a = {1,2};
        int[]b = {3,4};
        double result = findMedianSortedArrays(a,b);
        System.out.println(result);
    }
}
