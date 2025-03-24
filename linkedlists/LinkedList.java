/*
    Linked List:
    Data Structure consisting of nodes, where each node contains: data, a pointer (reference) to next node.
    Useful when frequent insertions/deletions are required (especially at the beginning or in the middle).
    Adding or removing elements is fast O(1) at the head or tail.
    Accessing elements O(n) requires traversal from the head.
 */

import java.util.NoSuchElementException;

public class LinkedList {

    public class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    // addLast
    public void addLast(int item) {
        var node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }

        size++;
    }

    // addFirst
    public void addFirst(int item) {
        var node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }

        size++;
    }

    private boolean isEmpty() {
        return first == null;
    }

    // indexOf
    public int indexOf(int item) {
        int index = 0;
        var current = first;
        while (current != null) {
            if (current.value == item) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    // contains
    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    // deleteFirst
    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            var second = first.next;
            first.next = null;
            first = second;
        }

        size--;
    }

    // deleteLast
    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            var previous = getPrevious(last);
            previous.next = null;
            last = previous;
//            below is also correct
//            last = previous;
//            last.next = null;
        }

        size--;
    }

    private Node getPrevious(Node node) {
        var current = first;
        while(current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];
        var current = first;
        var index = 0;
        while(current != null) {
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    public void reverse() {
        // [10 -> 20 -> 30]
        //  p     c      n
        // n = c.next (to keep track of 30 before running next line of code)
        // c.next = p
        // [10 <- 20 <- 30]
        //         p     c      n

        if (isEmpty()) return;

        var previous = first;
        var current = first.next;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthFromTheEnd (int k) {
        // Find the Kth node from the end
        // of a linked list in one pass
        // [10 -> 20 -> 30 -> 40 -> 50]
        //               *           *
        // K = 1 (50)
        // K = 2 (40)
        // K = 3 (30) (distance = 2)

        if (isEmpty())
            throw new IllegalStateException();

        var a = first;
        var b = first;
        for (int i = 0; i < k - 1; i++) {
            b = b.next;
            if (b == null)
                throw new IllegalArgumentException();
        }
        while (b != last) {
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

    public void printMiddle() {
        var a = first;
        var b = first;

        /*
        ODD NUMBER OF NODES
        [10  20  30  40  50]
             a   b
        [10  20  30  40  50]
                 a       b        b=last | print a.value

        EVEN NUMBER OF NODES
        [10  20  30  40  50  60]
             a   b
        [10  20  30  40  50  60]
                 a       b
        [10  20  30  40  50  60]
                 a                b    b!=last (goes to else branch) | print a.value & a.next.value
        */

        while (b != last && b.next != last) {
            b = b.next.next;
            a = a.next;
        }

        if (b == last)
            System.out.println(a.value);
        else
            System.out.println(a.value + ", " + a.next.value);
    }
}