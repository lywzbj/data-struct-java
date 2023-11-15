package org.example.datastruct.binarytree;

import java.util.Random;

/**
 * 排序二叉树
 * @param
 */
public class SortBinaryTree implements  IBinaryTree{


    /**
     * 头节点
     */
    private BinaryNode head;


    public static void main(String[] args) {


        SortBinaryTree tree = new SortBinaryTree();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            tree.add(random.nextInt(100));
        }
    }


    public void add(Integer i) {

        if(this.head == null) {
            BinaryNode node = new BinaryNode(i);
            this.head = node;
            return;
        }

        // 比较并保存
        compareAdd(i,this.head);
    }

    @Override
    public BinaryNode getRoot() {
        return head;
    }


    private void compareAdd(Integer i,BinaryNode nextNode) {
        Integer data = nextNode.getKey();
        //  大于放右子树
        if(i > data) {

            // 右子树为空，则放在右子树
            if(nextNode.getRight() == null) {
                nextNode.setRight(new BinaryNode(i));
            } else {
                compareAdd(i,nextNode.getRight());
            }
        } else {
            // 小于等于放左子树
            if(nextNode.getLeft() == null) {
                nextNode.setLeft(new BinaryNode(i));
            }
            else {
                compareAdd(i,nextNode.getLeft());
            }

        }
    }











}
