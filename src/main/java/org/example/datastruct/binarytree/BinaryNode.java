package org.example.datastruct.binarytree;

public class BinaryNode {


    private int key;

    private int height;

    private BinaryNode left;

    private BinaryNode right;


    private BinaryNode parent;


    public BinaryNode(int key) {
        this.key = key;
        this.height = 1;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }


    public BinaryNode getParent() {
        return parent;
    }

    public void setParent(BinaryNode parent) {
        this.parent = parent;
    }


    public boolean remove(BinaryNode node) {
        if(node == null) {
            throw new RuntimeException("节点不能为空");
        }
        if(getLeft() != null && getLeft() == node) {
            setLeft(null);
            return true;
        }

        if(getRight() != null && getRight() == node) {
            setRight(null);
            return true;
        }

        return false;
    }


    public boolean isLeaf() {
        return getRight() == null && getLeft() == null;
    }


}
