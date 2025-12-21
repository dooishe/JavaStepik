package com.elmir.question_1;

import java.util.Iterator;

public class CustomArrayList<T> extends CustomList<T> implements Iterable<T>{
    private int size = 0;
    T[] array = (T[]) new Object[size];
    private CustomArrayListIterator iter = null;


    @Override
    public Iterator<T> iterator(){
        if (iter == null){
            iter = new CustomArrayListIterator(this);
        }
        return iter;
    }

    public class CustomArrayListIterator<E> implements Iterator<E>{
        CustomArrayList array_list;
        int cur = 0;

        CustomArrayListIterator(CustomArrayList array_list){
            this.array_list = array_list;
        }

        @Override
        public boolean hasNext() {
            return cur < array_list.size;
        }

        @Override
        public E next() {
            cur += 1;
            return (E) array_list.get(cur);
        }
    }


    private void checkSizeArray(){
        if (array.length <= size){
            this.updateSizeArray();
        }
    }

    private void updateSizeArray(){
        T[] array_copy = (T[]) new Object[array.length * 2];
        for (int i = 0; i < size; i++){
            array_copy[i] = array[i];
        }
        array = array_copy;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T value) {
        if (size == 0){
            size = 1;
            array = (T[]) new Object[size];
            array[0] = value;

        }
        else{
            this.checkSizeArray();
            array[size] = value;
            size += 1;
        }
    }

    @Override
    public void set(int index, T value) {
        this.checkSizeArray();
        for (int i = size; i >= index; i--){
            array[i] = array[i - 1];
        }
        array[index] = value;
    }

    @Override
    public T get(int index) {
        if(index < size){
            return array[index];
        }
        return null;
    }
}
