package com.learn.base.algorithm.leetcode;

import java.util.LinkedList;

/**
 * @program: learn
 * @description: 课程表 拓扑排序 广度优先遍历
 * @author: Elliot
 * @create: 2019-08-12 23:19
 **/
public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //图中所有顶点
        int[] indegrees = new int[numCourses];
        //计算所有顶点的入度
        for(int[] cp : prerequisites) {
            indegrees[cp[0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        //拿出所有入度为0的顶点
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0) {
                queue.addLast(i);
            }
        }
        //
        while(!queue.isEmpty()) {
            Integer pre = queue.removeFirst();
            numCourses--;
            for(int[] req : prerequisites) {
                if(req[1] != pre) {
                    continue;
                }
                if(--indegrees[req[0]] == 0) {
                    queue.add(req[0]);
                }
            }
        }
        return numCourses == 0;
    }
}
