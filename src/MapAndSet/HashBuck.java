package MapAndSet;

/**
 * ClassName: HashBuck
 * Package: MapAndSet
 * Description:
 *  哈希桶
 * @Author 全家乐
 * @Create 2023/5/30 17:07
 * Version 1.0
 */
public class HashBuck {
    static class Node {
        public int key;
        public int val;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    public Node[] array;
    public int usedSize;
    public static double LOAD_FACTOR = 0.75;

    public HashBuck() {
        array = new Node[10];
    }

    public void put(int key,int val) {
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null) {
            if (cur.key == key) {
                cur.val = val;
                return;
            }
            cur = cur.next;
        }
        //头插法 进行插入
        //说明没有当前要插入的数据
        Node node = new Node(key,val);
        node.next = array[index];
        array[index] = node;
        usedSize++;
        if (calculateLoadFactor() >= LOAD_FACTOR) {
            //扩容
            resize();
        }
    }
    //扩容
    private void resize() {
        Node[] newArray = new Node[2 * array.length];
        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            while (cur != null) {
                int index = cur.key % newArray.length;//找到了在新的数组中的位置
                Node curNext = cur.next;//记录下cur下一个值
                cur.next = newArray[index];//头插
                newArray[index] = cur;
                cur = curNext;
            }
        }
        array = newArray;
    }

    //计算负载因子
    private double calculateLoadFactor() {
        return usedSize*0.1 / array.length;
    }

    public int get(int key) {
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null) {
            if (cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }

}
