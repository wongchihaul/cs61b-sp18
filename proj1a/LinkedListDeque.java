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
//        this.sentinel = new Node(null, this.sentinel, this.sentinel);
        this.sentinel.prev = this.sentinel;
        this.sentinel.next = this.sentinel;
    }

    public void addFirst(T item) {
        Node firstNode = new Node(item, this.sentinel, this.sentinel.next);
//        this.sentinel.next.prev = firstNode;
        this.sentinel.next = firstNode;
        firstNode.next.prev = firstNode;
        this.size++;
    }

    public void addLast(T item) {
        Node lastNode = new Node(item, this.sentinel.prev, this.sentinel);
        this.sentinel.prev = lastNode;
        lastNode.next = lastNode;
        this.size++;
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        Node p = this.sentinel.next;
        while(p != sentinel){
            System.out.println(p.item + " ");
            p = p.next;
        }
    }

    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        T item = this.sentinel.next.item;
        this.sentinel.next = this.sentinel.next.next;
        this.sentinel.next.prev = this.sentinel;
        this.size--;
        return item;
    }

    public T removeLast() {
        T item = this.sentinel.prev.item;
        this.sentinel.prev = this.sentinel.prev.prev;
        this.sentinel.prev.next = this.sentinel;
        this.size--;
        return item;
    }

    public T get(int index) {
        if (this.isEmpty()) {
            return null;
        } else {
            Node p = this.sentinel.next;
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
            return this.sentinel.next.item;
        }
        Node p = this.sentinel.next;
        return getHelper(index, p);
    }

    private T getHelper(int index, Node p) {
        if (index == 0) {
            return p.item;
        } else {
            p = p.next;
            return this.getHelper(index - 1,  p);
        }
    }

}
