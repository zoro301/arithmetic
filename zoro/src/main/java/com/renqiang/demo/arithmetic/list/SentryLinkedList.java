package com.renqiang.demo.arithmetic.list;

/**
 * @Author: renqiang
 * @Date: 2018-11-07 13:17
 * @Description: 哨兵在链表中的使用
 */
public class SentryLinkedList {

    /**
     * 查找指定原素在链表中的索引
     * @param array
     * @param dest
     * @return
     */
    public int find(int[] array, int dest){
        int arrayLength = array.length;
        if(array == null || arrayLength < 0){
            return -1;
        }

        //最后下标位置的原素要被替换建立哨兵，先行判断
        if(array[arrayLength - 1] == dest){
            return arrayLength-1;
        }

        //数据最后的数据会被替换（创建哨兵），保存数组最后的数据
        int tmp = array[arrayLength-1];
        //哨兵就位
        array[arrayLength-1] = dest;
        int i = 0;

        while(array[i] != dest){//原素与目标值相等 或者 循环结束，跳出循环
            ++i;
        }

        //恢复数组最后位置原有的数据
        array[arrayLength-1] = tmp;

        if(i == arrayLength-1){//i如果和最后的下表相等，说明循环完了全部数据也没找到目标原素，原素不在数组中
            return -1;
        }else{
            return i;
        }

    }
}
