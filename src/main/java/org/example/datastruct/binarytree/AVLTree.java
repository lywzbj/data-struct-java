package org.example.datastruct.binarytree;


/**
 * 平衡二叉树的实现
 */
public class AVLTree {


    private BinaryNode root;


    public BinaryNode getRoot() {
        return root;
    }

    public void setRoot(BinaryNode root) {
        this.root = root;
    }

    public static void main(String[] args) {


        AVLTree tree = new AVLTree();

        for (int i = 0; i < 10; i++) {
            BinaryNode node = tree.insert(tree.getRoot(), i);
            tree.setRoot(node);
        }


        System.out.println(tree);




    }



    public int height(BinaryNode node) {
        if(node == null) {
            return 0;
        }
        return node.getHeight();
    }


    public int getBalance(BinaryNode node) {
        if(node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }


    private BinaryNode rightRotate(BinaryNode node) {
        BinaryNode x = node.getLeft();
        BinaryNode t2 = x.getRight();

        x.setRight(node);
        node.setLeft(t2);


        node.setHeight(Math.max(height(node.getLeft()),height(node.getRight())) + 1);
        x.setHeight(Math.max(height(x.getLeft()),height(x.getRight())) + 1);
        return x;
    }


    private BinaryNode leftRotate(BinaryNode node) {
        BinaryNode y = node.getRight();
        BinaryNode t2 = y.getLeft();

        y.setLeft(node);
        node.setRight(t2);

        node.setHeight(Math.max(height(node.getLeft()),height(node.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()),height(y.getRight())) + 1);
        return y;
    }



    public BinaryNode insert(BinaryNode node,int key) {
        if(node == null) {
            return new BinaryNode(key);
        }

        if (key < node.getKey()) {
            node.setLeft(insert(node.getLeft(),key));
        } else if(key > node.getKey()) {
            node.setRight(insert(node.getRight(),key));
        } else {
            return node;
        }

        node.setHeight(1 + Math.max(height(node.getRight()),height(node.getLeft())));
        int balance = getBalance(node);
        if(node.getLeft() != null) {
            if(balance > 1 && key < node.getLeft().getKey()) {
                return rightRotate(node);
            }

            if(balance > 1 && key > node.getLeft().getKey()) {
                node.setLeft(leftRotate(node.getLeft()));
                return rightRotate(node);
            }
        }


        if(node.getRight() != null) {
            if(balance < -1 && key > node.getRight().getKey()) {
                return leftRotate(node);
            }

            if(balance < -1 && key < node.getRight().getKey()) {
                node.setRight(rightRotate(node.getRight()));
                return leftRotate(node);
            }
        }
        return node;
    }



}


