package org.example.utils;

import org.example.datastruct.binarytree.BinaryNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        if(node == null) {
            System.out.println("节点为空,无法遍历");
            return;
        }
        List<BinaryNode> list = binaryToArray(node);
        for (BinaryNode binaryNode : list) {
            System.out.println(binaryNode.getKey());
        }
    }


    /**
     * 将二叉树通过层序遍历转换为数组
     * @param node
     * @return
     */
    public static List<BinaryNode> binaryToArray(BinaryNode node) {
        Queue<BinaryNode> queue = new LinkedList<>();
        List<BinaryNode> list = new ArrayList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            BinaryNode binaryNode = queue.poll();
            list.add(binaryNode);
            if(binaryNode.getLeft() != null) {
                queue.offer(binaryNode.getLeft());
            }
            if(binaryNode.getRight() != null) {
                queue.offer(binaryNode.getRight());
            }
        }
        return list;
    }


    public static  BinaryNode arrayToBinary(List<Integer> list) {
        if(list == null || list.isEmpty()) {
            return null;
        }
        final BinaryNode root = new BinaryNode(list.get(0));
        BinaryNode foreachNode = root;
        for (int i = 1; i < list.size(); i++) {
            Integer integer = list.get(i);
            boolean isRight = i % 2 == 0;
            BinaryNode node = null;
            if(integer != null) {
                node = new BinaryNode(integer);
                node.setParent(root);
            }
            // 左
            if(!isRight) {
                foreachNode.setLeft(node);
            }
            // 右
            else {
                foreachNode.setRight(node);
                foreachNode = node.getParent().getLeft();
            }
        }
        return root;
    }


    public static int getHigh(BinaryNode node) {

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(node);


        return 0;

    }










}
