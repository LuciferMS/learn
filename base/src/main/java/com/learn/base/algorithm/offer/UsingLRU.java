package com.learn.base.algorithm.offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @program: learn
 * @description: useLRU
 * @author: Elliot
 * @create: 2019-08-26 17:05
 **/
public class UsingLRU {
    static class Node{
        char c;
        int times;

        public Node(char c, int times) {
            this.c = c;
            this.times = times;
        }
    }

    private int n;

    private int m;

    private int index = 0;

    private LinkedList<Node> nodes = new LinkedList<>();

    private HashMap<Character, Node> mark = new HashMap<>(32);

    private void add(Character c){
        if (mark.get(c) == null){
            Node node = new Node(c, 1);
            nodes.add(node);
            mark.put(c, node);
            return;
        }
        Node node = mark.get(c);
        node.times++;
        nodes.remove(node);
        if(node.times == m){
            nodes.add(index++, node);
        }else if (node.times > m){
            index--;
        }
    }

    private void parse(String s){
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            add(chars[i]);
        }
    }

    private char get(){
        return nodes.get(n - 1).c;
    }

    public UsingLRU(int n, int m) {
        this.n = n;
        this.m = m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        while(true){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            UsingLRU usingLRU = new UsingLRU(n, m);
            usingLRU.parse(s);
            System.out.println(usingLRU.get());
        }
    }
}
