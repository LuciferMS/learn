package algorithm.leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: learn
 * @description: leetcode56
 * @author: Elliot
 * @create: 2019-06-12 08:43
 **/
public class Solution56 {
    public static void main(String[] args) {
//        int[][] datas = {{1,3},{2,6},{8,10},{15,18}};
        int[][] datas = {{1, 4}, {2, 3}};
        int[][] result = merge(datas);
        for (int[] nums : result) {
            System.out.println("{" + nums[0] + " : " + nums[1] + "}");
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }
        if (intervals.length == 1) {
            return intervals;
        }
        Node[] nodes = new Node[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            nodes[i] = new Node(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(nodes, (node1, node2) -> {
            return node1.start - node2.start;
        });

        LinkedList<Node> nodeLinkedList = new LinkedList<>();
        nodeLinkedList.add(nodes[0]);
        for (int i = 1; i < nodes.length; i++) {
            Node node = nodeLinkedList.getLast();
            Node temp = nodes[i];
            if (temp.start <= node.end) {
                node.end = nodes[i].end > node.end ?
                        temp.end : node.end;
            } else {
                nodeLinkedList.add(nodes[i]);
            }
        }

        int[][] result = new int[nodeLinkedList.size()][2];
        for (int i = 0; i < nodeLinkedList.size(); i++) {
            Node node = nodeLinkedList.get(i);
            result[i][0] = node.start;
            result[i][1] = node.end;
        }
        return result;
    }

    static class Node {
        int start;
        int end;

        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
