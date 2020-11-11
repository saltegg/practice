package fzu.com;

import com.sun.deploy.net.proxy.WFirefoxProxyConfig;

import java.util.Iterator;

public class LinkQueue<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;
    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void push(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    public Item pop(){
        Item item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        N--;
        return null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Item>{

        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        LinkQueue<Integer> queue = new LinkQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.pop();
        for(Integer a : queue){
            System.out.println(a);
        }
    }
}
