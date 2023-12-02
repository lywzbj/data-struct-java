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
    private BinaryNode root;


    public static void main(String[] args) {


        AVLBinaryTree tree = new AVLBinaryTree();
        tree.add(100);
        tree.add(110);
        tree.add(98);
        tree.add(120);
        tree.add(130);


        System.out.println(tree);


    }


    public BinaryNode add(Integer i) {

        if(this.root == null) {
            BinaryNode node = new BinaryNode(i);
            this.setRoot(node);
            return getRoot();
        }

        // 比较并保存
      return  compareAddByLoop(i,this.root);
    }

    @Override
    public BinaryNode getRoot() {
        return root;
    }

    @Override
    public void setRoot(BinaryNode binaryNode) {
        this.root = binaryNode;
    }

    @Override
    public BinaryNode remove(Integer value) {
        BinaryNode binaryNode = find(value);
        // 没有匹配到任何节点
        if(binaryNode == null) {
            return null;
        }
         // 叶子节点/根节点 - 直接删除
        if(binaryNode.isLeaf()) {
            //根节点
            if(binaryNode == getRoot()) {
                this.root = null;
                return binaryNode;
            }
            // 叶子节点
            BinaryNode parent = binaryNode.getParent();
            parent.remove(binaryNode);
            return binaryNode;
        }
        // 非叶子节点 - 中间节点/根节点
        else {
            // 根节点
            if(binaryNode == getRoot()) {
                // 没有孩子，自生自灭
                if(binaryNode.getLeft() == null && binaryNode.getRight() == null) {
                    this.root = null;
                    return binaryNode;
                }
                // 只有一个儿子
                if(binaryNode.getLeft() != null && binaryNode.getRight() == null) {
                    this.root = binaryNode.getLeft();
                    return binaryNode;
                }
                if(binaryNode.getLeft() == null && binaryNode.getRight() != null) {
                    this.root = binaryNode.getRight();
                    return binaryNode;
                }
                // 两个儿子都有，从左儿子中找最右边的节点
                BinaryNode upChild = binaryNode.getLeft();
                while (true) {
                    BinaryNode right = upChild.getRight();
                    if(right == null) {
                        break;
                    } else {
                        upChild = right;
                    }
                }

                BinaryNode parent = upChild.getParent();
                // 说明根节点仅有两个儿子，且没有孙子
                if(parent == binaryNode) {
                    parent.setLeft(null);
                    upChild.setRight(parent.getRight());
                    this.root = upChild;
                    return binaryNode;
                } else {
                    // 有孙子
                    parent.remove(upChild);
                    upChild.setRight(binaryNode.getRight());
                    upChild.setLeft(binaryNode.getLeft());
                    this.root = upChild;
                    return binaryNode;
                }
            }
            // 中间节点
            else {
                // 选儿子上位
                BinaryNode upChild = binaryNode.getLeft();
                if(binaryNode.getLeft() == null && binaryNode.getRight() != null) {
                    upChild = binaryNode.getRight();
                }
                BinaryNode parent = binaryNode.getParent();
                if(parent.getRight() == binaryNode) {
                    parent.setRight(upChild);
                }
                if(parent.getLeft() == binaryNode) {
                    parent.setLeft(upChild);
                }
                return binaryNode;
            }
        }

    }

    @Override
    public BinaryNode find(Integer value) {
        BinaryNode root = getRoot();
        while (true) {
            if (root == null) {
                break;
            }

            if (root.getKey() == value) {
                return root;
            }
            root = value > root.getKey() ? root.getRight() : root.getLeft();
        }
        return null;
    }


    protected BinaryNode compareAddByLoop(Integer value,BinaryNode root) {
        BinaryNode parent = root;
        while (true) {
            // 如果插入的节点大于等于节点(一开始是根节点)
            if(value >= parent.getKey()) {
                // 获取右儿子
                BinaryNode right = parent.getRight();
                // 没有右儿子，则将插入的节点设置为右儿子
                if(right == null) {
                    BinaryNode node = new BinaryNode(value);
                    node.setParent(parent);
                    parent.setRight(node);
                    return node;

                }
                // 否则继续循环从右儿子开始往下找
                else {
                    parent = right;
                }
            }
            // 小于节点   逻辑与右子树相同
            else {
                BinaryNode left = parent.getLeft();
                if(left == null) {
                    BinaryNode binaryNode = new BinaryNode(value);
                    binaryNode.setParent(parent);
                    parent.setLeft(binaryNode);
                    return binaryNode;
                } else {
                    parent = left;
                }
            }
        }
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
