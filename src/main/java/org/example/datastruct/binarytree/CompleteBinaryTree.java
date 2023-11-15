package org.example.datastruct.binarytree;


import java.util.LinkedList;

// 完全二叉树
public class CompleteBinaryTree implements IBinaryTree{


    public static void main(String[] args) {
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree();
        for (int i = 0; i < 10; i++) {
            completeBinaryTree.add(i);
        }
    }




    /**
     * 二叉树头节点
     */
    private BinaryNode head;



    public void add(Integer value) {

        if(head == null) {
            BinaryNode node = new BinaryNode(value);
            this.head = node;
            return;
        }

        BinaryNode node = getTailNode();
        BinaryNode newNode = new BinaryNode(value);
        if(node.getLeft() == null) {
            node.setLeft(newNode);
            return;
        }
        if(node.getRight() == null) {
            node.setRight(newNode);
            return;
        }
    }

    @Override
    public BinaryNode getRoot() {
        return head;
    }


    private BinaryNode getTailNode() {

        LinkedList<BinaryNode> stack = new LinkedList<>();
        stack.add(head);
        while (true) {
            BinaryNode poll = stack.poll();
            BinaryNode left = poll.getLeft();
            BinaryNode right = poll.getRight();

            if(left == null || right == null) {
                return poll;
            }
            stack.offer(left);
            stack.offer(right);
        }
    }

























}
