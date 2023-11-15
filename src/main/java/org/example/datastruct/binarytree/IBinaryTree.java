package org.example.datastruct.binarytree;

public interface IBinaryTree {


    /**
     * 添加节点
     * @param value
     */
    void add(Integer value);



    BinaryNode getRoot();



    /**
     * 前序遍历
     */
    default void preSort(BinaryNode node) {
        if(node != null) {
            System.out.print(node.getKey() + " ");
            preSort(node.getLeft());
            preSort(node.getRight());
        }
    }



    /**
     * 中序遍历
     */
    default void middleSort(BinaryNode node){
        if(node != null) {
            middleSort(node.getLeft());
            System.out.println(node.getKey() + " ");
            middleSort(node.getRight());
        }
    }


    /**
     * 后续遍历
     */
   default  void afterSort(BinaryNode node) {
       if(node != null) {
           afterSort(node.getLeft());
           afterSort(node.getRight());
           System.out.println(node.getKey() + " ");
       }

   }












}
