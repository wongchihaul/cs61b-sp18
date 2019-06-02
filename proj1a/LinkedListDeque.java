public class LinkedListDeque<T> {
    private class Node {
        private T item;
        private Node prev, next;

        Node(T i, Node p, Node n) {
            this.item = i;
            this.prev = p;
            this.next = n;
        }
    }

    private int size = 0;
    private Node sentinel;

    /**create an empty Linked List Deque*/
    public LinkedListDeque() {
        this.sentinel = new Node(null, null, null);
        this.sentinel.prev = this.sentinel;
        this.sentinel.next = this.sentinel;
    }

    public void addFirst(T item) {
        Node firstNode = new Node(item, this.sentinel.prev, this.sentinel);
        this.sentinel.prev.next = firstNode;
        this.sentinel.prev = firstNode;
        this.sentinel = firstNode;
        this.size++;
    }

    public void addLast(T item) {
        Node lastNode = new Node(item, this.sentinel.prev, this.sentinel);
        this.sentinel.prev.next = lastNode;
        this.sentinel.prev = lastNode;
        this.size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        if (this.isEmpty()) {
            return;
        }
        else {
            Node p = this.sentinel;
            for (int i = 0; i < this.size; i++) {
                System.out.println(p.item + " ");
                p = p.next;
            }
        }
    }

    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        else {
            Node p = this.sentinel;
            p.prev.next = p.next;
            p.next.prev = p.prev;
            this.sentinel = p.next;
            this.size--;
            return p.item;
        }
    }

    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        else {
            Node p = this.sentinel.prev;
            p.next.prev = p.prev;
            p.prev.next = p.prev;
            this.size--;
            return p.item;
        }
    }

    public T get(int index) {
        if (this.isEmpty()) {
            return null;
        }
        else {
            Node p = this.sentinel;
            while (index != 0) {
                if (p.next == this.sentinel) {
                    return null;
                }
                p = p.next;
                index--;
            }
            return p.item;
        }
    }

    /**Same as get, but uses recursion*/
    public T getRecursive(int index) {
        if (index == 0) {
            return this.sentinel.item;
        }
        Node p = this.sentinel.next;
        return getHelper(index, p);
    }

    private T getHelper(int index, Node p) {
        if (index == 0) {
            return p.item;
        }
        else {
            p = p.next;
            return this.getHelper(index - 1,  p);
        }
    }

}
