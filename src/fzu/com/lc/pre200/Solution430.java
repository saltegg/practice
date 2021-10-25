package fzu.com.lc.pre200;

public class Solution430 {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    public Node flatten(Node head) {
        Node newHead =  head, newHeadNext;
        while (newHead != null) {
            newHeadNext = newHead.next;
            if (newHead.child != null) {
                Node tail = deep(newHead.child);
                // 连接
                newHead.next = newHead.child;
                newHead.child.prev = newHead;
                newHead.child = null;
                if (newHeadNext != null) {
                    tail.next = newHeadNext;
                    newHeadNext.prev = tail;
                }
            }
            newHead = newHeadNext;
        }
        return head;
    }

    private Node deep(Node head) {
        Node newHead =  head, newHeadNext, pre = null;
        while (newHead != null) {
            newHeadNext = newHead.next;
            pre = newHead;
            if (newHead.child != null) {
                Node tail = deep(newHead.child);
                // 连接
                newHead.next = newHead.child;
                newHead.child.prev = newHead;
                newHead.child = null;
                if (newHeadNext != null) {
                    tail.next = newHeadNext;
                    newHeadNext.prev = tail;
                }
            }
            newHead = newHead.next;
        }
        return pre;
    }
}
