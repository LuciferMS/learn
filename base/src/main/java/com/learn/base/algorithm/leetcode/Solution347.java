package algorithm.leetcode;

import java.util.*;

/**
 * @program: learn
 * @description: Solution347 topk元素
 * @author: Elliot
 * @create: 2019-07-20 17:14
 **/
public class Solution347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(16);
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((n1, n2)->map.get(n1) - map.get(n2));
        List<Integer> result = new ArrayList<>();
        for(int num : nums){
            if (map.containsKey(num)) {
                int value = map.get(num);
                map.put(num, value + 1);
            }else{
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            queue.add(entry.getKey());
            if (queue.size() > k){
                queue.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            result.add(queue.poll());
        }
        Collections.reverse(result);
        return result;
    }
}
