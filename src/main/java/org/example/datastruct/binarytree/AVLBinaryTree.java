package org.example.datastruct.binarytree;

public class AVLBinaryTree extends SortBinaryTree{


    /**
     * 默认为1
     */
    private Integer balance  = 1;



    public int getNodeBalance(BinaryNode node) {
        int right = getHeight(node.getRight());
        int left = getHeight(node.getLeft());
        return left - right;
    }


    @Override
    public BinaryNode add(Integer i) {
        BinaryNode add = super.add(i);
        BinaryNode tmp  = add;

        if(add != getRoot()) {
            while (true) {
                BinaryNode parent = tmp.getParent();
                if(parent == null) {
                    break;
                }
                int nodeBalance = getNodeBalance(parent);
                if(Math.abs(nodeBalance) <= balance) {
                    tmp = parent;
                } else {
                    // 执行旋转
                    // 左旋
                    if(nodeBalance < 0) {
                        leftRotate(parent);
                        break;
                    } else {
                        // 执行右旋



                    }
                }
            }
        }
        return  add ;
    }

    public void leftRotate(BinaryNode node) {
        if(node == getRoot()) {
            BinaryNode right = node.getRight();
            node.setRight(null);
            right.setParent(null);
            right.setLeft(node);
            setRoot(right);
        }
    }
































}
