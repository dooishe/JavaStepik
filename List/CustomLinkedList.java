package com.elmir.question_1;

import java.util.Iterator;

public class CustomLinkedList<T> extends CustomList<T> implements Iterable<T> {
    int size = 0;
    Node<T> first = null;
    Node<T> end = null;

    private CustomLinkedListIterator iter = null;

    @Override
    public Iterator<T> iterator(){
        if (iter == null){
            iter = new CustomLinkedListIterator<>(this);
        }
        return iter;
    }

    public class CustomLinkedListIterator<E> implements Iterator<E>{
        CustomLinkedList linked_list;
        int cur = 0;

        CustomLinkedListIterator(CustomLinkedList linked_list){
            this.linked_list = linked_list;
        }

        @Override
        public boolean hasNext() {
            return cur < linked_list.size;
        }

        @Override
        public E next() {
            cur += 1;
            return (E) linked_list.get(cur);
        }
    }

    class Node<E>{
        Node(E val, Node<E> link){
            value = val;
            next = link;
        }
        E value;
        Node<E> next;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T value) {
        if (first == null){
            first = new Node<>(value, null);
            end = first;
        }
        else{
            Node<T> temp = new Node<>(value, null);
            end.next = temp;
            end = temp;
        }
        size += 1;
    }

    @Override
    public void set(int index, T value) {
        if (index >= 0 && index < size) {
            if (index == 0){
                Node<T> temp = new Node<>(value, first);
                first = temp;
                size += 1;
                return;
            }
            if (index == size){
                this.add(value);
                return;
            }

            Node<T> temp = first;
            for (int i = 0; i < index - 1; i++){
                temp = temp.next;
            }
            Node<T> cur_node = new Node<>(value, temp.next);
            temp.next = cur_node;
            size += 1;
        }
    }

    @Override
    public T get(int index) {
        Node<T> temp = first;
        if (index >= 0 && index < size){
            for (int i = 0; i < index; i++){
                temp = temp.next;
            }
            return temp.value;
        }
        return null;
    }

}
