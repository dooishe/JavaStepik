package com.elmir.question_1;

import com.elmir.question_1.CustomArrayList;
import com.elmir.question_1.CustomLinkedList;

public class Main {
    public static void main(String[] args){
        CustomArrayList<Integer> array_list = new CustomArrayList<>();
        array_list.add(1);
        array_list.add(2);
        array_list.add(3);
        System.out.println(array_list.get(0));
        array_list.set(1, 10);
        System.out.println(array_list.get(1));


        CustomLinkedList<Character> linked_list = new CustomLinkedList<>();
        linked_list.add('A');
        linked_list.add('B');
        linked_list.add('C');
        System.out.println(linked_list.get(0));
        linked_list.set(1, 'D');
        System.out.println(linked_list.get(1));
        for (Character el: linked_list){
            System.out.println(el);
        }
    }
}
