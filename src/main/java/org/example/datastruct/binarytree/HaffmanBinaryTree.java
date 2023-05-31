package org.example.datastruct.binarytree;


import java.util.*;
import java.util.stream.Collectors;

/**
 * 哈夫曼二叉树的代码实现
 */
public class HaffmanBinaryTree {


    public static void main(String[] args) {
        List<Integer> list1 = new LinkedList<>();

        list1.add(2);
        list1.add(4);
        list1.add(7);
        list1.add(8);
        list1.add(12);
        list1.add(29);
        list1.add(9);
        HaffmanBinaryTree tree = new HaffmanBinaryTree(list1);
        tree.build();

        System.out.println(tree);
    }

    private Node head;


    private List<Integer> list;


    private Map<Integer,Node> map = new HashMap<>();



    public HaffmanBinaryTree(List<Integer> list) {
        this.list = list;
    }


    /**
     * 构建哈夫曼树
     */
    public void build() {


        // 将所有数据设置为仅有根节点的
        List<Node> nodes = new LinkedList<>();
        for (Integer integer : list) {
            Node node = new Node();
            node.setWeight(integer);
            nodes.add(node);
        }

        while (true) {
            if(nodes.size() < 2) {
                break;
            }
            List<Node> collect = nodes.stream().sorted(Comparator.comparingInt(value -> value.weight)).collect(Collectors.toList());
            // 先取两个最小的节点，组成一棵树
            Node v1 = collect.get(0);
            Node v2 = collect.get(1);



            //  1  2  3   4   5   6
            // 3 3 4 5 6
            // 3 5 6 7
            // 6 7 8

            Integer v3 = v1.getWeight() + v2.getWeight();
            Node node3 = new Node();
            node3.setWeight(v3);
            node3.setLeft(v1);
            node3.setRight(v2);

            // 删除旧的树，新增构造的树
            nodes.remove(v1);
            nodes.remove(v2);
            nodes.add(node3);
        }
        this.head = nodes.get(0);
    }








    private class Node {

        private int weight;


        private Node left;


        private Node right;


        private boolean hasLeaf = true;


        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
            this.setHasLeaf(false);
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
            this.setHasLeaf(false);
        }


        public boolean isHasLeaf() {
            return hasLeaf;
        }

        public void setHasLeaf(boolean hasLeaf) {
            this.hasLeaf = hasLeaf;
        }
    }














}
