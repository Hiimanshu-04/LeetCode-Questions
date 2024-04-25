import java.util.HashMap;

public class LeetcodeQuestion41Hard {
    public static int firstMissingPositive(int[] nums) {
//        int j = 1;
//        for(int i = 0; i<nums.length;i++){
//            if(nums[i]==j){
//                j++;
//            }
//        }
//        return j;


//        int i =  0 ;
//        int j = nums.length-1;
//        int k =1;
//        while(i<=nums.length/2){
//            if(nums[i]==k || nums[j]==k){
//                k++;
//                if(nums[i]<=nums[j]){
//                    i++;
//                }else{
//                    j--;
//                }
//            }else if(nums[i]<=nums[j]){
//                i++;
//            }else{
//                j--;
//            }
//        }
//        return k;

//        int max = 1;
//        HashMap<Integer, Boolean> map = new HashMap<>();
//        for(int i : nums){
//            map.put(i,true);
//            if(i>max){
//                max=i;
//            }
//        }
//        for(int i =1;i<max;i++){
//            if(!map.containsKey(i)){
//                return i;
//            }
//        }
//        return max+1;

        boolean[] seen = new boolean[nums.length+1];
        for(int i : nums){
            if(i>0&&i<nums.length){
                seen[i]=true;
            }
        }
        for(int i =1;i<nums.length;i++){
            if(!seen[i]){
                return i;
            }
        }
        return nums.length+1;

    }
    public static void main(String[] args) {
        int[]a = {1,2,6,3,5};
        int result = firstMissingPositive(a);
        System.out.println(result);
    }
}
