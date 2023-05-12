package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> lists = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            set2.add(i);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer i : set1) {
            if (!set2.contains(i)) {
                list.add(i);
            }
        }
        lists.add(list);
        list = new ArrayList<>();
        for (Integer i : set2) {
            if (!set1.contains(i)) {
                list.add(i);
            }
        }
        lists.add(list);
        return lists;
    }
}
