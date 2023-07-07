package org.example;

import java.util.*;

public class T2456 {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        class Node {
            long total;
            int view = -1;
            String id;
        }
        Map<String, Node> map = new HashMap<>();
        long max = 0;
        for (int i = 0; i < creators.length; i++) {
            Node node = map.computeIfAbsent(creators[i], k -> new Node());
            node.total += views[i];
            max = Math.max(max, node.total);
            if (views[i] > node.view || views[i] == node.view && ids[i].compareTo(node.id) < 0) {
                node.view = views[i];
                node.id = ids[i];
            }
        }
        List<List<String>> lists = new ArrayList<>();
        for (Map.Entry<String, Node> entry : map.entrySet()) {
            String creator = entry.getKey();
            Node node = entry.getValue();
            if (node.total == max) {
                lists.add(Arrays.asList(creator, node.id));
            }
        }
        return lists;
    }
}
