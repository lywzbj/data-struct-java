package org.example.algorithm.offer;


import java.util.Stack;

/**
 * 使用两个栈的数据结构实现一个队列
 */
public class Eight {


    public static void main(String[] args) {


        CustomQueue queue = new CustomQueue();


        for (int i = 0; i < 50; i++) {
                queue.appendTail(i);
                if(i % 4 == 0) {
                    System.out.println(queue.deleteFront());
                }
        }
        while (queue.size() != 0) {
            System.out.println(queue.deleteFront());
        }











    }







}


class CustomQueue {



    private Stack<Integer> stack1 = new Stack<>();

    private Stack<Integer> stack2 = new Stack<>();


    private int size = 0;



    /**
     * 在队尾插入
     * @param value
     */
    public void appendTail(Integer value) {
        stack1.push(value);
        size++;
    }


    /**
     * 移除队头的数据
     * @return
     */
    public Integer deleteFront() {

        if(size == 0) {
            throw new RuntimeException("队列为空");
        }
        if(stack2.size() == 0) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        size--;
        return stack2.pop();
    }




    public int size() {
        return size;
    }





}




