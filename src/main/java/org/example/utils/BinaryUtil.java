package org.example.utils;

import org.example.datastruct.binarytree.BinaryNode;

public class BinaryUtil {


    /**
     * 二叉树的先序遍历
     * @param node
     */
    public static void firstForeach(BinaryNode node) {
        if(node != null) {
            System.out.println(node.getKey());
            firstForeach(node.getLeft());
            firstForeach(node.getRight());
        }
    }


    /**
     * 二叉树的中序遍历
     * @param node
     */
    public static void middleForeach(BinaryNode node) {
        if(node != null) {
            middleForeach(node.getLeft());
            System.out.println(node.getKey());
            middleForeach(node.getRight());
        }
    }


    /**
     * 二叉树的后序遍历
     * @param node
     */
    public static void endForeach(BinaryNode node) {
        if(node != null) {
            endForeach(node.getLeft());
            endForeach(node.getRight());
            System.out.println(node.getKey());
        }
    }


    /**
     * 二叉树的层序遍历
     * @param node
     */
    public static void levelForeach(BinaryNode node) {





    }








}
