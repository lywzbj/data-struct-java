package org.example;

import java.util.LinkedList;
import java.util.List;

/**
 * 从尾到头打印单向链表
 */
public class Six {

    public static void main(String[] args) {

        CustomList<Integer> list = new CustomList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        Node<Integer> node = list.getHead();


        System.out.println("===================");

        print(node);


    }


    public static  <T> void print(Node<T> node) {
        if(node != null) {
            print(node.next);
            System.out.println(node.data);
        }
    }



}


class CustomList<T> {

    Node<T> head;


    public void add(T t) {

        if(head == null) {
            head = new Node<>();
            head.data = t;
            return;
        }
        Node<T> tail = null;
        Node<T> next = head;
        while (tail == null) {
            if(next.next == null) {
                tail = next;
            } else {
                next=next.next;
            }
        }
        tail.next = new Node<>();
        tail.data = t;
    }


    public Node<T> getHead() {
        return head;
    }



}


class Node<T> {

    T data;

    Node<T> next;



    public Node() {};




}




