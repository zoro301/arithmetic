package com.renqiang.demo.arithmetic.list;

/**
 * @Author: renqiang
 * @Date: 2018-11-06 20:24
 * @Description: 自定义单链表
 */
public class SingleLinkedList<E> {
    Node<E> head;

    public static class Node<E>{
        private Node<E> next;
        private E element;

        public Node(Node<E> next,E item){
            this.next = next;
            this.element = item;
        }
    }

    /**
     * 根据元素值查找元素
     * @param item
     * @return
     */
    public Node<E> findByValue(E item){
        //从头节点开始查找
        Node<E> node = head;
        while(node != null && !node.element.equals(item)){
            node = node.next;
        }
        return node;
    }

    /**
     * 根据索引查找元素
     * @param index
     * @return
     */
    public Node<E> findByIndex(int index){
        //从头节点开始遍历
        Node<E> node = head;
        int pos = 0;
        while(node != null && pos != index){
            node = node.next;
            pos++;
        }
        return node;
    }

    /**
     * 从头部插入新节点
     * @param newNode
     */
    public void insertToHead(Node<E> newNode){
        if(head == null){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * 从头部插入新原素
     * @param item
     */
    public void insertToHead(E item){
        Node<E> newNode = new Node<E>(null,item);
        insertToHead(newNode);
    }

    /**
     * 指定节点后插入新元素
     * @param node
     * @param item
     */
    public void insertAfter(Node<E> node, E item){
        Node newNode = new Node(null,item);
        insertAfter(node,newNode);
    }

    /**
     * 指定节点后插入新节点
     * @param node
     * @param newNode
     */
    public void insertAfter(Node<E> node, Node<E> newNode){
        if(node == null){
            return;
        }

        newNode.next = node.next;
        node.next = newNode;
    }

    /**
     * 指定节点前插入新节点
     * @param node
     * @param newNode
     */
    public void insertBefore(Node<E> node,Node<E> newNode){
        if(node == null){
            return;
        }

        if(node == head){
            insertToHead(newNode);
        }

        Node<E> preNode = head;
        //查找指定节点的前一节点
        while (preNode != null && preNode.next != node){
            preNode = preNode.next;
        }

        if(preNode == null){
            return;
        }

        preNode.next = newNode;
        newNode.next = node;

    }

    /**
     * 指定节点前插入新元素
     * @param node
     * @param item
     */
    public void insertBefore(Node<E> node, E item){
        Node<E> newNode = new Node(null,item);
        insertBefore(node,newNode);
    }

    /**
     * 删除指定节点
     * @param node
     */
    public void deleteByNode(Node<E> node){
        if(node == null){
            return;
        }

        if(node == head){
            //head.next = null
            head = head.next;
        }

        Node<E> preNode = head;
        //查找当前节点的前置节点
        while(preNode != null && preNode.next != node){
            preNode = preNode.next;
        }

        if(preNode == null){
            return;
        }

        preNode.next = node.next;
    }

    /**
     * 根据元素删除节点
     * @param item
     */
    public void deleteByValue(E item){
        //从头节点开始查找值
        if(head == null){
            return;
        }

        Node<E> preNode = null;
        Node<E> currentNode = head;
        //根据值查找当前该值的当前节点和前一节点
        while(currentNode != null && !currentNode.element.equals(item)){
            //下次循环，当前节点变为前一节点
            preNode = currentNode;
            currentNode = currentNode.next;
        }

        if(currentNode == null){
            return;
        }

        //前一节点为空，说明是头节点
        if(preNode == null){
            head = head.next;
        }

        preNode.next = currentNode.next;
    }
}
