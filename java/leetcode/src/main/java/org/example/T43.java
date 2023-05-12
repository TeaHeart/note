package org.example;

public class T43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder("0");
        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder curr = new StringBuilder();
            for (int j = num2.length() - 1; j > i; j--) {
                curr.append(0);
            }
            int carry = 0;
            int y = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int pro = x * y + carry;
                curr.append(pro % 10);
                carry = pro / 10;
            }
            if (carry != 0) {
                curr.append(carry % 10);
            }
            sb = stringAdd(sb, curr.reverse());
        }
        return sb.toString();
    }

    public StringBuilder stringAdd(StringBuilder num1, StringBuilder num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int value = x + y + carry;
            sb.append(value % 10);
            carry = value / 10;
        }
        return sb.reverse();
    }
}
