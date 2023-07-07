package org.example;

import java.util.Arrays;

public class T1472 {
    class BrowserHistory {
        String[] urls = new String[16];
        int left;
        int size;

        public BrowserHistory(String homepage) {
            visit(homepage);
        }

        public void visit(String url) {
            if (size == urls.length) {
                urls = Arrays.copyOf(urls, urls.length * 2);
            }
            size = left;
            urls[size++] = url;
            left = size;
        }

        public String back(int steps) {
            left -= Math.min(steps, left - 1);
            return urls[left - 1];
        }

        public String forward(int steps) {
            left += Math.min(steps, size - left);
            return urls[left - 1];
        }
    }
}
