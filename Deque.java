/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private class Node {
        Item data;
        Node next;
        Node prev;

        public Node() {

        }

        public Node(Item data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

    }

    private Node sentinal;
    private int size;


    // construct an empty deque
    public Deque() {
        sentinal = new Node();
        sentinal.next = sentinal;
        sentinal.prev = sentinal;

        size = 0;

    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {

        if (item == null) {
            throw new IllegalArgumentException();
        }

        Node oldFirst = sentinal.next;
        Node newFirst = new Node(item, sentinal, oldFirst);
        sentinal.next = newFirst;
        oldFirst.prev = newFirst;

        size++;
    }

    // add the item to the back
    public void addLast(Item item) {

        if (item == null) {
            throw new IllegalArgumentException();
        }

        Node oldLast = sentinal.prev;
        Node newLast = new Node(item, oldLast, sentinal);
        sentinal.prev = newLast;
        oldLast.next = newLast;

        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node oldFirst = sentinal.next;
        Node newFirst = oldFirst.next; // a.k.a second Node
        Item returnedValue = oldFirst.data;

        newFirst.prev = sentinal;
        sentinal.next = newFirst;

        oldFirst.prev = null;
        oldFirst.next = null;


        size--;
        return returnedValue;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node oldLast = sentinal.prev;
        Node newLast = oldLast.prev;
        Item returnedValue = newLast.data;

        newLast.next = sentinal;
        sentinal.prev = newLast;

        oldLast.prev = null;
        oldLast.next = null;

        size--;
        return returnedValue;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIteration();
    }

    private class DequeIteration implements Iterator<Item> {

        Node current = sentinal.next;

        @Override
        public Item next() {
            if (current == sentinal) {
                throw new NoSuchElementException();

            }
            Item returnedValue = current.data;
            current = current.next;

            return returnedValue;
        }

        @Override
        public boolean hasNext() {
            return current != sentinal;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args) {

        Deque<Integer> d = new Deque<>();

        d.addLast(5);
        d.addLast(4);
        d.addFirst(3);
        d.addFirst(2);
        d.addFirst(1);

        d.removeFirst();
        d.removeLast();

        StdOut.println(d.size());

        for (int item : d) {
            StdOut.println(item);
        }


    }

}

