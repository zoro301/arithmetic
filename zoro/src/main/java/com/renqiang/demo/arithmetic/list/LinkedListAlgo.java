package com.renqiang.demo.arithmetic.list;

/**
 * @Author: renqiang
 * @Date: 2018-11-06 21:23
 * @Description: 链表操作
 */
public class LinkedListAlgo {

    //单链表反转
    public Node reverseList(Node head){
        //反转后的链表
        Node headNode = null;

        Node preNode = null;
        Node currentNode = head;
        while(currentNode != null){
            Node nextNode = currentNode.next;

            //当前节点的下后一节点为空，说明当前节点是尾节点，直接反转
            if(nextNode == null){
                headNode = currentNode;
            }

            //反转当前节点
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }

        return headNode;
    }

    /**
     * 检测环
     * @param list
     * @return
     */
    public boolean checkCircle(Node list){
        if(list == null){
            return false;
        }

        Node fast = list.next;
        Node slow = list;
        while (fast != null && fast.next != null){
            //两个节点无法形成环，直接寻找下一节点
            fast = fast.next.next;//每次移动两个节点
            slow = slow.next;//每次移动一个节点

            if(fast == slow){//如果存在环，一定会相遇
                return true;
            }
        }
        return false;
    }

    public static class Node{

        private int data;
        private Node next;

        public Node(int data,Node next){
            this.data = data;
            this.next = next;
        }
    }
}
