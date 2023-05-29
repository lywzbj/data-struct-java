package org.example.datastruct.binarytree;

/**
 * 排序二叉树
 * @param
 */
public class SortBinaryTree{


    /**
     * 头节点
     */
    private Node<Integer> head;


    public void add(Integer i) {

        if(this.head == null) {
            Node<Integer> node = new Node<Integer>(i);
            this.head = node;
            return;
        }

        // 比较并保存
        compareAdd(i,this.head);
    }


    private void compareAdd(Integer i,Node<Integer> nextNode) {
        Integer data = nextNode.getData();
        //  大于放右子树
        if(i > data) {

            // 右子树为空，则放在右子树
            if(nextNode.getRight() == null) {
                nextNode.setRight(new Node<Integer>(i));
            } else {
                compareAdd(i,nextNode.getRight());
            }
        } else {
            // 小于等于放左子树
            if(nextNode.getLeft() == null) {
                nextNode.setLeft(new Node<Integer>(i));
            }
            else {
                compareAdd(i,nextNode.getLeft());
            }

        }
    }




    /**
     * 二叉树的先序遍历
     */
    public void preOrder() {
        order(this.head,0);
    }


    /**
     * 二叉树的中序遍历
     */
    public void inOrder() {
        this.order(this.head,1);
    }


    /**
     * 二叉树的后序遍历
     */
    public void postOrder() {
        this.order(this.head,2);
    }


    /**
     * 二叉树的遍历
     * @param root  遍历节点
     * @param type  遍历类型   0-先序遍历   1-中序遍历   2-后序遍历
     */
    private void order(Node<Integer> root, int type) {
        if(root != null) {
            if(type == 0) {
                System.out.println(root.getData());
                order(root.getLeft(),type);
                order(root.getRight(),type);
            } else if (type == 1) {
                order(root.getLeft(),type);
                System.out.println(root.getData());
                order(root.getRight(),type);
            }else {
                order(root.getLeft(),type);
                order(root.getRight(),type);
                System.out.println(root.getData());
            }
        }
    }





    private class Node<N> {

        private N data;

        private Node<N> left;

        private Node<N> right;

        public Node(N data) {
            this.data = data;
        }

        public Node() {
        }

        public N getData() {
            return data;
        }

        public void setData(N data) {
            this.data = data;
        }

        public Node<N> getLeft() {
            return left;
        }

        public void setLeft(Node<N> left) {
            this.left = left;
        }

        public Node<N> getRight() {
            return right;
        }

        public void setRight(Node<N> right) {
            this.right = right;
        }
    }



}
