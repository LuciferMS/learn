package com.learn.base.algorithm.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: learn
 * @description: Solution690
 * @author: Elliot
 * @create: 2019-07-18 19:55
 **/
public class Solution690 {

    static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    ;

    public int getImportance(List<Employee> employees, int id) {
        int result = 0;
        HashMap<Integer, Employee> map = new HashMap<>();
        LinkedList<Employee> mark = new LinkedList<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        mark.add(map.get(id));
        while (!mark.isEmpty()) {
            int size = mark.size();
            for (int i = 0; i < size; i++) {
                Employee temp = mark.poll();
                result += temp.importance;
                if (!temp.subordinates.isEmpty()) {
                    for (int eid : temp.subordinates) {
                        mark.add(map.get(eid));
                    }
                }
            }
        }
        return result;
    }
}
