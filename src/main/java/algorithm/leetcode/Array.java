package algorithm.leetcode;

public class Array {

    //我做的，利用抑或运算...
    public static int singleNumber(int[] nums) {
        int len = nums.length;
        int result = 0;
        for(int i = 0; i < len; i++){
            int res = nums[i];
            for(int j = 0; j < len; j++){
                if(j == i){
                    continue;
                }
                int test = res ^ nums[j];
                if(test == 0){
                    res = 0;
                    break;
                }
            }
            if(res != 0){
                result = nums[i];
                break;
            }
        }
        return result;
    }

    //leetcode上看的。。一个数异或相同的两个数，得到的是原来得数。
    public static int singleNums(int[] data){
      int len = data.length;
      int result = 0;
      for(int i : data){
          result ^= i;
      }
      return result;
    }


}
