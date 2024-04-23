public class Tempy {
    public static int goodArray(int[] nums){
//        int minMoves = -1;
//        for(int i =0;i<nums.length;i++){
//            int x = i%2;
//            int y = nums[i]%2;
//            if(nums.length ==1){
//                return -1;
//            }
//            if(i%2==0&&nums[i]%2!=0){
//                for(int k =0;k<nums.length-1;k=k+2){
//                    int temp = nums[k];
//                    nums[k]=nums[k+1];
//                    nums[k]=temp;
//                }
//                minMoves++;
//            }
//        }
//        if(minMoves>=0){
//            return minMoves+1;
//        }else if(minMoves==-1){
//            return 0;
//        }else{
//            return -1;
//        }
        int even = 0;
        int odd = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]%2==0){
                even++;
            }else{
                odd++;
            }
        }
        if(nums[0]%2!=0 && nums.length==1 ||even-odd>1 || odd-even>1){
            return -1;
        }
        int minMoves = 0;
        for(int i =0;i<nums.length;i++){
            if(i%2!=nums[i]%2){
                minMoves++;
            }
        }
        return minMoves/2;
    }


    public static void main(String[] args) {
        int[] a = {3,2,6}; //3 2 6
        int result = goodArray(a);
        System.out.println(result);
    }
}
