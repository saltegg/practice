package fzu.com.codetop;

public class Solution138 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }

    public Node copyRandomList(Node head) {

        if (head == null) return null;

        Node dupHead = head;
        while (dupHead != null) {
            Node clone = new Node(dupHead.val, dupHead.next, null);
            Node tmp = dupHead.next;
            dupHead.next = clone;
            dupHead = tmp;
        }

        dupHead = head;
        while (dupHead != null) {
            dupHead.next.random = dupHead.random == null? null : dupHead.random.next;
            dupHead = dupHead.next.next;
        }

        dupHead = head;
        Node cloneHead = dupHead.next;
        while (dupHead.next != null) {
            Node tmp = dupHead.next;
            dupHead.next = dupHead.next.next;
            dupHead = tmp;
        }

        return cloneHead;
    }
}
