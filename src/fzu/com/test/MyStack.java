package fzu.com.test;

import java.util.LinkedList;
import java.util.Stack;

public class MyStack extends Stack {  // 线程安全的栈

    LinkedList<String> heros = new LinkedList<>();

    //插入的时候，加上synchronized，同步对象是当前实例
    public synchronized void push(String h) {
        heros.addLast(h);
    }

    //取出的时候，加上synchronized，同步对象是当前实例
    public synchronized String pull() {
        return heros.removeLast();
    }

    //查看没必要加上synchronized，因为不修改数据
    public String peek() {
        return heros.getLast();
    }

}