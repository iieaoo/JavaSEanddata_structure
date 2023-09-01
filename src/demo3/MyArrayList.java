package demo3;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.Arrays;

/**
 * ClassName: MyArrayList
 * Package: demo3
 * Description:
 *  顺序表缺点：  不是很适合频繁的对数据进行插入和删除的情况  适用于给定下标查找
 *      插入元素的时候，如果插入/删除0下标，O（N） 涉及到移动位置
 * @Author 全家乐
 * @Create 2023/5/9 20:04
 * Version 1.0
 */
public class MyArrayList {
    public int[] elem;
    public int usedSize;    //存储了多少个有效的数据
    public static final int DEFAULT_SIZE = 10;

    public MyArrayList() {
        this.elem = new int[DEFAULT_SIZE];
    }
    //新增元素，默认在数组最后新增
    public void add(int data) {
        if (this.isFull()) {
            resize();
        }
        this.elem[this.usedSize] = data;
        this.usedSize++;
    }
    //扩容
    private void resize() {
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
    }
    public boolean isFull() {
       /* if (this.usedSize == this.elem.length) {
            return true;
        }
        return false;*/
        return this.usedSize == this.elem.length;
    }
    //在pos位置新增元组 O(N)
    public void add(int pos, int data) {

        checkIndex(pos);
        if (isFull()) {
            resize();
        }

        for (int i = usedSize-1; i >= pos ; i++) {
            elem[i+1] = elem[i];
        }
        elem[pos] = data;
        usedSize++;
    }
    public void checkIndex(int pos) {
        if (pos < 0 || pos > usedSize) {
            throw new IndexOutOfException("位置不合法，请检查位置的合法性");
        }
    }
    //判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }
    //查找某个元素对应的位置
    public int indexOf(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;  //因为数组没有负数下标
    }
    //获取pos位置的元素
    public int get(int pos) {
        checkGetIndex(pos);
        return elem[pos];
    }
    public void checkGetIndex(int pos) {
        if (pos < 0 || pos >= usedSize) {
            throw new IndexOutOfException("get获取元素的时候，位置不合法，请检查位置的合法性");
        }
    }
    //给pos位置的元素设为value  O(1)
    public void set(int pos, int value) {
         checkIndex(pos);
         elem[pos] = value;

    }
    //删除第一次出现的关键字Key O(N)
    public void remove(int toRemove) {
        int index = indexOf(toRemove);
        if (index == -1) {
            System.out.println("没有这个异常");
            return;
        }
        for (int i = index; i < usedSize-1; i++) {
            elem[i] = elem[i+1];
        }
        this.usedSize--;
        //elem[usedSize] == null; //如果里边是引用类型 就需要手动制空
        elem[usedSize] = 0;
    }
    //获取顺序表长度
    public int size() {
        return this.usedSize;}
    //清空顺序表
    public void clear() {
        /*引用类型
        for (int i = 0; i < usedSize; i++) {
            elem[i] = null;
        }
        usedSize = 0;
        */
        usedSize = 0;
    }
    //打印顺序表， 注意：该方法并不是顺序表中的方法， 为了方便看测试结果给出的
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        } System.out.println();
    }
}
