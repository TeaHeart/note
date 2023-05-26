package org.example;

public class T443 {
    public int compress(char[] chars) {
        int length = 0;
        for (int slow = 0; slow < chars.length; ) {
            int fast = slow;
            while (fast < chars.length && chars[fast] == chars[slow]) {
                fast++;
            }
            chars[length++] = chars[slow];
            int count = fast - slow;
            if (count != 1) {
                String cs = String.valueOf(count);
                for (int i = 0; i < cs.length(); i++) {
                    chars[length++] = cs.charAt(i);
                }
            }
            slow = fast;
        }
        return length;
    }
}
