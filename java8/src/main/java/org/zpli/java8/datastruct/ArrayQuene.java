package org.zpli.java8.datastruct;

import java.util.Queue;

/**
 * @Description: TODO
 * @Copyright: Copyright © 深圳兆日科技股份有限公司（300333）
 * @author: 李宗萍（0677）
 * @Date: 2020/3/20 14:26
 */
public class ArrayQuene {

    private final int DEFAULT_SIZE = 10;
    private Object[] array;
    private int front, rear, count;

    public ArrayQuene() {
        this.array = new Object[DEFAULT_SIZE];
        front = rear = count = 0;
    }

    public boolean empty() {
        if (front == rear && count == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return count;
    }

    public void addElement(Object element) {
        if (front == rear && count > 0) {
            expand();
        }
        array[rear] = element;
        rear = (rear++) % DEFAULT_SIZE;
        count++;
    }

    private void expand() {
    }
}
