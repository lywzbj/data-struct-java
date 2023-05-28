package org.example.datastruct.binarytree;

/**
 * 二叉树的链式存储结构
 *
 *  二叉树的链式存储可以采用三叉链表的形式存储
 *  1. parentNode   父节点
 *  2. leftNode     左子树节点
 *  3. rightNode    右子树节点
 *
 *
 */
public class ListBinaryTree<T> {


    /**
     * 头节点
     */
    private Node<T> head;

    /**
     * 节点数量
     */
    private int size = 0;


    /**
     * 上次走过的路径  0-表示左边   1-表示右边
     */
    private int way = 0;

    public ListBinaryTree(Node<T> head) {
        this.head = head;
    }

    public int size() {
        return this.size;
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
    private void order(Node<T> root,int type) {
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








    /**
     * 添加节点
     * @param t   t
     */
    public boolean add(T t) {
        // 如果头节点为空，则直接设置根节点
        if (this.head == null) {
            this.head = new Node<T>(t,null);
            this.size++;
            return true;
        }

        Node<T> tNode = find(this.head);
        Node<T> addNode = new Node<T>(t, null);
        addNode.setParent(tNode);
        if(tNode.getLeft() == null) {
            tNode.setLeft(addNode);
            this.size++;

            return true;
        }

        if(tNode.getRight() == null) {
            tNode.setRight(addNode);
            this.size++;
            return true;
        }
        return false;
    }



    private Node<T> find(Node<T> root) {

        Node left = root.getLeft();
        Node right = root.getRight();
        if(left == null || right == null) {
            return root;
        }
        // 先查左子树
        Node node = find(left);
        if(node != null) {
            return node;
        }
        // 再查右子树
        return find(right);
    }






    private static class Node<T> {

        public Node(T data, Node parent) {
            this.data = data;
            this.parent = parent;
        }

        public Node(T data, Node parent, Node right, Node left) {
            this.data = data;
            this.parent = parent;
            this.right = right;
            this.left = left;
        }

        public Node() {
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        private T data;

        private Node parent;

        private Node right;

        private Node left;




    }







}



