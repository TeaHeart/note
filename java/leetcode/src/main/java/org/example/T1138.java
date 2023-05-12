package org.example;

public class T1138 {
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int x = 0;
        int y = 0;
        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            ch -= 'a';
            int nx = ch / 5;
            int ny = ch % 5;
            for (int j = Math.max(0, x - nx); j > 0; j--) {
                sb.append('U');
            }
            for (int j = Math.max(0, y - ny); j > 0; j--) {
                sb.append('L');
            }
            for (int j = Math.max(0, nx - x); j > 0; j--) {
                sb.append('D');
            }
            for (int j = Math.max(0, ny - y); j > 0; j--) {
                sb.append('R');
            }
            sb.append('!');
            x = nx;
            y = ny;
        }
        return sb.toString();
    }
}
