package javaBasic.arrayBasic;

import java.util.Stack;

/**
 * @name: Stacks
 * @author: mubai.
 * @date: 2021/11/22
 * @version: 1.0
 * @description:
 */
public class Stacks {
    static String[] months = {
            "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
    };

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (String month : months) {
            stack.push(month);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
