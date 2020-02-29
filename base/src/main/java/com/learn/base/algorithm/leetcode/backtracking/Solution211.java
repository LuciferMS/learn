package com.learn.base.algorithm.leetcode.backtracking;

/**
 * @program: learn
 * @description: 单词添加与搜索
 * @author: Elliot
 * @create: 2020-02-29 19:11
 **/
public class Solution211 {

    static class Node {
        boolean flag;
        Node[] nodes = new Node[27];
    }

    private Node node;

    public Solution211() {
        node = new Node();
    }

    public void addWord(String word) {
        if(word == null || word.length() == 0) return;
        int len = word.length();
        Node temp = node;
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if(temp.nodes[c - 'a'] == null) temp.nodes[c - 'a'] = new Node();
            temp = temp.nodes[c - 'a'];
        }
        temp.flag = true;
    }

    public boolean search(String word) {
        return searchHelper(word, node);
    }

    private boolean searchHelper(String word, Node node){
        if(word == null || word.length() == 0) return true;
        int len = word.length();
        Node temp = node;
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if(c == '.'){
                for (Node n : temp.nodes){
                    if(n != null) {
                       if(searchHelper(word.substring(i + 1), n)) return true;
                    }
                }
                return false;
            }else{
                if(temp.nodes[c - 'a'] == null) return false;
                else temp = temp.nodes[c - 'a'];
            }
        }
        return temp.flag;
    }

    public static void main(String[] args) {
        Solution211 solution211 = new Solution211();
        solution211.addWord("bad");
        solution211.addWord("dad");
        solution211.addWord("mad");
        System.out.println(solution211.search("pad"));
        System.out.println(solution211.search("bad"));
        System.out.println(solution211.search("b.d"));
        System.out.println(solution211.search(".ad"));
        System.out.println(solution211.search("b.."));
        System.out.println(solution211.search("ba"));
    }
}
