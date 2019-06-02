
public class ArrayDeque<T> {

    private T[] arr;
    private int size = 0;
    private int nextFirst = 0;
    private int nextLast = 1;

    /**The starting size of your array should be 8.*/
    private static final int MIN_INITIAL_CAPACITY = 8;

    /**Creates an empty array deque.*/
    public ArrayDeque() {
        arr = (T[]) new Object[MIN_INITIAL_CAPACITY];
    }

    /**Resize the array*/

    public void resize(int capacity) {
        int n = arr.length;
        T[] a = (T[]) new Object[capacity];
        int pointer = 0;
        while (arr[pointer] == null) {
            pointer++;
        }
        System.arraycopy(this.arr, pointer, a, 0, size);
        arr = a;
        nextFirst = capacity - 1;
        nextLast = n;
    }

    public void addFirst(T item) {
        arr[nextFirst] = item;
        if (nextFirst == 0) {
            nextFirst = this.arr.length - 1;
        } else {
            this.nextFirst--;
        }
        size++;
        if (size == this.arr.length) {
            this.resize(arr.length * 2);
        }
    }

    public void addLast(T item) {
        arr[nextLast] = item;
        nextLast = (nextLast + 1) % (this.arr.length - 1);
        size++;
        if (size == this.arr.length) {
            this.resize(arr.length * 2);
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

//    public void printDeque() {
//        int ptr = nextFirst % (arr.length - 1) + 1;
//        if (nextFirst > nextLast) {
//            while (ptr <= arr.length - 1) {
//                System.out.println(arr[ptr] + " ");
//                ptr ++ ;
//            }
//            ptr = 0;
//            while (ptr < nextLast) {
//                System.out.println(arr[ptr] + " ");
//                ptr ++ ;
//            }
//        }
//        else {
//            while (ptr < nextLast) {
//                System.out.println(arr[ptr] + " ");
//                ptr ++ ;
//            }
//        }
//
//    }

    public void printDeque() {

        int pointer = nextFirst % (arr.length - 1) + 1;
        while (pointer <= arr.length - 1) {
            System.out.print(this.arr[pointer] + " ");
            pointer += 1;
        }
        pointer = 0;
        while (pointer <= nextFirst) {
            System.out.print(this.arr[pointer] + " ");
            pointer += 1;
        }

    }


    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T item;
        if (nextFirst == this.arr.length - 1) {
            item = arr[0];
            arr[0] = null;
            nextFirst = 0;
        } else {
            item = arr [nextFirst + 1];
            arr[nextFirst + 1] = null;
            nextFirst++;
        }
        size--;
        if (arr.length >= 16 &&  size > 0 && size == arr.length / 4) {
            resize(arr.length / 2);
        }
        return item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T item;
        if (nextLast == 0) {
            item = arr[arr.length - 1];
            arr[arr.length - 1] = null;
            nextLast = arr.length - 1;
        } else {
            item = arr[nextLast - 1];
            arr[nextLast - 1] = null;
            nextLast--;
        }
        size--;
        if (arr.length >= 16 &&  size > 0 && size == arr.length / 4) {
            resize(arr.length / 2);
        }
        return item;
    }


    public T get(int index) {
        int indexInArray;
        int starter = nextFirst + 1;
        if (index > this.size - 1) {
            return null;
        } else {
            if (nextFirst == arr.length - 1) {
                indexInArray = index;
            } else {
                if (index < arr.length - 1 - starter) {
                    indexInArray = (starter + index) % (arr.length - 1);
                } else if (index == arr.length - 1 - starter) {
                    indexInArray = arr.length - 1;
                } else {
                    indexInArray = (starter + index) % (arr.length - 1) - 1;
                }
            }
        }
        return arr[indexInArray];
    }

}
