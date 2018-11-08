package com.renqiang.demo.arithmetic.list;

import java.util.LinkedList;

/**
 * @Author: renqiang
 * @Date: 2018-11-06 21:06
 * @Description: 链表实现最近最少使用缓存
 */
public class LinkedListLRUCache {

    /**
     * 容积
     */
    private int capacity;

    private LinkedList<Object> cacheList;

    public LinkedListLRUCache(int capacity){
        this.capacity = capacity;
        this.cacheList = new LinkedList<Object>();
    }

    public Object get(Object obj){
        int index = cacheList.indexOf(obj);
        Object result = null;

        if(index != -1){
            result = cacheList.get(index);
        }

        return result;
    }

    public void set(Object obj){
        if(cacheList.contains(obj)){
            cacheList.remove(obj);
        }else {
            removeLeastRecentlyUsedObj(obj);
        }
        cacheList.addFirst(obj);
    }

    /**
     * 移除最近未使用对象
     * @param obj
     */
    private void removeLeastRecentlyUsedObj(Object obj) {
        if(cacheList.size() >= capacity){
            cacheList.removeLast();
        }
    }
}
