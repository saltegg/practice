package fzu.com;

import java.util.Iterator;

//固定容量的栈
public class FixedCapacityStack<Item> implements Iterable<Item> {
    private  Item[] a;
    private int N;

    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        if(N == a.length) resize(2 * a.length);
        a[N++] = item;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        if(N > 0 && N == a.length / 4) resize(a.length / 2);
        return item;
    }

    private void resize(int max)  {
        Item[] temp = (Item[]) new Object[max];
        /*for(int i = 0; i < N; i++){
            temp[i] = a[i];
        }*/
        if (N >= 0) System.arraycopy(a, 0, temp, 0, N);
        a = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>{

        private int i = N;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        FixedCapacityStack<Integer> testStack = new FixedCapacityStack<Integer>(10);
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);
        for (Integer c: testStack) {
            System.out.println(c);
        }
    }
}
