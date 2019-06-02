<<<<<<< HEAD
public class ArrayDeque<Item>{
    private Item[] arr;
=======

public class ArrayDeque<T> {

    private T[] arr;
>>>>>>> parent of deefccd... Week 3
    private int size = 0;
    private int nextFirst = 0;
    private int nextLast = 1;

    //viewed the source code of java.util.ArrayDeque
    //The starting size of your array should be 8.
    private static final int MIN_INITIAL_CAPACITY = 8;



<<<<<<< HEAD
//The signature of the constructor should be public ArrayDeque(). That is, you need only worry about initializing empty ArrayDeques.
//your ArrayDeque class must include a zero argument constructor that creates an empty Deque.

    public ArrayDeque(){
        arr =  (Item[]) new Object[MIN_INITIAL_CAPACITY];
=======
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
>>>>>>> parent of deefccd... Week 3
    }



//Adds an item to the front of the Deque.
//if your front pointer is at position zero, and you addFirst, the front pointer should loop back around
//to the end of the array (so the new front item in the deque will be the last item in the underlying array).

    public void addFirst(Item item){
        if (item == null){
            throw new NullPointerException();
        }
        arr[nextFirst] = item;
<<<<<<< HEAD
        if(this.nextFirst == 0){
            nextFirst = this.arr.length - 1;
        }else{
            this.nextFirst -= 1;
        }
        size += 1;
        if( size == arr.length){
            this.resize(arr.length*2);
=======
        if (nextFirst == 0) {
            nextFirst = this.arr.length - 1;
        } else {
            this.nextFirst--;
        }
        size++;
        if (size == this.arr.length) {
            this.resize(arr.length * 2);
>>>>>>> parent of deefccd... Week 3
        }
    }

    // if(nextFirst == (nextLast - 1) % (arr.length  -1)){
    // 	this.resize();
    // }
    // if(nextFirst == nextLast){
    // 	this.resize();
    // }
    // if(nextFirst == nextLast){
    // 	resize();
    // }
    // }


    //Adds an item to the back of the Deque.
    public void addLast(Item item){
        if (item == null){
            throw new NullPointerException();
        }
        arr[nextLast] = item;
        nextLast = (nextLast + 1) % (this.arr.length - 1);
<<<<<<< HEAD
        size += 1;
        if( size == arr.length){
            this.resize(arr.length*2);
=======
        size++;
        if (size == this.arr.length) {
            this.resize(arr.length * 2);
>>>>>>> parent of deefccd... Week 3
        }
    }
    // if(nextFirst == (nextLast - 1) % (arr.length  -1)){
    // 	this.resize();
    // }
    // if ( (nextLast = (nextLast + 1) & (arr.length - 1)) == nextFirst){
    // 	this.resize();
    // }

    //copied from source code for ArrayDeque, don't really understand
    // if ( (nextLast = (nextLast + 1) & (arr.length - 1)) == nextFirst){
    // 	resize();
    // }

    // }


    //Returns true if deque is empty, false otherwise.
    public boolean isEmpty(){
        return size() == 0;
    }

    // Returns the number of items in the Deque.
    public int size(){
        return this.size;
    }

<<<<<<< HEAD
    //Prints the items in the Deque from first to last, separated by a space.
//note should print the deque not the array.
    public void printDeque(){
=======
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
>>>>>>> parent of deefccd... Week 3

        int pointer = nextFirst % (arr.length - 1) + 1;
        while( pointer <= arr.length - 1){
            System.out.print(this.arr[pointer] + " ");
            pointer += 1;
        }
        pointer = 0;
        while( pointer <= nextFirst ){
            System.out.print(this.arr[pointer] + " ");
            pointer += 1;
        }

    }

    //Removes and returns the item at the front of the Deque. If no such item exists, returns null.
    public Item removeFirst(){
        if(size == 0){
            return null;
        }
<<<<<<< HEAD
        Item item;
        if(nextFirst == arr.length - 1){
            item = (Item) arr[0];
            arr[0] = null;
            nextFirst = 0;
        }else{
            item = (Item) arr[nextFirst + 1];
=======
        T item;
        if (nextFirst == this.arr.length - 1) {
            item = arr[0];
            arr[0] = null;
            nextFirst = 0;
        } else {
            item = arr [nextFirst + 1];
>>>>>>> parent of deefccd... Week 3
            arr[nextFirst + 1] = null;
            nextFirst += 1;
        }
        size -= 1;
        // usageFactor = this.size / arr.length;
        // if(arr.length >= 16 && usageFactor <= 0.25){
        //    this.keepUsage();
        //  }
        if(arr.length >= 16 && size > 0 && size == arr.length/4) {
            resize(arr.length/2);
        }
        return item;
    }

    //Removes and returns the item at the back of the Deque. If no such item exists, returns null.
    public Item removeLast(){
        if(size == 0){
            return null;
        }
        Item item;
        if(nextLast == 0){
            item = (Item) arr[arr.length - 1];
            arr[arr.length - 1] = null;
            nextLast = arr.length - 1;
            //return item;
        }else{
            item = (Item) arr[nextLast - 1];
            arr[nextLast - 1] = null;
            nextLast -= 1;
            //return item;
        }
        size -= 1;
        // usageFactor = this.size / arr.length;
        // if(arr.length >= 16 && usageFactor <= 0.25){
        //    this.keepUsage();
        //  }
        if(arr.length >= 16 && size > 0 && size == arr.length/4) {
            resize(arr.length/2);
        }
        return item;
    }

    public void resize(int capacity){
        int n = arr.length;
        Item[] a = (Item[]) new Object[capacity];
        int pointer = 0;
        while(arr[pointer] == null){
            pointer ++;
        }
        System.arraycopy(this.arr, pointer, a, 0, size);
        arr = a;
        nextFirst = capacity - 1;
        nextLast = n;
    }

    // private void keepUsage(){
    // 	int n = arr.length;
    // 	Item[] a = (Item[]) new Object[n/2];
    // 	if(nextFirst == arr.length - 1){
    // 	  System.arraycopy(this.arr, 0, a, 0, size);
    // 	}else{
    // 	  System.arraycopy(this.arr, nextFirst + 1, a, 0, Math.min(size, arr.length - nextFirst - 1) );
    //     // System.arraycopy(this.arr, 0, a, Math.min(size, arr.length - nextFirst - 1) , size - Math.min(size, arr.length - nextFirst - 1));
    //   }
    //   nextFirst = n/2 - 1 ;
    //   nextLast = size;
    //   arr = a;
    // }


    //Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
//If no such item exists, returns null. Must not alter the deque!
//note should get the ith item in the deque not the array.
    public Item get(int index){
        int indexInArray;
        int starter = nextFirst + 1;
        if(index > this.size - 1){
            return null;
        }else{
            if(nextFirst == arr.length - 1){
                indexInArray = index;
            }else{
                if( index < arr.length - 1 - starter ){
                    indexInArray = (starter + index ) % ( arr.length - 1);
                }else if( index == arr.length -1 - starter){
                    indexInArray = arr.length -1;
                }else{
                    indexInArray = (starter + index ) % ( arr.length - 1) - 1;
                }
            }
        }

        return arr[indexInArray];
    }
}