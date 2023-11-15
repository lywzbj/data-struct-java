package org.example.datastruct;

import org.example.datastruct.binarytree.CompleteBinaryTree;
import org.example.datastruct.binarytree.IBinaryTree;
import org.example.datastruct.binarytree.SortBinaryTree;

public class Client {


    public static void main(String[] args) {
        int [] array = {2,4,11,20,34,7,41,20};

        IBinaryTree sortTree = new SortBinaryTree();


        IBinaryTree completeTree = new CompleteBinaryTree();


        for (int i : array) {
            sortTree.add(i);
            completeTree.add(i);
        }

        System.out.println("前序遍历");
        sortTree.preSort(sortTree.getRoot());
        System.out.println("\n\r ============");
        completeTree.preSort(completeTree.getRoot());




        System.out.println("\n\r中序遍历");
        sortTree.middleSort(sortTree.getRoot());
        System.out.println("\n\r ============");
        completeTree.middleSort(completeTree.getRoot());










    }




}
