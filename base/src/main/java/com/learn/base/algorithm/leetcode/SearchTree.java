package com.learn.base.algorithm.leetcode;

/**
 * @program: learn
 * @description: 二叉搜索树
 * @author: Elliot
 * @create: 2019-10-06 14:42
 **/
public class SearchTree {

    private Node root;
    private int size;

    public SearchTree(){

    }

    //添加元素，递归版本
    public boolean add(int val){
        if (root == null){
            root = new Node(val);
            size++;
            return true;
        }
        Node node = getAdapterNode(root, val);
        Node newNode = new Node(val);
        if(node.val > val){
            node.leftChild = newNode;
            newNode.parent = node;
        }else if(node.val < val){
            node.rightChild = newNode;
            newNode.parent = node;
        }else{

        }
        size++;
        return true;
    }

    //递归寻找操作节点的过程
    private Node getAdapterNode(Node node, int val) {
        if(node == null){
            return node;
        }
        if(node.val > val && node.leftChild == null){
            return node;
        }
        if(node.val < val && node.rightChild == null){
            return node;
        }
        if(node.leftChild == null && node.rightChild == null){
            return node;
        }
        if(node.val > val && node.leftChild != null){
            return getAdapterNode(node.leftChild, val);
        }else if (node.val < val && node.rightChild != null){
            return getAdapterNode(node.rightChild, val);
        }else{
            return node;
        }
    }

    //插入元素，非递归版本
    public boolean put(int val){
        return putVal(root, val);
    }

    //迭代寻找元素过程
    private boolean putVal(Node node, int val) {
        if(node == null){
            node = new Node(val);
            root = node;
            size++;
            return true;
        }
        Node temp = node;
        Node p;
        int t;
        do {
            p = temp;
            t = temp.val - val;
            if(t > 0){
                temp = temp.leftChild;
            }else if(t < 0){
                temp = temp.rightChild;
            }else{
                temp.val = val;
                return false;
            }
        }while(temp != null);
        Node newNode = new Node(p, val);
        if(t > 0){
            p.leftChild = newNode;
        }else if(t < 0){
            p.rightChild = newNode;
        }
        size++;
        return true;
    }

    public boolean delete(int val){
        Node node = getNode(val);
        Node parent = node.parent;
        Node leftChild = node.leftChild;
        Node rightChild = node.rightChild;
        if(leftChild == null && rightChild == null){
            if(parent != null){
                if (parent.leftChild == node){
                    parent.leftChild = null;
                }else if(parent.rightChild == node){
                    parent.rightChild = null;
                }
            }else{
                root = null;
            }
            node = null;
            return true;
        }else if(leftChild == null && rightChild != null){
            if (parent != null && parent.val > val){
                parent.leftChild = rightChild;
            }else if (parent != null && parent.val < val){
                parent.rightChild = rightChild;
            }else{
                root = rightChild;
            }
            node = null;
            return true;
        }else if(leftChild != null && rightChild == null){
            if(parent != null && parent.val > val){
                parent.leftChild = leftChild;
            }else if(parent != null && parent.val < val){
                parent.rightChild = leftChild;
            }else {
                root = leftChild;
            }
        }else if(leftChild != null && rightChild != null){
            Node successor = getSuccessor(node);
            int temp = successor.val;
            boolean delete = delete(temp);
            if(delete){
                node.val = temp;
            }
            successor = null;
            return true;
        }
        return  false;
}

    private Node getSuccessor(Node node) {
        if(node.rightChild != null){
            Node rightChild = node.rightChild;
            while(rightChild.leftChild != null){
                rightChild = rightChild.leftChild;
            }
            return rightChild;
        }
        Node parent = node.parent;
        while(parent != null && (node == parent.rightChild)){
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    public boolean remove(int val){
        Node node = getNode(val);
        if(node == null){
            return false;
        }
        if(node.leftChild == null){
            transplant(node, node.rightChild);
        }else if(node.rightChild == null){
            transplant(node, node.leftChild);
        }else{
            Node successor = getSuccessor(node);
            if (successor.parent != node){
                transplant(successor, successor.rightChild);
                successor.rightChild = node.rightChild;
                successor.rightChild.parent = successor;
            }
            transplant(node, successor);
            successor.leftChild = node.leftChild;
            successor.leftChild.parent = successor;
        }
        return true;
    }

    private void transplant(Node node, Node leftChild) {
    }

    private Node getNode(int val) {
        Node temp = root;
        int t;
        do {
            t = temp.val -val;
            if(t > 0){
                temp = temp.leftChild;
            }else if(t < 0){
                return temp;
            }else{
                return temp;
            }
        }while(temp != null);
        return null;
    }

    /**
     * 节点
     */
    static class Node{
        Node parent;
        Node leftChild;
        Node rightChild;
        int val;

        public Node(Node parent, Node leftChild, Node rightChild, int val) {
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.val = val;
        }

        public Node(int val) {
            this(null, null, null, val);
        }

        public Node(Node parent, int val) {
            this(parent, null, null, val);
        }
    }
}
