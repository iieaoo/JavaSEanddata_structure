package Heap;

import java.util.Arrays;

/**
 * ClassName: TestHeap
 * Package: Heap
 * Description:
 *  适用于完全二叉树
 *  大根堆  小根堆
 * @Author 全家乐
 * @Create 2023/5/26 0:35
 * Version 1.0
 */
public class TestHeap {
    public int[] elem;
    public int usedSize;

    public TestHeap() {
        this.elem = new int[10];
    }

    public void initElem(int[] array) {
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            usedSize++;
        }
    }

    //大根堆  时间复杂度O（N） 向下调整
    public void createHeap() {
        for (int parent = (usedSize-1-1)/2; parent >= 0; parent--) {
            shiftDown(parent,usedSize);
        }
    }
    private void shiftDown(int parent, int len) {//父亲下标   每棵树的结束下标
        //向下调整
        int child = 2*parent + 1;//要么有左孩子 没有右  要么都没有
        //最起码要有左孩子
        while (child < len) {
            if (child+1 < len && elem[child] < elem[child+1]) {//右孩子大
                child++;
            }
            //child下标 一定是左右孩子 最大值的下标
            if (elem[child] > elem[parent]) {
                int temp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = temp;
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }


    //大根堆里加一个数 先加到最后一个位置   向上调整
    //时间复杂度 O(N*logN)
    private void shiftUp(int child){
        int parent = (child-1)/2;
        while (child > 0) {
            if (elem[child] > elem[parent]){
                int temp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = temp;
                child = parent;
                parent = (child-1)/2;
            }else {
                break;
            }
        }
    }
    public void offer(int val) {
        if (isFull()) {
            elem = Arrays.copyOf(elem,2*elem.length);//扩容
        }
        elem[usedSize++] = val;
        //向上调整
        shiftUp(usedSize-1);
    }
    public boolean isFull() {
        return usedSize == elem.length;
    }
    //大根堆 删除堆顶元素
    public void pop() {
        if (isEmpty()){
            return;
        }
        int temp = elem[usedSize-1];
        elem[usedSize-1] = elem[0];
        elem[0] = temp;
        usedSize--;
        shiftDown(0,usedSize);
    }
    public boolean isEmpty() {
        return usedSize == 0;
    }
    //
    private void swap(int[]elem,int a,int b) {
        int temp = elem[a];
        elem[a] = elem[b];
        elem[b] = temp;
    }
    //排序（小到大） 用大根堆
    //时间复杂度O（NlgN）
    public void heapSort() {
        int end = usedSize-1;
        while (end > 0) {
            swap(elem,0,end);
            shiftDown(0,end);
            end--;
        }
    }

}
