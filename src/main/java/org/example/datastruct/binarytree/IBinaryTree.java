package org.example.datastruct.binarytree;

public interface IBinaryTree {


    /**
     * 添加节点
     * @param value
     */
    BinaryNode add(Integer value);



    BinaryNode getRoot();



    void setRoot(BinaryNode binaryNode);



    /**
     * 删除节点
     * @param value
     * @return
     */
    BinaryNode remove(Integer value);


    /**
     * 查找节点
     * @param value
     * @return
     */
    BinaryNode find(Integer value);


    default int getHeight(BinaryNode node) {
        if(node == null) {
            return 0;
        }
        if(node.getRight() == null && node.getLeft() == null) {
            return 1;
        }
        return Math.max(getHeight(node.getLeft()),getHeight(node.getRight())) + 1;
    }



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
            System.out.print(node.getKey() + " ");
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
