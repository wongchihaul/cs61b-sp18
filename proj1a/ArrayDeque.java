public class ArrayDeque<T> {

    private T[] arr;
    private int size = 0;
    private int nextFirst = 0;
    private int nextLast = 1;

    /**The starting size of your array should be 8.*/
    private static final int MIN_INITIAL_CAPACITY = 8;

    /**Creates an empty array deque.*/
    public ArrayDeque() {
        this.arr = (T[]) new Object[MIN_INITIAL_CAPACITY];
    }

    /**Resize the array*/

    private void resize(int capacity) {
        int n = this.arr.length;
        T[] a = (T[]) new Object[capacity];
        int pointer = 0;
        while (this.arr[pointer] == null) {
            pointer++;
        }
        System.arraycopy(this.arr, pointer, a, 0, this.size);
        this.arr = a;
        this.nextFirst = capacity - 1;
        this.nextLast = n;
    }

    public void addFirst(T item) {
        this.arr[this.nextFirst] = item;
        if (this.nextFirst == 0) {
            this.nextFirst = this.arr.length - 1;
        } else {
            this.nextFirst--;
        }
        this.size++;
        if (this.size == this.arr.length) {
            this.resize(this.arr.length * 2);
        }
    }

    public void addLast(T item) {
        this.arr[this.nextLast] = item;
        this.nextLast = (this.nextLast + 1) % (this.arr.length - 1);
        this.size++;
        if (this.size == this.arr.length) {
            this.resize(this.arr.length * 2);
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }



    public void printDeque() {

        int pointer = this.nextFirst % (this.arr.length - 1) + 1;
        while (pointer <= this.arr.length - 1) {
            System.out.print(this.arr[pointer] + " ");
            pointer += 1;
        }
        pointer = 0;
        while (pointer <= this.nextFirst) {
            System.out.print(this.arr[pointer] + " ");
            pointer += 1;
        }

    }


    public T removeFirst() {
        if (this.size == 0) {
            return null;
        }
        T item;
        if (this.nextFirst == this.arr.length - 1) {
            item = this.arr[0];
            this.arr[0] = null;
            this.nextFirst = 0;
        } else {
            item = this.arr[this.nextFirst + 1];
            this.arr[this.nextFirst + 1] = null;
            this.nextFirst++;
        }
        this.size--;
        if (this.arr.length >= 16 &&  this.size > 0 && size == this.arr.length / 4) {
            resize(this.arr.length / 2);
        }
        return item;
    }

    public T removeLast() {
        if (this.size == 0) {
            return null;
        }
        T item;
        if (this.nextLast == 0) {
            item = this.arr[this.arr.length - 1];
            this.arr[this.arr.length - 1] = null;
            this.nextLast = this.arr.length - 1;
        } else {
            item = this.arr[this.nextLast - 1];
            this.arr[this.nextLast - 1] = null;
            this.nextLast--;
        }
        this.size--;
        if (this.arr.length >= 16 &&  this.size > 0 && this.size == this.arr.length / 4) {
            resize(this.arr.length / 2);
        }
        return item;
    }


    public T get(int index) {
        int indexInArray;
        int starter = this.nextFirst + 1;
        if (index > this.size - 1) {
            return null;
        } else {
            if (this.nextFirst == this.arr.length - 1) {
                indexInArray = index;
            } else {
                if (index < this.arr.length - 1 - starter) {
                    indexInArray = (starter + index) % (this.arr.length - 1);
                } else if (index == this.arr.length - 1 - starter) {
                    indexInArray = this.arr.length - 1;
                } else {
                    indexInArray = (starter + index) % (this.arr.length - 1) - 1;
                }
            }
        }
        return this.arr[indexInArray];
    }

}