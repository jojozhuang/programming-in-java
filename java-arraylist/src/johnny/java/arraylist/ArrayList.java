package johnny.java.arraylist;

import java.util.Arrays;

/*
 * Write a program to implement your own ArrayList class. It should
contain add(), get(), remove(), size() methods. Use dynamic array logic.
It should increase its size when it reaches threshold.
http://www.java2novice.com/java-interview-programs/arraylist-implementation/
http://www.vogella.com/tutorials/JavaDatastructureList/article.html
 */
public class ArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] arr;
    
    public ArrayList(){
        arr = new Object[DEFAULT_CAPACITY];
    }
     
    public void add(E e){
        if (arr.length == size) {
            increaseListSize();
        }
        arr[size++] = e;
    }

    public E get(int index){
        if (index < size && index >= 0) {
            return (E)arr[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public Object remove(int index){
        if (index < size){
            Object obj = arr[index];
            arr[index] = null;
            int tmp = index;
            while (tmp < size){
                arr[tmp] = arr[tmp + 1];
                arr[tmp + 1] = null;
                tmp++;
            }
            size--;
            return obj;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
     
    public int size(){
        return size;
    }
     
    private void increaseListSize(){
        arr = Arrays.copyOf(arr, arr.length * 2);
    }
}
