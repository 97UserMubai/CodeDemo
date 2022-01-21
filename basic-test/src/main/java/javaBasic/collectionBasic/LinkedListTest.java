package javaBasic.collectionBasic;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @name: LinkedListTest
 * @author: mubai.
 * @date: 2022/1/5
 * @version: 1.0
 * @description: 使用LinkedList进行队列，双向队列，栈
 */
public class LinkedListTest {
    public static void main(String[] args) {
        //队列
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        while (queue.peek() != null) {
            System.out.println(queue.poll());
        }
        //栈
        Deque<String> stack = new LinkedList<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        while (stack.peek() != null) {
            System.out.println(stack.pop());
        }
    }
}
