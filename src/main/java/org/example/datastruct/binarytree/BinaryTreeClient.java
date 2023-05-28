package org.example.datastruct.binarytree;

public class BinaryTreeClient {


    public static void main(String[] args) {

        ListBinaryTree<Integer> integerListBinaryTree = new ListBinaryTree<Integer>(null);
        integerListBinaryTree.add(1);
        integerListBinaryTree.add(2);
        integerListBinaryTree.add(3);
        integerListBinaryTree.add(4);
        integerListBinaryTree.add(5);
        integerListBinaryTree.add(6);
        integerListBinaryTree.inOrder();
        System.out.println(integerListBinaryTree);
    }




}
