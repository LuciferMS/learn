package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: learn
 * @description: Solution17 电话号码组合
 * @author: Elliot
 * @create: 2019-07-27 00:44
 **/
public class Solution17 {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if(digits != null && digits.length() != 0){
            HashMap<Character, String> map = new HashMap<Character, String>();
            map.put('1', "!@#");
            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");
            List<String> mark = new ArrayList();
            for(char c : digits.toCharArray()){
                mark.add(map.get(c));
            }
            String[] ss = mark.get(0).split("");
            for(String s1 : ss){
                result.add(s1);
            }
            for(int i = 1; i < mark.size(); i++){
                ss =  mark.get(i).split("");
                int size = result.size();
                for(int j = 0; j < size; j++){
                    String s = result.pollFirst();
                    for(String s1 : ss){
                        result.add(s + s1);
                    }
                }
            }
        }
        return result;
    }
}
