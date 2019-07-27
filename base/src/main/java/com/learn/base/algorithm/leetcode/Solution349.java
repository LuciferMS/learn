package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: learn
 * @description: Solution349
 * @author: Elliot
 * @create: 2019-07-24 21:31
 **/
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int temp1 = nums1[0];
        int temp2 = nums2[0];
        int i = 0;
        int j = 0;
        List<Integer> mark = new ArrayList<>();
        while(i < nums1.length && j < nums2.length){
            if(temp1 > temp2){
                j++;
            }else if(temp1 < temp2){
                i++;
            }else{
                mark.add(temp1);
            }
        }
        int[] result = new int[mark.size()];
        for (int k = 0; k < mark.size(); k++) {
            result[k] = mark.get(k);
        }
        return result;
    }
}
